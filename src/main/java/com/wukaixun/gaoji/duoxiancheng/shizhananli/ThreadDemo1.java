package com.wukaixun.gaoji.duoxiancheng.shizhananli;


/**
 * 多线程实战案例1 加减法操作
 * 4个线程对象，2个加法， 2个减法， 交替执行
 *
 * @author wukaixun
 * @date 2020.10.13
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        AddThread at = new AddThread(resource);
        SubThread st = new SubThread(resource);
        new Thread(at, "加法线程-A").start();
        new Thread(at, "加法线程-B").start();
        new Thread(st, "减法线程-X").start();
        new Thread(st, "减法线程-Y").start();
    }
}

/**
 * 线程操作资源对象
 */
class Resource {
    private int num = 0;
    private boolean flag = true;  // flag为true, 可以进行加法操作 flag为false， 可以进行减法操作

    public synchronized void add() throws Exception{
        while (!this.flag) {  // 注意
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("[加法操作]" + Thread.currentThread().getName() + " num:" + this.num);
        this.flag = false; // 加法完成，flag为false， 可以进行减法操作
        super.notifyAll();  // 完成加法后，尝试唤醒等待中的减法线程
    }

    public synchronized void sub() throws Exception{
        while (this.flag) {  // 注意
            super.wait();
        }
        Thread.sleep(100);
        this.num--;
        System.out.println("[减法操作]" + Thread.currentThread().getName() + " num:" + this.num);
        this.flag = true;
        super.notifyAll();
    }
}

class AddThread implements Runnable {
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable {
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
