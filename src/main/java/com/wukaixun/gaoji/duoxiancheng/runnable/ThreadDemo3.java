package com.wukaixun.gaoji.duoxiancheng.runnable;

/**
 * 通过lambda表达式启动多线程任务
 * @author wukaixun
 * @date 2020.10.12
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        for(int x =1; x <=3; x ++){
            String title = "线程" + x;
            Runnable run = () -> {
                for(int y = 0; y < 10; y ++){
                    System.out.println(title + "运行:" + y);
                }
            };
            new Thread(run).start();
        }
    }
}
