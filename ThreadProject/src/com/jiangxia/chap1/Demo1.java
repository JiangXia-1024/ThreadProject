package com.jiangxia.chap1;

//进程：
//狭义：进程就是正在运行的程序的实例
//广义：进程是一个具有一定的独立功能的程序，关于某个数据集合的一次运行活动
//进程是操作系统动态执行的基本单元，在传统的操作系统中，进程即是基本的分配单元，也是基本的执行单元
//terminal jps

//线程：
//线程是操作系统能够进行运算调试的最小单位，它被包含在进程中，是进程中的实际动作单位，一个线程指的是进程中的一个单一顺序的控制流，
// 一个进程可以并发多个线程，每个线程执行不同的任务。

//多线程的优点：
//1、可以把占据时间比较长的任务放到后台进行处理
//2、程序的运行速度加快

public class Demo1 {
    public static  void main(String[] args) throws InterruptedException {
        while(true){
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }
}

