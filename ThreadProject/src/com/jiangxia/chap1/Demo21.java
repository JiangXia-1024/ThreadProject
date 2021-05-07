package com.jiangxia.chap1;

/**
 * suspend的print问题
 * author：jiangxia
 * date：2021-04-16
 */
public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Demo21Thread();
        thread.start();
        Thread.sleep(100);
        thread.suspend();
        System.out.println("main线程结束");
    }
}

class Demo21Thread extends Thread{
    private long i=0;
    @Override
    public void run() {
        while (true){
            i++;
            System.out.println("i="+i);
        }
    }
}