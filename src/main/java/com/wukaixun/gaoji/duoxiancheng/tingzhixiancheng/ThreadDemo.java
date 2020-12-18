package com.wukaixun.gaoji.duoxiancheng.tingzhixiancheng;

/**
 * 优雅的停止线程
 * 使用一个flag标志，通过其他线程修改这个标志来控制目标线程的运行状态
 * 不建议使用Tread类中的stop destroy等方法
 * @author wukaixun
 * @date 2020.10.13
 */
public class ThreadDemo {
    public static boolean flag = true;
    public static void main(String[] args) throws Exception{
        new Thread(()-> {
            long num = 0;
            while (flag){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "运行, + num:" + num ++);
            }
        }, "子线程运行").start();
        Thread.sleep(200);
        flag = false;
    }
}
