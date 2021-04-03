package com.jiangxia.chap1;
//多个线程共享同一个count
public class Demo7 {
    public static void main(String[] args) {
        Thread t = new Demo7Thread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
class Demo7Thread extends Thread{
    private  int count = 5;

    @Override
    public void run() {
        count -- ;
        System.out.println(Thread.currentThread().getName()+": count="+count);
    }
}

