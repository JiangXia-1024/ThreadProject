package com.jiangxia.chap1;

public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Demo14Info info = new Demo14Info();
        Thread t = new Demo14Thread(info);
        t.start();
        Thread.sleep(200);
        t.stop();
        //因为stop方法结束了线程，所以只更新了username的值，而password的值还是之前的值没有被更新
        System.out.println("username="+info.getUsername()+":password="+info.getPassword());
    }
}
class  Demo14Thread  extends Thread{
    private Demo14Info info;
    public Demo14Thread(Demo14Info info){
        this.info = info;
    }

    @Override
    public void run() {
        info.updateInfo("张飞","1111111");
    }
}

class Demo14Info{
    private String username="刘备";
    private String password="222222";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized  public void updateInfo(String username,String password){

        try {
            this.username = username;
            Thread.sleep(1000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
