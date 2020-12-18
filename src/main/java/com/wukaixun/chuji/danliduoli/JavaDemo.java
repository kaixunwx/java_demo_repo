package com.wukaixun.chuji.danliduoli;

import java.text.SimpleDateFormat;

/**
 * 单例设计模式
 *
 * @author wukaixun
 * @date 2020/09/16
 */

class Singleton {
    private static Singleton instance = null;  // 使用final关键字，可以保证INSTANCE不会被再次实例化

    private Singleton() {
    }

    ;  // 构造方法私有化，外部就不能通过构造方法来创建新的实例

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("呵呵");
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        Singleton instance;
        instance = Singleton.getInstance();
        instance.print();
    }
}
