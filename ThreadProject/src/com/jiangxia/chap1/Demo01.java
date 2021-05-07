package com.jiangxia.chap1;

/**
 * thread的sleep方法
 * author：jiangxia
 * date:2021-04-14
 */
public class Demo01 {
    public static void main(String[] args) {
        Thread t = new Thread1();
        System.out.println("开始时间"+System.currentTimeMillis());
        //t.start方法启动线程
        t.start();
        System.out.println("结束时间"+System.currentTimeMillis());
    }
}
/**
 * 继承Thread类的方式实现线程
 */
class Thread1 extends  Thread{
    @Override
    public void run() {
        /**
         * 线程休眠10秒
         */
        try {
            System.out.println("线程开始时间："+System.currentTimeMillis());
            Thread.sleep(10000);
            System.out.println("线程结束时间"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
