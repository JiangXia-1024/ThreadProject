package com.jiangxia.chap3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 */
public class Demo13 {
    public static void main(String[] args) {
        //公平锁
        //Demo13Service demo13Service = new Demo13Service(true);
        //非公平锁
        Demo13Service demo13Service = new Demo13Service(false);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Demo13Thread(demo13Service);
        }
        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
    }
}

class Demo13Service{
    private Lock lock;

    /**
     * 通过isFair参数控制锁的类型，true就是公平锁，false为非公平锁
     * @param isFair
     */
    public Demo13Service(boolean isFair) {
        this.lock = new ReentrantLock(isFair);
    }

    public void hello(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"获得锁。。。");
        lock.unlock();
    }
}

class Demo13Thread extends Thread{
    private Demo13Service demo13Service;

    public Demo13Thread(Demo13Service demo13Service) {
        this.demo13Service = demo13Service;
    }

    @Override
    public void run() {
        demo13Service.hello();
    }
}
