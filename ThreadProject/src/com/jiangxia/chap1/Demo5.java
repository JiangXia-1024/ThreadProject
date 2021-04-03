package com.jiangxia.chap1;

public class Demo5 {
    public static void main(String[] args) {
        Runnable r = new Demo5Thread();
        Thread t = new Thread(r);
        t.start();
        System.out.println("运行了main方法");
    }
}
class Demo5Thread implements Runnable{

    @Override
    public void run() {
        System.out.println("运行了run方法");
    }
}
