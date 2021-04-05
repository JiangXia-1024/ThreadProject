package com.jiangxia.chap2;

public class Demo4 {
    public static void main(String[] args) {
        Demo4Service service = new Demo4Service();
        Thread t1 = new Demo4ThreadA(service);
        Thread t2 = new Demo4ThreadB(service);

        t1.start();
        t2.start();
    }
}
class Demo4Service{
    synchronized public void foo1(){
        System.out.println("开始运行foo1方法，threadname："+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo1方法运行结束");
    }

    synchronized public void foo2(){
        System.out.println("开始运行foo2方法，threadname："+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo2方法运行结束");
    }
}

class Demo4ThreadA extends  Thread{
    private Demo4Service service;
    public  Demo4ThreadA(Demo4Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo1();
    }
}


class Demo4ThreadB extends  Thread{
    private Demo4Service service;
    public  Demo4ThreadB(Demo4Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo2();
    }
}