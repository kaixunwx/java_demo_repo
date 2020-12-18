package com.wukaixun.gaoji.fanshejizhi.fansheyingyonganli.fansheshilihuaduixiang;

/**
 * 反射实例化对象
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("com.wukaixun.gaoji.fanshejizhi.Student");
        Object obj = cls.newInstance(); // jdk1.9之前反射实例化应用
//        Object obj = cls.getConstructor().newInstance(); // jdk1.9之后反射实例化应用
        System.out.println(obj);
    }
}
