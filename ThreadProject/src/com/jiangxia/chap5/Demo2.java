package com.jiangxia.chap5;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Demo2Thread();
        thread.start();
        Thread.sleep(1000);
        System.out.println("线程在main方法中的状态："+thread.getState());
    }
}

class Demo2Thread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("线程准备进入sleep状态");
            Thread.sleep(2000);
            System.out.println("线程结束sleep状态");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
