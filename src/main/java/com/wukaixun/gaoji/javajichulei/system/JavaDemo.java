package com.wukaixun.gaoji.javajichulei.system;

/**
 * System类常用方法学习
 * @author wukaixun
 * @date 2020.10.15
 */
public class JavaDemo {
    public static void main(String[] args) {
        // 获取程序运行耗时
        long start = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < 30000; i ++){
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时:" + (end - start));

        // gc
        // 调用的还是Runtime.getRuntime.gc()  gc的手动处理只有此方法
        System.gc();

    }
}
