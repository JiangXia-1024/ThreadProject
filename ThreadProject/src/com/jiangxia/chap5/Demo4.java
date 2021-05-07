package com.jiangxia.chap5;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t= new Thread();
        t.start();

        Thread.sleep(1000);
        System.out.println("线程在main方法中的状态是："+t.getState());
    }
}

class Demo4Thread extends Thread{
    private Object lock;

    public Demo4Thread(Object ob){
        this.lock = ob;
    }

    @Override
    public void run() {
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
