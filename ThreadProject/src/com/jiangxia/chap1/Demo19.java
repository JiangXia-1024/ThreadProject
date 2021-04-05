package com.jiangxia.chap1;

public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Thread19 t = new Thread19();
        t.start();
        Thread.sleep(1000);
        //该方法同样已经舍弃
        t.suspend();//暂停线程
        System.out.println("Time1="+System.currentTimeMillis()+";i="+t.getI());
        Thread.sleep(1000);
        System.out.println("Time1="+System.currentTimeMillis()+";i="+t.getI());

        //回复暂停的线程
        //该方法同样已经被舍弃
        t.resume();
        Thread.sleep(1000);

        t.suspend();
        System.out.println("Time2="+System.currentTimeMillis()+";i="+t.getI());
        Thread.sleep(1000);
        System.out.println("Time2="+System.currentTimeMillis()+";i="+t.getI());

    }
}
class  Thread19 extends Thread{
    private long i=0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while(true){
            i++;
        }
    }
}
