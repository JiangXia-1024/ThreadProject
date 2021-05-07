package com.jiangxia.chap5;

/**
 * block状态
 * author:jiangxia
 * date:2021-04-11
 */

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Demo3Service service = new Demo3Service();
        Thread t1 = new Demo3Thread(service);
        t1.setName("A");
        t1.start();
        Thread t2 = new Demo3Thread(service);
        t2.setName("B");

        Thread.sleep(10);
        t2.start();
        System.out.println("线程B在main方法中的状态："+t2.getState());
    }
}
class Demo3Service{
    synchronized static public void foo(){
        try{
            System.out.println(Thread.currentThread().getName()+"调用了foo方法");
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Demo3Thread extends Thread{
    private Demo3Service service;
    public Demo3Thread(Demo3Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo();
    }
}