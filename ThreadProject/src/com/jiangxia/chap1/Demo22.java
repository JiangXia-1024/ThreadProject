package com.jiangxia.chap1;

public class Demo22 {
    public static void main(String[] args) {
        Demo22User user = new Demo22User();
        Thread t = new Thread(){
            @Override
            public void run() {
                user.updateUser("张三",24);
            }
        };
        t.setName("A");

        Thread t1 = new Thread(){
            @Override
            public void run() {
               user.printUser();
            }
        };
        t1.start();
    }
}

class Demo22User{
    private String name="李四";
    private int age=42;

    public void updateUser(String name,int age){
        this.name = name;
        if("A".equals(Thread.currentThread().getName())){
            System.out.println("停止A线程");
            Thread.currentThread().suspend();
        }
        this.age = age;
    }

    public void printUser(){
        System.out.println("name="+name+";age="+age);
    }
}
