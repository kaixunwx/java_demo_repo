package com.wukaixun.gaoji.fanshejizhi.fansheyingyonganli.fansheyudanlimoshi;

/**
 * 利用反射机制实现标准的懒汉式单例模式
 *
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> Singleton.getInstance().print(), "单例消费端-" + 1).start();
        }
    }
}

class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println(Thread.currentThread().getName() + "****实例化对象****");
    }

    ;

    public static Singleton getInstance() {
//        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
//        }
        return singleton;
    }

    public void print() {
        System.out.println("哈哈哈哈哈哈");
    }
}
