package com.jiangxia.chap3;

import java.util.ArrayList;
import java.util.List;
/*
wait的条件发生变化
 */
public class Demo06 {
        public static void main(String[] args) throws InterruptedException {
            Demo06Service service = new Demo06Service();
            Thread t1 = new Demo06ThreadB(service);
            t1.start();
            Thread t2 = new Demo06ThreadB(service);
            t2.start();
            Thread.sleep(1000);
            Thread t3 = new Demo06ThreadA(service);
            t3.start();
        }
    }

    class Demo06Service{
        private List list = new ArrayList();
        private Object lock = new Object();

        public void add(){
            synchronized (lock){
                list.add("a");
                lock.notifyAll();
            }
        }
        public void subtrac(){
            try {
                synchronized (lock) {
                    if (list.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + "开始等待数据");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + "结束获取数据等待");
                    }
                    if (list.size() > 0) {
                        list.remove(0);
                    }
                    System.out.println(Thread.currentThread().getName() + "：list的大小是" + list.size());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    class Demo06ThreadA extends Thread{
        private Demo06Service service;
        public Demo06ThreadA(Demo06Service service){
            this.service = service;
        }

        @Override
        public void run() {
            service.add();
        }
    }
    class Demo06ThreadB extends Thread{
        private Demo06Service service;
        public Demo06ThreadB(Demo06Service service){
            this.service = service;
        }

        @Override
        public void run() {
            service.subtrac();
        }
    }
