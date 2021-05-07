package com.jiangxia.chap2;

/**
 * 同步是不具有机继承性的
 * author：jiangxia
 * date：2021-04-08
 */

public class Demo8 {
    public static void main(String[] args) {
        DemoService8B serviceB = new DemoService8B();
        Thread t1 = new Demo8Thread(serviceB);
        t1.setName("A");
        t1.start();

        Thread t2 = new Demo8Thread(serviceB);
        t2.setName("B");
        t2.start();
    }
}
class DemoService8A{
    synchronized public void foo(){
        try{
            System.out.println("父类：" + Thread.currentThread().getName() + "，开始于" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("父类：" + Thread.currentThread().getName() + "，结束于" + System.currentTimeMillis());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class DemoService8B extends  DemoService8A{
    public void foo(){
        try {
            System.out.println("子类：" + Thread.currentThread().getName() + "，开始于" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("子类：" + Thread.currentThread().getName() + "，结束于" + System.currentTimeMillis());
            super.foo();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Demo8Thread extends Thread{
    DemoService8B service;
    public Demo8Thread(DemoService8B service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo();
    }
}
