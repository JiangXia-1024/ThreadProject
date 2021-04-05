package com.jiangxia.chap1;

public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread18();
        t.start();
        Thread.sleep(20);
        t.interrupt();
    }
}
class Thread18 extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String s = new String();
            }
            System.out.println("开始线程");
            Thread.sleep(20000);
            System.out.println("结束线程");
        }catch (InterruptedException e){
            System.out.println("异常进入catch代码块");
            e.printStackTrace();
        }
    }
}