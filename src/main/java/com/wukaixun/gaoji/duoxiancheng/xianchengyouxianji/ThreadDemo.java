package com.wukaixun.gaoji.duoxiancheng.xianchengyouxianji;

/**
 * 线程优先级
 * 优先级高的线程不一定先执行，只是先执行的概率大
 * 主线程和默认线程的优先级都是5
 * @author wukaixun
 * @date 2020.10.12
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Runnable run = ()-> {
            for(int x = 0; x < 10; x++){
                System.out.println(Thread.currentThread().getName() + "执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread threadA = new Thread(run, "线程a");
        Thread threadB = new Thread(run, "线程b");
        Thread threadC = new Thread(run, "线程c");
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
//        threadA.start();
//        threadB.start();
//        threadC.start();

        // 主线程默认优先级
        System.out.println("主线程默认优先级:" + Thread.currentThread().getPriority());
        // 默认线程优先级
        System.out.println("默认线程优先级:" + new Thread().getPriority());

    }
}
