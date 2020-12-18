package com.wukaixun.gaoji.duoxiancheng.shouhuxiancheng;

/**
 * 守护线程的使用
 * 守护线程是跟随程序所有线程执行的线程
 * 当程序中所有线程执行完毕后，守护线程也会直接执行完毕
 * JVM中最大的守护线程就是GC线程(垃圾回收线程)
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "运行: i=" + i);
            }
        }, "用户线程");

        Thread demonThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "运行: i=" + i);
            }
        }, "守护线程");
        demonThread.setDaemon(true);  // 设置为守护线程
        userThread.start();
        demonThread.start();
    }
}
