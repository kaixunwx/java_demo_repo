package com.wukaixun.gaoji.fanshejizhi.classloader;

import java.lang.reflect.Method;

public class JavaDemo {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> cls = classLoader.loadData("com.wukaixun.gaoji.fanshejizhi.classloader.Message");
//        System.out.println(cls);
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("send");
        method.invoke(obj);
    }
}
