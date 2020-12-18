package com.wukaixun.gaoji.fanshejizhi.annotation.zidingyiannotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 自定义Annotation
 * @author wukaixun
 * @date 2020.12.01
 */
public class JavaDemo {
    public static void main(String[] args) {
        try {
            Method method = Message.class.getDeclaredMethod("send", String.class);
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            String title = annotation.title();
            String url = annotation.url();
            String msg = title + "("+ url +")";
            method.invoke(Message.class.getDeclaredConstructor().newInstance(), msg);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    public String title();
    public String url() default "www.baidu.com";
}

class Message{
    @MyAnnotation(title = "BAIDU")
    public void send(String msg){
        System.out.println("【消息发送】" + msg);
    }
}
