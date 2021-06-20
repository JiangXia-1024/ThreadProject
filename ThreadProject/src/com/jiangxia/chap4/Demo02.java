package com.jiangxia.chap4;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个生产者 多个消费者
 */
public class Demo02 {
    public static void main(String[] args) {
        Food02 food02 = new Food02();
        Thread cook = new Cook02(food02);
        cook.setName("厨师");
        cook.start();

        Thread[] waiters = new Thread[5];
        for (int i = 0; i < 5; i++) {
            waiters[i] = new Waiter02(food02);
            waiters[i].setName("服务员"+(char)('A'+i));
            waiters[i].start();
        }
    }
}

class Food02{
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
class Cook02 extends Thread{
    private Food02 food02;

    public Cook02(Food02 food02) {
        this.food02 = food02;
    }

    @Override
    public void run() {
        while (true){
            food02.addin(Math.random()+"");
        }
    }
}


/**
 * 消费者
 */
class Waiter02 extends Thread{
    private Food02 food02;

    public Waiter02(Food02 food02) {
        this.food02 = food02;
    }

    @Override
    public void run() {
        while (true){
            food02.getout();
        }
    }
}