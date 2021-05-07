package com.jiangxia.chap5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Callable接口
 * author:jiangxia
 * date:2021-04-11
 */
public class Demo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Demo5Callable();
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        Thread t1 = new Thread(future);
        t1.start();
        System.out.println("线程返回的值是："+future.get());

        }
    }

class Demo5Callable implements Callable<Integer>{
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName()+"调用了callable接口的实现类");
        int val = (int)(Math.random()*10);
        System.out.println("准备返回的值是："+val);
        return val;
    }
}
