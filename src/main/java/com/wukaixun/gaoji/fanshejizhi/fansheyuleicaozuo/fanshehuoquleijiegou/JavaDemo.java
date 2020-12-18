package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshehuoquleijiegou;

/**
 * 使用反射获取类的结构
 */
public class JavaDemo {
    public static void main(String[] args) {
        Class<?> cls = Person.class;
        // 获取类的包名
        Package pkg = cls.getPackage();
        System.out.println("包名:" + pkg.getName());
        // 获取父类
        Class<?> parentClass = cls.getSuperclass();
        System.out.println("父类:" + parentClass.getName());
        // 获取结构
        Class<?> clazz [] = cls.getInterfaces();
        for(Class<?> temp: clazz){
            System.out.println("父接口:" + temp.getName());
        }
    }
}
