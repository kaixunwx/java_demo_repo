package com.wukaixun.chuji.neibulei.nimingneibulei;

/**
 * 匿名内部类使用
 *
 * 当某些接口或抽象类子类在程序中只被调用一次时，单独定义一个子类显得浪费，可以使用匿名内部类的方法来解决
 *
 * @author wukaixun
 * @date 2020/09/24
 */
interface IMessage{
    public void send(String msg);
}

public class JavaDemo {
    public static void main(String[] args) {
        IMessage message = new IMessage() {  // 接口是不能直接实例化的，这里使用的是匿名内部类
            @Override
            public void send(String msg) {
                System.out.println(msg);
            }
        };
        message.send("哈哈哈");

    }
}
