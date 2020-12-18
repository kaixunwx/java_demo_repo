package com.wukaixun.chuji.fanxing;

/**
 * 泛型限制通配符
 * @author wukaixun
 * @date 2020/09/10
 */
class Message1<T extends Number>{  // 限制该泛型必须为Number类及其子类
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class JavaDemo2 {
    public static void main(String[] args) {
//        Message1<String> message1 = new Message1<>();  // 由于限制，String类会报错java: 类型参数java.lang.String不在类型变量T的范围内
//        message1.setContent("哈哈哈哈");
        Message1<Integer> message2 = new Message1<>();
        message2.setContent(110);
//        fun(message1);
        fun(message2);
    }

    public static void fun(Message1<? extends Number> message){   // 使用问号可以匹配所有泛型类型
        System.out.println(message.getContent());
    }
}
