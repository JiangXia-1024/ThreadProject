package com.jiangxia.chap1;

public class Demo4 {
    public static void main(String[] args) {
        Thread t1 = new Demo4Thread(1);
        Thread t2 = new Demo4Thread(2);
        Thread t3 = new Demo4Thread(3);
        Thread t4 = new Demo4Thread(4);
        Thread t5 = new Demo4Thread(5);
        //start的执行顺序与线程的启动顺序不一致，所以以下的输出的顺序具有随机性
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

class Demo4Thread extends Thread{

    private int val;

    public  Demo4Thread(int val){
        this.val = val;
    }

    @Override
    public void run() {
        System.out.println("val="+val);
    }
}
