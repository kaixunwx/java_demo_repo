package com.wukaixun.gaoji.duoxiancheng.xianchengtongbu;

/**
 * 使用synchronized 同步代码块实现线程同步
 * 同步处理会导致程序的执行性能下降
 * @author wukaixun
 * @date 2020.10.13
 */
class MyThread2 implements Runnable{
    private int ticket = 10000;

    @Override
    public void run() {
        while (true){
            synchronized (this){  // 每次只允许一个线程访问括号中的代码块
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "卖票----, 剩余票数:"+ this.ticket --);
                    try {
                        Thread.sleep(10);  // 模拟延迟操作
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
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        new Thread(mt, "票贩子1").start();
        new Thread(mt, "票贩子2").start();
        new Thread(mt, "票贩子3").start();
    }
}
