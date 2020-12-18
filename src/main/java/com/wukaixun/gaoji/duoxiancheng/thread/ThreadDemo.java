package com.wukaixun.gaoji.duoxiancheng.thread;

class MyTread extends Thread {
    String title;

    public MyTread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(this.title + "运行, x:" + x);
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        new MyTread("线程a").start();
        new MyTread("线程b").start();
        new MyTread("线程c").start();
    }
}
