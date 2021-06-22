package com.jiangxia.chap3;

/**
 * join(long)与sleep(long)的区别
 * 方法join(long)的功能在内部使用wait(long)来实现同步，所以joing(long)方法具有释放同步锁的特点。
 */
public class Demo11 {
    public static void main(String[] args) {
        Thread11_A thread11_a = new Thread11_A();
        Thread11_B thread11_b = new Thread11_B(thread11_a);
        thread11_b.start();
        Thread11_C thread11_c = new Thread11_C(thread11_a);
        thread11_c.start();
    }
}

class Thread11_A extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("线程A开始于："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("线程A结束于："+System.currentTimeMillis());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void foo(){
        System.out.println("方法执行时间" + System.currentTimeMillis());
    }
}


class Thread11_B extends Thread {
    private Thread11_A thread11_a;

    public Thread11_B(Thread11_A thread11_a) {
        this.thread11_a = thread11_a;
    }

    @Override
    public void run() {
        synchronized (thread11_a) {
            try {
                thread11_a.start();
//                Thread.sleep(6000);
                thread11_a.join();
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    String s = new String();
                    Math.random();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Thread11_C extends Thread {
    private Thread11_A thread11_a;

    public Thread11_C(Thread11_A thread11_a) {
        this.thread11_a = thread11_a;
    }

    @Override
    public void run() {
        thread11_a.foo();
    }
}