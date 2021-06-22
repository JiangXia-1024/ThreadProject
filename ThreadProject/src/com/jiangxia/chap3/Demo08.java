package com.jiangxia.chap3;

/**
 * join方法的使用
 * join方法的作用是等待线程对象销毁
 * join与synchroinzed区别：join的内部使用wait方法进行等待，而synchronized关键字使用的是『对象锁』的机制作为同步。
 */
public class Demo08 {
    public static void main(String[] args) throws InterruptedException {
        Thread08 thread08 = new Thread08();
        thread08.start();
        thread08.join();
        System.out.println("子线程执行完成以后再执行");
    }
}
class Thread08 extends Thread{
    @Override
    public void run() {
        try {
            int value = (int) (Math.random() * 10000);
            System.out.println("需要等待" + value + "毫秒");
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}