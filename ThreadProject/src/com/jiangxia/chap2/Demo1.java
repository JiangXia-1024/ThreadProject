package com.jiangxia.chap2;

/**
 * 线程的同步机制 局部变量是线程安全的
 * author：jiangxia
 * date：2021-04-05
 */
public class Demo1 {
    public static void main(String[] args) {
        Servie1 servie1 = new Servie1();

        Thread t1 = new Thread1(servie1);
        t1.start();

        Thread t2 = new Thread2(servie1);
        t2.start();


    }
}
class Servie1{

    public void set(String string){
        int num = 0;

        if("a".equals(string)){
            num = 100;
            System.out.println("a set");

            try {
                //睡眠的目的是为了等待另一个线程修改num的值
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            num = 200;
            System.out.println("b set");
        }
        System.out.println("string="+string+";num="+num);

    }
}

class Thread1 extends  Thread{
    private Servie1 servie1;

    public Thread1(Servie1 servie1){
        this.servie1 = servie1;
    }

    @Override
    public void run() {
        servie1.set("a");
    }
}


class Thread2 extends  Thread{
    private Servie1 servie1;

    public Thread2(Servie1 servie1){
        this.servie1 = servie1;
    }

    @Override
    public void run() {
        servie1.set("b");
    }
}
