package com.wukaixun.gaoji.duoxiancheng.xianchengtongbu;

/**
 * 使用synchronized 同步方法实现线程同步
 * 线程同步会导致性能下降
 * @author wukaixun
 * @date 2020.10.13
 */
class MyThread3 implements Runnable{
    private int ticket = 5;

    public synchronized boolean sale(){
        if(this.ticket > 0){
            System.out.println(Thread.currentThread().getName() + "卖票----, 剩余票数:"+ this.ticket --);
            try {
                Thread.sleep(200);  // 模拟延迟操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else{
            System.out.println("票卖光了!");
            return false;
        }
    }

    @Override
    public void run() {
        while (this.sale()){
            ;
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3();
        new Thread(mt, "票贩子1").start();
        new Thread(mt, "票贩子2").start();
        new Thread(mt, "票贩子3").start();
    }
}
