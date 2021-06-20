package com.jiangxia.chap4;

import java.util.ArrayList;
import java.util.List;

/**
 * 多生产者一消费者
 */
public class Demo03 {
    public static void main(String[] args) {
        Food03 food03 = new Food03();
        /**
         * 多个生产者
         */
        Thread[] cookies = new Thread[5];
        for (int i = 0; i < cookies.length; i++) {
            cookies[i] = new Cook03(food03);
            cookies[i].setName("厨师" + (char)('A' + i));
            cookies[i].start();
        }


        Thread waiter = new Waiter03(food03);
        waiter.setName("服务员");
        waiter.start();
    }
}

class Food03{
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
class Cook03 extends Thread{
    private Food03 food03;

    public Cook03(Food03 food03) {
        this.food03 = food03;
    }

    @Override
    public void run() {
        while (true){
            food03.addin(Math.random()+"");
        }
    }
}


/**
 * 消费者
 */
class Waiter03 extends Thread{
    private Food03 food03;

    public Waiter03(Food03 food03) {
        this.food03 = food03;
    }

    @Override
    public void run() {
        while (true){
            food03.getout();
        }
    }
}


