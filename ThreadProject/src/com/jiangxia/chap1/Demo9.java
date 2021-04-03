package com.jiangxia.chap1;

import java.sql.SQLOutput;

public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Demo9Thread();
        System.out.println("准备启动线程:"+t.isAlive());
        t.start();//启动线程
        System.out.println("线程已启动："+t.isAlive());
    }
}
class Demo9Thread extends Thread{
    public Demo9Thread(){
        System.out.println("构造方法开始");
        //Thread.currentThread().isAlive() 主线程的状态
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(this.isAlive());
        System.out.println("构造方法结束");
    }
    @Override
    public void run() {
        System.out.println("run方法开始");
        //当前线程的状态
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("run方法的运行状态："+this.isAlive());
        System.out.println("run方法结束");
    }
}
