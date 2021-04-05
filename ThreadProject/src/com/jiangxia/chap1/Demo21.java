package com.jiangxia.chap1;

public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Demo21Thread();
        thread.start();
        Thread.sleep(10);
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