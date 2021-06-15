package com.jiangxia.chap3;

public class Demo04 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo04ThreadA(lock);
        t1.start();
        Thread.sleep(5000);
        Thread t2 = new Demo04ThreadB(lock);
        t2.start();
    }
}

class Demo04ThreadA extends Thread{
    private Object lock;
    public Demo04ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println("进入同步代码块于" + System.currentTimeMillis());
                lock.wait(3000);
                System.out.println("结束同步代码块于" + System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Demo04ThreadB extends Thread{
    private Object lock;
    public Demo04ThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("开始唤醒线程在" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束唤醒线程在" + System.currentTimeMillis());
        }
    }
}
