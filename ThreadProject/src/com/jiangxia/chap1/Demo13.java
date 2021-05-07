package com.jiangxia.chap1;

/**
 * 停止线程之stop方法
 * author：jiangxia
 * date：2021-04-15
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo13Thread();
        t.start();
        Thread.sleep(2000);
        //该方法有个删除线表示已经被删除 不建议使用
        //stop方法会产生异常
        t.stop();
    }

}

class  Demo13Thread extends Thread{
    @Override
    public void run() {
        try{
            while(true){
                System.out.println("run方法 Time="+System.currentTimeMillis());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
                e.printStackTrace();
        }catch (ThreadDeath threadDeath){
            System.out.println("进入catch块");
            threadDeath.printStackTrace();
        }
    }
}