package com.jiangxia.chap3;

public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo03ThreadA(lock);
        t1.setName("A");
        t1.start();
        Thread t2 = new Demo03ThreadA(lock);
        t2.setName("B");
        t2.start();
        Thread t3 = new Demo03ThreadA(lock);
        t3.setName("C");
        t3.start();
        Thread.sleep(1000);
        Thread t4 = new Demo03ThreadB(lock);
        t4.start();
    }
}
class Demo03Service{
    public void foo(Object lock){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "进入了foo方法，准备执行wait方法");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + "结束了foo方法");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Demo03ThreadA extends Thread{
    private Object lock;
    public Demo03ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        Demo03Service service = new Demo03Service();
        service.foo(lock);
    }
}
class Demo03ThreadB extends Thread{
    private Object lock;
    public Demo03ThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            // notify仅随机唤醒一个线程
//            lock.notify();
            // 如果要唤醒多个线程，需要多次调用notify方法
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
            // 如果要唤醒多个线程，可以调用notifyAll方法
            lock.notifyAll();
        }
    }
}
