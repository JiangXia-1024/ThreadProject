package com.jiangxia.chap3;

public class Demo19 {
        public static void main(String[] args) {
            ThreadLocal tl = new ThreadLocal();
            // 获取当前线程存储的数据
            if (tl.get() == null){
                // 保存当前线程的数据
                System.out.println("The Value is NUll");
                tl.set("ThreadLocal test Demo!");
            }
            System.out.println(tl.get());
            System.out.println(tl.get());
        }
    }
