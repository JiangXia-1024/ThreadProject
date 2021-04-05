package com.jiangxia.chap2;

/**
 * synchronized锁可重入
 * author：jiangxia
 * date：2021-04-05
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Demo06Thread();
        t.start();
    }
}

class Demo06Service{
    synchronized public void foo1(){
        System.out.println("foo1方法");
        foo2();
    }
    synchronized public void foo2(){
        System.out.println("foo2方法");
        foo3();
    }
    synchronized public void foo3(){
        System.out.println("foo3方法");
    }
}

class Demo06Thread extends Thread{
    @Override
    public void run() {
//        Demo06Service service = new Demo06Service();
//        service.foo1();
        //改用继承子类
        Demo06ServiceB serviceB = new Demo06ServiceB();
        serviceB.foo4();
    }
}

//继承
class Demo06ServiceB extends Demo06Service{
    synchronized public void foo4(){
        System.out.println("foo4方法");
        super.foo1();
    }
}
