package com.jiangxia.chap3;

import java.sql.SQLOutput;

/**
 * join方法与异常
 * join与interrupte方法如果彼此遇到，则会出现异常，但进程并没有结束，原因是ThreadA还在继续运行，线程A并没有出现 异常，是正常状态下继续 执行。
 */
public class Demo09 {
    public static void main(String[] args) throws InterruptedException {
        Thread09_B t = new Thread09_B();
        t.start();
        Thread.sleep(10);
        Thread t2 = new Thread09_C(t);
        t2.start();
    }
}

class Thread09_A extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // 耗时操作
            String s = new String();
            Math.random();
        }
    }
}

class Thread09_B extends Thread{
    @Override
    public void run() {
        try {
            Thread09_A t1 = new Thread09_A();
            t1.start();
            t1.join();
            System.out.println("B线程正常结束");
        } catch (InterruptedException e) {
            System.out.println("B线程异常结束");
            e.printStackTrace();
        }
    }
}

class Thread09_C extends Thread{
    private Thread09_B t;
    public Thread09_C(Thread09_B t){
        this.t = t;
    }

    @Override
    public void run() {
        t.interrupt();
    }
}