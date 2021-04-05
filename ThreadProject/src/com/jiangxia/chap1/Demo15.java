package com.jiangxia.chap1;

public class Demo15 {
    public static void main(String[] args) {
        Thread thread = new Thread15();
        thread.start();
        //使用interrupt方法中断线程
        thread.interrupt();
        System.out.println("是否已经停止1："+thread.isInterrupted());
        System.out.println("是否已经停止2："+Thread.interrupted());
    }
}

class Thread15 extends  Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("run方法:i="+i);
        }
    }
}
