package com.jiangxia.chap1;

/**
 * suspend不释放锁
 * author：jiangxia
 * date：2021-04-16
 */
public class Demo20A {

}
class Service20A{
    synchronized public void printString(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"开始运行");
        if(threadName.equals("A")){
            System.out.println("线程Asuspend");
        }
    }
}
class Thread20A extends Thread{

}
