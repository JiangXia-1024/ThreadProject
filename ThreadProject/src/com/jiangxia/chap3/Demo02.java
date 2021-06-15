package com.jiangxia.chap3;

public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new DemoThread1(lock);
        t1.start();
        Thread.sleep(2000);
        Thread t2 = new DemoThread2(lock);
        t2.start();
    }
}

class DemoThread1 extends Thread{
    private Object lock;

    public DemoThread1(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            try {
                System.out.println("线程一开始等待"+System.currentTimeMillis());
                lock.wait();
                System.out.println("线程一结束等待"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DemoThread2 extends Thread{
    private Object lock;

    public DemoThread2(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("线程二发出通知"+System.currentTimeMillis());
                lock.notify();
                System.out.println("线程二结束通知"+System.currentTimeMillis());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
