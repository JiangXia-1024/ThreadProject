package com.jiangxia.chap2;

/**
 * 线程的同步机制 成员变量不是线程安全的
 * author：jiangxia
 * date：2021-04-05
 */

public class Demo3 {
    public static void main(String[] args) {
        Servie3 s1 = new Servie3();
        Servie3 s2 = new Servie3();

        Thread t1 = new Demo3ThreadA(s1);
        Thread t2 = new Demo3ThreadB(s2);
        t1.start();
        t2.start();
    }
}


class Servie3{
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

class Demo3ThreadA extends Thread{
    private Servie3 servie3;

    public Demo3ThreadA(Servie3 servie3){
        this.servie3 = servie3;
    }

    @Override
    public void run() {
        servie3.set("a");
    }
}


class Demo3ThreadB extends  Thread{
    private Servie3 servie3;

    public Demo3ThreadB(Servie3 servie3){
        this.servie3 = servie3;
    }

    @Override
    public void run() {
        servie3.set("b");
    }
}
