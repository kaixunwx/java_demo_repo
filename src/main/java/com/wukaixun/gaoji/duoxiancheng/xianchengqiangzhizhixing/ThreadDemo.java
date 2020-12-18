package com.wukaixun.gaoji.duoxiancheng.xianchengqiangzhizhixing;

/**
 * 线程强制执行
 * @author wukaixun
 * @date 2020.10.12
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(()-> { // 子线程
            for(int x = 0; x < 100; x ++){
                if(x == 5){  // 当子线程执行到5时，强制执行主线程
                    try{
                        mainThread.join();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行x:" + x);
            }
        }, "子线程");
        thread.start();

        for(int x =0; x < 100; x ++){ // 主线程
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "执行x:" + x);
        }
    }
}
