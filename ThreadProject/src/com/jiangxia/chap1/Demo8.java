package com.jiangxia.chap1;

/**
 * 线程的getName和getId
 * author：jiangxia
 * date：2021-04-14
 */
public class Demo8 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("线程的Name:"+thread.getName());
        System.out.println("线程的ID:"+thread.getId());
    }
}


