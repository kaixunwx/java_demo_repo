package com.wukaixun.chuji.fangfayinyong.tedingleifangfa;

/**
 * 方法引用之特定类方法引用
 * @author wukaixun
 * @date 2020.09.24
 */
@FunctionalInterface
interface IFunction<P>{
     public int compare(P p1, P p2);
}

public class JavaDemo {
    public static void main(String[] args) {
        IFunction<String> func = String:: compareTo;
        System.out.println(func.compare("A", "a"));
    }
}
