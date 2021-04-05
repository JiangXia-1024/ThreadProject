package com.jiangxia.chap2;

/**
 * 线程的同步机制 成员变量不是线程安全的
 * author：jiangxia
 * date：2021-04-05
 */

public class Demo2 {
    public static void main(String[] args) {
        Servie2 s = new Servie2();

        Thread t1 = new ThreadA(s);
        t1.start();

        Thread t2 = new ThreadB(s);
        t2.start();
    }
}


class Servie2{
    private int num = 0;

    //set 方法设置synchronized关键字
    synchronized public void set(String string){
        num = 0;
        if("a".equals(string)){
            num = 100;
            System.out.println("a set");

            try {
                //睡眠的目的是为了等待另一个线程修改num的值
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            num = 200;
            System.out.println("b set");
        }
        System.out.println("string="+string+";num="+num);

    }
}

class ThreadA extends Thread{
    private Servie2 servie2;

    public ThreadA(Servie2 servie2){
        this.servie2 = servie2;
    }

    @Override
    public void run() {
        servie2.set("a");
    }
}


class ThreadB extends  Thread{
    private Servie2 servie2;

    public ThreadB(Servie2 servie2){
        this.servie2 = servie2;
    }

    @Override
    public void run() {
        servie2.set("b");
    }
}
