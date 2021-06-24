package com.jiangxia.chap3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 */
public class Demo17 {
    public static void main(String[] args) {
        Demo17Service service = new Demo17Service();
        Thread t1 = new Demo17ThreadA(service);
        t1.setName("读线程A");
        t1.start();
        Thread t2 = new Demo17ThreadA(service);
        t2.setName("读线程B");
        t2.start();
        Thread t3 = new Demo17ThreadB(service);
        t3.setName("写线程A");
        t3.start();
        Thread t4 = new Demo17ThreadB(service);
        t4.setName("写线程B");
        t4.start();
    }
}

class Demo17Service{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try{
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得读锁于" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "解除读锁于" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        try{
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得写锁于" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "解除写锁于" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}


class Demo17ThreadA extends Thread{
    private Demo17Service service;
    public Demo17ThreadA(Demo17Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}

class Demo17ThreadB extends Thread{
    private Demo17Service service;
    public Demo17ThreadB(Demo17Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
