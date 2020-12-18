package com.wukaixun.chuji.fangfayinyong.jingtaifangfa;

/**
 * 方法引用之静态方法引用
 * @author wukaixun
 * @date 2020.09.24
 */

interface IFunction<P, R>{ // P表示参数类型，R表示返回值类型
    public R change(P p);
}

public class JavaDemo {
    public static void main(String[] args) {
        IFunction<Integer, String> func = String:: valueOf;  // 引用了String类当ValueOf方法
        String str = func.change(100);
        System.out.println(str.length());
    }
}
