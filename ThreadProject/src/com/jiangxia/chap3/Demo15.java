package com.jiangxia.chap3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//condition唤醒不同线程
public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Method15 method15 = new Method15();
        Thread t1 = new Demo15Thread_A(method15);
        t1.setName("A");
        t1.start();

        Thread t2 = new Demo15Thread_B(method15);
        t2.setName("B");
        t2.start();

        Thread.sleep(2000);
        method15.conditionSignalAll_A();
    }
}

class Method15{
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void conditionAwiat_A(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行conditionAwiat_A");
            conditionA.await();
            System.out.println(Thread.currentThread().getName()+"结束执行conditionAwiat_A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void conditionAwiat_B(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行conditionAwiat_B");
            conditionA.await();
            System.out.println(Thread.currentThread().getName()+"结束执行conditionAwiat_B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignalAll_A(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "唤醒所有的线程在");
            //唤醒所有的线程
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignalAll_B(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "唤醒所有的线程在");
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

class Demo15Thread_A extends Thread{
    private Method15 method15;
    public Demo15Thread_A(Method15 method15){
        this.method15 = method15;
    }

    @Override
    public void run() {
        method15.conditionAwiat_A();
    }
}

class Demo15Thread_B extends Thread{
    private Method15 method15;
    public Demo15Thread_B(Method15 method15){
        this.method15 = method15;
    }

    @Override
    public void run() {
        method15.conditionAwiat_B();
    }
}
