package com.jiangxia.chap3;

public class Demo05 {
        public static void main(String[] args) throws InterruptedException {
            Object lock = new Object();
            Thread t1 = new Demo05Thread(lock);
            t1.start();
            Thread.sleep(2000);
            t1.interrupt();
        }
}

class Demo05Service{
    public void foo(Object lock){
        try{
            synchronized (lock){
                System.out.println("准备开始等待");
                lock.wait();
                System.out.println("结束等待");
            }
        }catch (InterruptedException e){
            System.out.println("出现异常，因为wait状态的线程被interrupt了，所以出现中断的异常");
            e.printStackTrace();
        }
    }
}

class Demo05Thread extends Thread{
    private Object lock;
    public Demo05Thread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        Demo05Service service = new Demo05Service();
        service.foo(lock);
    }
}
