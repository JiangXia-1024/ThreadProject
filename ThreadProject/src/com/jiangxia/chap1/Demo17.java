package com.jiangxia.chap1;

public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thred17();
        //启动线程
        thread.start();
        //Thread.sleep(1000);
        thread.interrupt();

    }
}

class Thred17 extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0; i <1000 ; i++) {
                if(this.isInterrupted()){
                    System.out.println("已经是停止状态！");
                    //如果使用break那么会导致其他线程不知道，所以在这里直接抛出异常
                    // break;
                    throw  new InterruptedException();
                }
                System.out.println("i="+i);
            }
            System.out.println("这里是结束循环后的代码");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
