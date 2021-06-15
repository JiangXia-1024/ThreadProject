package com.jiangxia.chap3;

public class Demo01 {
    public static void main(String[] args) {
        try {
            /*String str = new String();
            // Exception in thread "main" java.lang.IllegalMonitorStateException
            str.wait();*/

            String str = new String();
            System.out.println("同步代码块前");
            synchronized (str){
                System.out.println("同步代码块后");
                str.wait();
                System.out.println("wait执行之后");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
