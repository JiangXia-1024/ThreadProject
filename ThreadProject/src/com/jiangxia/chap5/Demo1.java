package com.jiangxia.chap5;

/**
 * 线程的状态
 * author：jiangxia
 * date：2021-04-14
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo1Thread();
        System.out.println("线程在main方法的状态A："+t.getState());
        Thread.sleep(2000);
        t.start();
        Thread.sleep(2000);
        System.out.println("线程在main方法的状态B："+t.getState());

    }
}
class Demo1Thread extends Thread{
    public Demo1Thread(){
        System.out.println("构造方法的状态："+Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("Run方法的状态："+Thread.currentThread().getState());
    }
}
