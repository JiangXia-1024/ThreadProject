package com.jiangxia.chap2;

/**
 * 非this对象具有的优点
 * autohr:jiangxia
 * date:2021-05-17
 */

public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Demo16Service service = new Demo16Service();
        Thread t1 = new Demo16ThreadA(service);
        t1.start();
        Thread.sleep(10);
        Thread t2 = new Demo16ThreadB(service);
        t2.start();
    }
}

class Demo16Service{
    private Object lockObject = new Object();
    public void foo(){
        try {
            synchronized (lockObject) {
                System.out.println("foo方法开始时间" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("foo方法结束时间" + System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void foo2(){
        System.out.println("foo2方法开始时间" + System.currentTimeMillis());
        System.out.println("foo2方法结束时间" + System.currentTimeMillis());
    }
}

class Demo16ThreadA extends Thread{
    private Demo16Service service;
    public Demo16ThreadA(Demo16Service service){
        this.service  =service;
    }

    @Override
    public void run() {
        service.foo();
    }
}

class Demo16ThreadB extends Thread{
    private Demo16Service service;
    public Demo16ThreadB(Demo16Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo2();
    }
}