package com.jiangxia.chap3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 实现生产者消费者
 */
public class Demo16 {

    public static void main(String[] args) {
        Demo16Service service = new Demo16Service();
        // 一生产一消费
//        Thread producer = new Demo05ProducerThread(service);
//        producer.start();
//
//        Thread consumer = new Demo05ConsumerThread(service);
//        consumer.start();

        // 多生产多消费
        int size = 2;
        Thread[] producers = new Thread[size];
        Thread[] consumers = new Thread[size];

        for (int i = 0; i < size; i++) {
            char c = (char)('A' + i);
            producers[i] = new Demo16ProducerThread(service);
            producers[i].setName("生产者" + c);
            producers[i].start();

            consumers[i] = new Demo16ConsumerThread(service);
            consumers[i].setName("消费者" + c);
            consumers[i].start();
        }
    }
}

class Demo16Service{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private String val = "";

    public void set(){
        try{
            lock.lock();
            while(!"".equals(val)){
                System.out.println(Thread.currentThread().getName() + "开始等待");
                condition.await();
            }
            val = System.currentTimeMillis() + "-" + System.nanoTime();
            System.out.println(Thread.currentThread().getName() + "生产值：" + val);
            //condition.signal();
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(){
        try{
            lock.lock();
            while("".equals(val)){
                System.out.println(Thread.currentThread().getName() + "开始等待");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "消费值：" + val);
            val = "";
//            condition.signal();
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Demo16ProducerThread extends Thread{
    private Demo16Service service;
    public Demo16ProducerThread(Demo16Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.set();
        }
    }
}

class Demo16ConsumerThread extends Thread{
    private Demo16Service service;
    public Demo16ConsumerThread(Demo16Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.get();
        }
    }
}

