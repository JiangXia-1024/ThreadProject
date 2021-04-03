package com.jiangxia.chap1;

public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Demo3Thread();
        //t.start() 输出的顺序具有随机性
        t.start();
//        t.run()会先输出10次运行run方法再执行10次运行main方法
//        t.run();
        try {
            for (int i = 0; i <10 ; i++) {
                System.out.println("运行main方法");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo3Thread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i <10; i++) {
                System.out.println("运行run方法");
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}