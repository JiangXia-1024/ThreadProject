package com.jiangxia.chap1;

public class Demo20 {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread20();
//        //修改t1线程的名字
//        t1.setName("A");
//        t1.start();
//        Thread.sleep(10);
//
//        Thread t2 = new Thread20();
//        t2.start();
        Demo20Service demo20Service = new Demo20Service();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                demo20Service.printInfo();
            }
        };
        t1.setName("A");
        t1.start();
        Thread.sleep(10);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                demo20Service.printInfo();
            }
        };
        t2.start();

    }
}
//class Thread20 extends Thread{
//    Demo20Service demo20Service = new Demo20Service();
//    @Override
//    public void run() {
//
//        demo20Service.printInfo();
//    }
//}
class Demo20Service{
    //对该方法加synchronized关键字
    synchronized public void printInfo(){
        System.out.println("线程开始");
        if("A".equals(Thread.currentThread().getName())){
            System.out.println("A线程suspend");
            Thread.currentThread().suspend();
        }
        System.out.println("线程结束");
    }
}