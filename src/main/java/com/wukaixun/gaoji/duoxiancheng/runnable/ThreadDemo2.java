package com.wukaixun.gaoji.duoxiancheng.runnable;

/**
 * 通过实现runnable接口来开启多线程，可以避免直接继承Thread类造成单继承限制的问题
 * @author wukaixun
 * @date 2020.10.12
 */
class MyTread2 implements Runnable{
    private String title;
    public MyTread2(String title){
        this.title = title;
    }

    public void run(){
        for(int x = 0; x < 10; x ++){
            System.out.println(this.title + "运行:" + x);
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 多线程启动还是需要调用Thread类的start方法 Tread类的构造方法可以接收一个runnable对象
        Thread thread1 = new Thread(new MyTread2("线程1"));
        Thread thread2 = new Thread(new MyTread2("线程3"));
        Thread thread3 = new Thread(new MyTread2("线程3"));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
