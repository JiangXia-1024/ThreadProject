package com.jiangxia.chap1;

public class Demo6 {
    public static void main(String[] args) {
        Thread t1 = new Demo6Thread();
        Thread t2 = new Demo6Thread();
        Thread t3 = new Demo6Thread();


        t1.start();
        t2.start();
        t3.start();


    }


}
class  Demo6Thread extends Thread{
    private  int count = 5;

    @Override
    public void run() {
        while (count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+": count="+count);
        }
    }
}
