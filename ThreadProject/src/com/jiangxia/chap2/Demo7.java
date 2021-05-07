package com.jiangxia.chap2;

/**
 * 锁的自动释放
 * author jiangxia
 * date 2021-04-08
 */
public class Demo7 {
    public static void main(String[] args) {
        DemoService7 service7 = new DemoService7();
        Thread t1 = new DemoThread7(service7);
        t1.setName("A");
        t1.start();

        Thread t2 = new DemoThread7(service7);
        t2.start();
    }
}
class DemoService7{
    synchronized public void foo(){
        if("A".equals(Thread.currentThread().getName())){
            System.out.println("线程A开始于"+System.currentTimeMillis());
            while(true){
                //NumberFormatException
                if((""+ Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("线程A结束于："+System.currentTimeMillis());
                    Integer.parseInt("A");
                }
            }
        }else{
            System.out.println("线程B开始于"+System.currentTimeMillis());
        }
    }
}
class DemoThread7 extends Thread{
    private DemoService7 service7;

    public DemoThread7(DemoService7 service7){
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.foo();
    }
}
