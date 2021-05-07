package com.jiangxia.chap1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程的实现之使用Callable接口
 */
public class Demo05 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Demo05Callable();
        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("线程返回的值是："+task.get());
    }
}

class Demo05Callable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"调用了callable接口的实现类");
        int val = (int)(Math.random()*10);
        System.out.println("准备返回的值是："+val);
        return val;
    }
}
