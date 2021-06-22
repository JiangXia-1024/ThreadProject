package com.jiangxia.chap3;

/**
 * join(long)方法使用:方法join(long)中的参数是设定等待的时间
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread10();
        t.start();
        t.join(2000);
        System.out.println("主线程结束于" + System.currentTimeMillis());
    }
}

class Thread10 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("子线程开始于" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("子线程结束于" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}