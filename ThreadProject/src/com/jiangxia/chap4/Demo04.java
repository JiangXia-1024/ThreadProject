package com.jiangxia.chap4;

import java.util.ArrayList;
import java.util.List;

/**
 * 多生产者 多消费者
 */
public class Demo04 {
    public static void main(String[] args) {
        Food04 food04 = new Food04();
        /**
         * 多个生产者 多个消费者
         */
        int size = 5;
        Thread[] cookies = new Thread[size];
        Thread[] waiters = new Thread[size];

        for (int i = 0; i < size; i++) {
            char c = (char)('A' + i);
            cookies[i] = new Cook04(food04);
            cookies[i].setName("厨师" + c);
            cookies[i].start();

            waiters[i] = new Waiter04(food04);
            waiters[i].setName("服务员" + c);
            waiters[i].start();
        }
    }
}

class Food04{
    private List<String> foodlist = new ArrayList<>();

    synchronized public void addin(String food){
        try{
            if(foodlist.size()==1){
                System.out.println("厨师:"+Thread.currentThread().getName()+"等待中");
                this.wait();
            }
            foodlist.add(food);
            System.out.println(Thread.currentThread().getName() + "：生产食物" + food);
            System.out.println(Thread.currentThread().getName() + "：还有" +  foodlist.size() + "个食物");
            this.notify();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public String getout(){
        String returnfood = null;
        try {
            /**
             * 当没有食物时
             */
            while (foodlist.size()==0){
                System.out.println("服务员："+Thread.currentThread().getName()+"等待中");
                this.wait();
            }
            returnfood = foodlist.get(0);
            foodlist.remove(0);
            System.out.println("服务员："+Thread.currentThread().getName() + "：取走" + returnfood);
            System.out.println(Thread.currentThread().getName() + "：还有" + foodlist.size() + "个食物");
//            this.notify();
            this.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return returnfood;
    }
}

/**
 * 生产者
 */
class Cook04 extends Thread{
    private Food04 food04;

    public Cook04(Food04 food04) {
        this.food04 = food04;
    }

    @Override
    public void run() {
        while (true){
            food04.addin(Math.random()+"");
        }
    }
}


/**
 * 消费者
 */
class Waiter04 extends Thread{
    private Food04 food04;

    public Waiter04(Food04 food04) {
        this.food04 = food04;
    }

    @Override
    public void run() {
        while (true){
            food04.getout();
        }
    }
}