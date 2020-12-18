package com.wukaixun.gaoji.duoxiancheng.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable启动子线程并获取返回值，观察单线程执行和多线程执行区别
 */
public class CallableDemo2 {
    public static void main(String[] args) throws Exception{
        System.out.println("执行任务操作1");
        // 单线程执行
//        int temp = 0;
//        for(int i =0; i < Integer.MAX_VALUE; i ++){
//            temp += i;
//        }

        // 启动子线程执行
        FutureTask<Integer> task = new FutureTask<>(()-> {
            int temp = 0;
            for(int i =0; i < Integer.MAX_VALUE; i ++){
                temp += i;
            }
            return temp;
        });
        new Thread(task).start();


        System.out.println("执行任务操作2");
        System.out.println("执行任务操作3");
//        System.out.println("temp:" + temp);
        System.out.println("结果:" + task.get());
    }
}
