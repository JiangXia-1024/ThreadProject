package com.jiangxia.chap1;

/**
 * 守护线程
 * author：jiangxia
 * date：2021-04-15
 */
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread26();
        thread.setDaemon(true);//把指定线程设置为守护线程
        thread.start();
        //IllegalThreadStateException 错误信息
        //thread.setDaemon(true);//把指定线程设置为守护线程
        Thread.sleep(5000);
        System.out.println("主线程结束");
    }
}
class  Thread26 extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("当前时间："+System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
