package com.jiangxia.chap1;

/**
 * getPriority、setPriority
 * author;jiangxia
 * date:2021-04-14
 */
public class Demo24 {
    public static void main(String[] args) {
        //默认的优先级是5
        System.out.println("主线程的运行优先级："+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(9);
        System.out.println("使用setPriority()方法设置优先级后的主线程的优先级："+Thread.currentThread().getPriority());
        Thread t = new Thread24();
        t.start();
    }
}
class Thread24 extends Thread{
    @Override
    public void run() {
        //由于线程的优先级具有继承性，所以在主线程使用了Thread.currentThread().setPriority(9)后，该线程的优先级也是9
        System.out.println("线程的优先级："+this.getPriority());
    }
}
