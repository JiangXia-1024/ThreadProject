package com.jiangxia.chap2;

import java.sql.SQLOutput;

/**
 * synchronized代码块的同步
 * author：jiangxia
 * date：2021-05-17
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        DemoService13 service13 = new DemoService13();
        Thread t1 = new Demo13Thread1(service13);
        t1.start();
        Thread.sleep(100);
        Thread t2 = new Demo13Thread2(service13);
        t2.start();
    }
}

//声明一个服务
class DemoService13{
    public void foo1(){
        //同步代码块
        synchronized (this){
            //睡眠2s
            try {
                System.out.println("foo1方法开始时间："+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("foo1方法结束时间："+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void foo2(){
        synchronized (this){
            System.out.println("foo2方法开始时间: "+System.currentTimeMillis());
            System.out.println("foo2方法结束时间: "+System.currentTimeMillis());
        }
    }
}

//声明一个子线程
class Demo13Thread1 extends Thread{
    private DemoService13 service13;

    //构造方法
    public Demo13Thread1(DemoService13 service){
        this.service13 = service;
    }

    public void run(){
        service13.foo1();
    }

}

//再声明一个子线程
class Demo13Thread2 extends Thread{
    private DemoService13 service13;

    //构造方法
    public Demo13Thread2(DemoService13 service){
        this.service13 = service;
    }

    public void run(){
        service13.foo2();
    }

}