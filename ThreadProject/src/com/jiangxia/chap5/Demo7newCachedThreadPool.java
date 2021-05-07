package com.jiangxia.chap5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCachedThreadPool
 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
 * 就会回收部分空闲的线程(60秒没有执行的线程)，当任务数量增加时，以可以智能的添加新的线程来处理任务。
 * 这个线程池不会对线程池的大小进行限制，线程池的大小完全依赖操作系统(JVM)能够创建的最大线程大小。
 */
public class Demo7newCachedThreadPool {
    public static void main(String[] args) {
        //创建一个可以缓存的线程池：newCachedThreadPool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //线程池运行
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
