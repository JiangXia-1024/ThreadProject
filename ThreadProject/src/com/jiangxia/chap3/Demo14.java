package com.jiangxia.chap3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition的使用
 */
public class Demo14 {
    private Lock lock = new ReentrantLock();
    //condition对象是依赖于lock对象的，​condition对象需要通过lock对象进行创建出来(调用Lock对象的newCondition()方法)
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Mehtod14 mehtod14 = new Mehtod14();
        Thread t = new Demo14_Thread(mehtod14);
        t.start();
        Thread.sleep(2000);
        mehtod14.conditionsignal();
    }
}

class Mehtod14{
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void conditionaWait(){
        //加锁
        lock.lock();
        System.out.println("conditionaWait方法开始："+System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "拿到锁了");
        System.out.println(Thread.currentThread().getName() + "等待信号");
        try {
            //这里需要抛出异常
            condition.await();
            System.out.println("conditionaWait方法结束:"+System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "拿到信号");
            //解锁
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void conditionsignal(){
        try {
            lock.lock();
            System.out.println("conditionsignal方法开始:" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出信号");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Demo14_Thread extends Thread{
    private Mehtod14 mehtod14;
    public Demo14_Thread(Mehtod14 mehtod14){
        this.mehtod14 = mehtod14;
    }

    @Override
    public void run() {
        mehtod14.conditionaWait();
    }
}
