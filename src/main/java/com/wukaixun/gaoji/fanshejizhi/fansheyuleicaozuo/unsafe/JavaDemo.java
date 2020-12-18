package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe工具类使用
 * @author wukaixun
 * @date 2020.11.25
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        // Unsafe类的构造方法是私有的，只能通过反射获取实例对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true); // 解除封装
        Unsafe unsafeObj = (Unsafe) field.get(null); // static属性不需要传入实例化对象
        // Unsafe
        Singleton singleton = (Singleton) unsafeObj.allocateInstance(Singleton.class);
        singleton.print();

        // Unsafe绕过了JVM管理机制，可以在没有实例化对象的情况下获取一个Singleton类对象
    }
}

class Singleton{
    private Singleton(){
        System.out.println("******构造方法******");
    };

    public void print(){
        System.out.println("哈哈哈哈哈");
    }
}
