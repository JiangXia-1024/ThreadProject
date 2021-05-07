package com.jiangxia.chap1;

/**
 * suspend和resume导致数据不同步的问题
 * author：jiangxia
 * date：2021-04-16
 */

public class Demo22 {
    public static void main(String[] args) throws InterruptedException {
        Demo22User user = new Demo22User();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                user.updateUser("貂蝉", "女");
            }
        };
        t1.setName("A");
        t1.start();

        Thread.sleep(10);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                user.printUserInfo();
            }
        };
        t2.start();
    }
}

class Demo22User {
    private String name = "吕布";
    private String gen = "男";

    public void updateUser(String name, String gen){
        this.name = name;
        if ("A".equals(Thread.currentThread().getName())){
            System.out.println("停止A线程");
            Thread.currentThread().suspend();
        }
        this.gen = gen;
    }

    public void printUserInfo(){
        System.out.println("姓名=" + name + ", 性别=" +gen);
    }
}