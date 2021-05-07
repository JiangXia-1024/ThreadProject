package com.jiangxia.chap5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool:
 * 创建固定大小的线程池。
 * 每次提交一个任务就创建一个线程，直到线程池达到最大大小。
 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行而异常结束，
 * 那么线程池会补充一个新的线程。
 */
public class Demo8newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
