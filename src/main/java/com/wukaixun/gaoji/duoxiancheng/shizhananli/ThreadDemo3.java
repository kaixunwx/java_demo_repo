package com.wukaixun.gaoji.duoxiancheng.shizhananli;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 多线程实战案例3
 * 用3个线程实现抢答程序
 * @author wukaixun
 * @date 2020.10.14
 */
class MyThread implements Callable<String>{
    private boolean flag = false;

    @Override
    public String call() throws Exception {
        synchronized (this){
            if (!this.flag){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功!";
            } else{
                return Thread.currentThread().getName() + "抢答失败!";
            }
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) throws Exception{
        MyThread mt = new MyThread();
        FutureTask<String> taskA = new FutureTask<>(mt);
        FutureTask<String> taskB = new FutureTask<>(mt);
        FutureTask<String> taskC = new FutureTask<>(mt);
        new Thread(taskA, "抢答者A").start();
        new Thread(taskB, "抢答者B").start();
        new Thread(taskC, "抢答者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());

    }
}
