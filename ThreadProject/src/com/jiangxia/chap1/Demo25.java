package com.jiangxia.chap1;

import java.util.Random;

/**
 * 线程优先级
 * author :jiangxia
 * date:2021-04-05
 */
public class Demo25 {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            Thread t1 = new Thread25();
            t1.setName("A"+i);
            //t1线程设置最高级别
            t1.setPriority(Thread.MAX_PRIORITY);
            t1.start();

            Thread t2 = new Thread25();
            t2.setName("B"+i);
            //t2线程设置最低级别
            t2.setPriority(Thread.MIN_PRIORITY);
            t2.start();
        }
    }
}
class Thread25 extends Thread{
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <50000 ; j++) {
                Random r = new Random();
                count = i*j + r.nextInt();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("线程"+this.getName()+"执行完成使用了"+(end-start)+"毫秒");
    }
}

