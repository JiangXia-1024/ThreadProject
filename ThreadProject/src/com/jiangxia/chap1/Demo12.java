package com.jiangxia.chap1;

/**
 * 线程停止的方法之：使用退出标志
 * author：jiangxia
 * date：2021-04-15
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Demo12Thread t = new Demo12Thread();
        t.start();
        Thread.sleep(2000);
        t.stopThread();
    }
}

class Demo12Thread extends Thread{
    private  boolean flag = true;
    @Override
    public void run() {
        try {
            while (flag){
                System.out.println("Time="+System.currentTimeMillis());
                Thread.sleep(1000);
            }
            System.out.println("线程执行结束");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 定义一个停止线程的方法
     */
    public void stopThread(){
        //将标志位改为flase
        flag = false;
    }
}
