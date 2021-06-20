package com.jiangxia.chap4;

//一个生产者与一个消费者
public class Demo01 {
    public static void main(String[] args) throws IllegalMonitorStateException {
        Object lock = new Object();
        Thread t1 = new Demo01cook(lock);
        t1.start();
        Thread t2 = new Demo01Waiter(lock);
        t2.start();

    }
}

//食物
class Food {
//    public static int counter = 0;
//
//    private int i;  //代表生产的第几个菜
//
//    public Food() {
//        i = ++counter;
//    }
//
//
//    @Override
//    public String toString() {
//        return "第" + i + "个菜";
//    }

    public static String food="";

}

// 生产者（厨师）
class Demo01cook extends Thread {
    //模拟送餐窗口队列
    private Object lock;

    public Demo01cook(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            while(true){
                //线程休眠模拟炒菜时间
                Thread.sleep(3000);
                synchronized (lock){
                    //如果传菜窗口不为空，即有菜
                    if(!Food.food.equals("")){
                        lock.wait();
                    }
                    System.out.println(System.currentTimeMillis() + "_" + System.nanoTime()+":厨师炒好菜了！等待服务员上菜。。。。");
                    lock.notify();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
// 消费者（服务员）
class Demo01Waiter extends Thread{
    //模拟送餐窗口队列
    private Object lock;

    public Demo01Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            while(true){
                synchronized (lock){
                    if ("".equals(Food.food)){
                        lock.wait();
                    }
                    System.out.println(System.currentTimeMillis() + "_" + System.nanoTime()+":服务员没有菜可以送了，等待厨师炒菜。。。。。");
                    Food.food = "";
                    lock.notify();
                    //线程休眠模拟送菜时间
                    Thread.sleep(2000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

