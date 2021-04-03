package com.jiangxia.chap1;

public class Demo10 {
    public static void main(String[] args) {
        Thread t = new Demo10Thread();
        System.out.println("开始时间："+System.currentTimeMillis());
        t.start();
        System.out.println("结束时间："+System.currentTimeMillis());
    }
}
class Demo10Thread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("线程开始时间：" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("线程结束时间："+System.currentTimeMillis());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
