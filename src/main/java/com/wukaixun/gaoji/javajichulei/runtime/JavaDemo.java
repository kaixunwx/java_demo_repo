package com.wukaixun.gaoji.javajichulei.runtime;

/**
 * Runtime类学习
 *
 * @author wukaixun
 * @date 2020.10.15
 */
public class JavaDemo {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        // 获取本机cpu内核数
        System.out.println("[1]可用进程数:" + run.availableProcessors());

        // 获取最大内存  默认为本机最大内存的1/4
        System.out.println("[1]最大内存:" + run.maxMemory());

        // 获取可用内存  默认为本机最大内存的1/64
        System.out.println("[1]可用内存:" + run.totalMemory());

        // 获取空闲内存 剩余可用内存
        System.out.println("[1]空闲内存:" + run.freeMemory());
        String str = "";
        for(int i = 0; i < 5000; i ++){
            str += i;
        }

        // 再次获取内存空间信息
        System.out.println("[2]最大内存:" + run.maxMemory());
        System.out.println("[2]可用内存:" + run.totalMemory());
        System.out.println("[2]空闲内存:" + run.freeMemory());

        // 手动调用gc后再次查询内存信息
        run.gc();
        System.out.println("[3]最大内存:" + run.maxMemory());
        System.out.println("[3]可用内存:" + run.totalMemory());
        System.out.println("[3]空闲内存:" + run.freeMemory());



    }
}
