package com.jiangxia.chap2;

public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Demo9Service service = new Demo9Service();
        Thread t1 = new Demo9ThreadA(service);
        t1.setName("A");

        Thread t2 = new Demo9ThreadA(service);
        t2.setName("B");

        t1.start();
        t2.start();

        Thread.sleep(20000);

        long start = Demo9Untils.start1 > Demo9Untils.start2 ? Demo9Untils.start2 : Demo9Untils.start1;
        long end = Demo9Untils.end1 > Demo9Untils.end2 ? Demo9Untils.end1 : Demo9Untils.end2;
        System.out.println("总耗时：" + (end - start) / 1000 + "秒");

    }
}

class Demo9Untils{
    static long start1;
    static long start2;

    static long end1;
    static long end2;
}

class Demo9Service{
    synchronized public void foo(){
        try{
            System.out.println("开始任务");
            Thread.sleep(5000);
            System.out.println("长时任务处理完成，线程" + Thread.currentThread().getName());
            System.out.println("结束任务");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Demo9ThreadA extends Thread{
    public Demo9Service service;

    public Demo9ThreadA(Demo9Service service){
        this.service = service;
    }

    @Override
    public void run() {
        Demo9Untils.start1 = System.currentTimeMillis();
        service.foo();
        Demo9Untils.end1 = System.currentTimeMillis();
    }
}

class Demo9ThreadB extends Thread{
    public Demo9Service service;

    public Demo9ThreadB(Demo9Service service){
        this.service = service;
    }

    @Override
    public void run() {
        Demo9Untils.start2 = System.currentTimeMillis();
        service.foo();
        Demo9Untils.end2 = System.currentTimeMillis();
    }
}
