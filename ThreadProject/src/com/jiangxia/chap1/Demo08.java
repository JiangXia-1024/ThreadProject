package com.jiangxia.chap1;

/**
 * 线程的currentThread方法
 * author：jiangxia
 * date：2021-04-14
 */
public class Demo08 {
    public static void main(String[] args) {
        Thread t = new Demo8Thread();
        t.start();
        System.out.println("main方法："+Thread.currentThread().getName());
    }
}
class Demo8Thread extends Thread{
    public Demo8Thread(){
        System.out.println("构造方法开始：");
        System.out.println("构造方法："+Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("构造方法结束：'");
    }

    @Override
    public void run() {
        System.out.println("run方法开始：");
        System.out.println("run方法："+Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("run方法结束：");
    }
}
