package com.jiangxia.chap3;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadLocal的使用
 */
public class Demo18 {

    private List<String> list = new ArrayList<String>();

    public static final ThreadLocal<Demo18> text = ThreadLocal.withInitial(Demo18::new);

    public static void push(String list){
        text.get().list.add(list);
    }

    public static List<String> pop(){
        List<String> list = text.get().list;
        text.remove();
        System.out.println("size:"+text.get().list.size());
        return list;
    }

    public static void main(String[] args) {
        Demo18.push("ThreadLocal Test Demo");
        System.out.println(text.get().list);
        Demo18.pop();
    }
}

