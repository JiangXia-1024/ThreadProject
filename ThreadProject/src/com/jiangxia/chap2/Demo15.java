package com.jiangxia.chap2;

/**
 * 使用任意对象作为对象锁
 * author:jiangxia
 * date:2021-05-17
 */
public class Demo15 {
    public static void main(String[] args) {
        Demo15Service service = new Demo15Service();
        Thread t1 = new Demo15Thread(service);
        t1.setName("线程1");
        t1.start();
        Thread t2 = new Demo15Thread(service);
        t2.setName("线程2");
        t2.start();
    }
}

class Demo15Service{
    //锁对象
    private Object lockobject = new Object();

    public void foo(){
        //synchronized锁定对象
        synchronized (lockobject){
            try {
                System.out.println(Thread.currentThread().getName() + "开始于" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "结束于" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Demo15Thread extends Thread{
    private Demo15Service service;
    public Demo15Thread(Demo15Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo();
    }
}