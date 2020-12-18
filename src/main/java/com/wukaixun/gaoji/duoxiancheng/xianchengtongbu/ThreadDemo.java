package com.wukaixun.gaoji.duoxiancheng.xianchengtongbu;

/**
 * 引出线程同步问题
 * 当多个线程同时操作同一资源，并且遇到延迟的情况下，就会出现非正常的资源占用问题，例如余票会出现负数
 * @author wukaixun
 * @date 2020.10.13
 */
class MyThread implements Runnable{
    private int ticket = 5;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println("-----卖票----, 剩余票数:"+ this.ticket --);
                try {
                    Thread.sleep(200);  // 模拟延迟操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else{
                System.out.println("票卖光了!");
                break;
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "票贩子1").start();
        new Thread(mt, "票贩子2").start();
        new Thread(mt, "票贩子3").start();
    }
}
