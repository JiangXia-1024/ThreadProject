package com.jiangxia.chap1;

/*
* java使用多线程的方式
* 1、1继承thread类
*    步骤：
*    1、创建一个类，这个类需要继承Thread
*    2、重写Thread类的run方法 业务代码
*    3、实例化创建好的线程类
*    4、调用实例化对鞋的start方法
*    线程运行的特点：
*    1、随机性
*    在多线程编程中，代码的执行结果与代码的执行顺序或者调用顺序是无关的，线程是一个子任务，
*    CPU以不确定的方式或者是以随机的时间来调用线程中的run方法
*    直接调用线程对象的run方法，不是启动线程，而是由main主线程来调用run方法
*    见Demo3
*    2、start的执行顺序于线程的启动顺序的不一致
*    见Demo4
* 2、实现Runnable接口
*    步骤：
*    1、创建一个类实现runnable接口
*    2、重写runnable接口的run方法
*    3、实例化创建的这个类
*    4、实例化一个Thread对象并将第三步创建的对象通过thread的构造方法进行传递
*    5、调用Thread对象的start方法
*    见Demo5
*
*    使用Thread继承的方式开发多线程应用程序是由局限性的，因为java是单继承，为了改变这种局限性，可以使用
*    Runnable接口的方式来实现多线程
* */
public class Demo2 {
    public static void main(String[] args) {
        Thread t = new Demo2Thread();
        //启动了线程
        t.start();
        System.out.println("运行了main方法");
    }
}

class Demo2Thread extends Thread{

    public void run(){

        System.out.println("运行了run方法");
    }
}
