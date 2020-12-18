package com.wukaixun.gaoji.duoxiancheng.xianchengzhongduan;

/**
 * 线程中断操作
 *
 * @author wukaixun
 * @date 2020.10.12
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> {
            try{
                System.out.println("----我需要休息10秒钟----");
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.out.println("谁打扰我休息!");
            }
        });
        thread.start();
        Thread.sleep(1000);
        if(!thread.isInterrupted()){ // 判断线程是否中断
            thread.interrupt();  // 中断睡眠
        }
    }
}
