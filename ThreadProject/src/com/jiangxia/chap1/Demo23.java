package com.jiangxia.chap1;

//yield方法
public class Demo23 {
    public static void main(String[] args) {
        Thread t1 = new Demo23Thread();
        t1.start();
    }
}
class Demo23Thread extends Thread{
    @Override
    public void run() {
        int count =0;
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            yield();
            count+=i;
        }
        long endtime = System.currentTimeMillis();
        System.out.println("计算总共用时："+(endtime-starttime)+"毫秒");
    }
}
