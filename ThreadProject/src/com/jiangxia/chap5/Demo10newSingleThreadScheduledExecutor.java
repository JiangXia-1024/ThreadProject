package com.jiangxia.chap5;

        import java.util.concurrent.Executors;
        import java.util.concurrent.ScheduledExecutorService;
        import java.util.concurrent.TimeUnit;

public class Demo10newSingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("准备执行："+System.currentTimeMillis());
        // 定时执行
        // scheduleAtFixedRate(需要执行的线程, 第1个需要执行的线程延迟多长时间行, 两个线程间相隔的时间, 使用到时间单位)
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"开始执行于"+System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"执行结束于"+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },2,5,TimeUnit.SECONDS);

    }
}
