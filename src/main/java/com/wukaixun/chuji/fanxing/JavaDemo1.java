package com.wukaixun.chuji.fanxing;

/**
 * 泛型通配符使用
 *
 * @author wukaixun
 * @date 2020/09/10
 */
class Message<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class JavaDemo1 {
    public static void main(String[] args) {
        Message<String> message1 = new Message<>();
        message1.setContent("哈哈哈哈");
        Message<Integer> message2 = new Message<>();
        message2.setContent(110);
        fun(message1);
        fun(message2);
    }


    public static void fun(Message<?> message) {   // 使用问号可以匹配所有泛型类型
        System.out.println(message.getContent());
    }
}
