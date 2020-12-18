package com.wukaixun.chuji.fangfayinyong.shiliduixiangfangfa;

/**
 * 方法引用之实例对象方法引用
 * @author wukaixun
 * @date 2020.09.24
 */
@FunctionalInterface
interface IFunction<R>{
    public R upper();
}

public class JavaDemo {
    public static void main(String[] args) {
        IFunction<String> func = "wukaixun":: toUpperCase; // 引用了实例对象'wukaixun'的转大写方法
        System.out.println(func.upper());
    }
}
