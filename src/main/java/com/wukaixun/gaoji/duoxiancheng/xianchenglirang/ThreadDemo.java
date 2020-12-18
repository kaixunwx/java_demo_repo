package com.wukaixun.gaoji.duoxiancheng.xianchenglirang;

/**
 * 线程礼让
 *
 * @author wukaixun
 * @date 2020.10.12
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> {
            for (int x = 0; x < 100; x++) {
                if(x % 3 == 0){ // 每次x除以3等于0， 子线程礼让主线程执行
                    Thread.yield();
                    System.out.println("子线程礼让");
                }
                System.out.println("子线程执行:" + x);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        for (int x = 0; x < 100; x++) {
            System.out.println("主线程执行:" + x);
            Thread.sleep(100);
        }
    }
}
