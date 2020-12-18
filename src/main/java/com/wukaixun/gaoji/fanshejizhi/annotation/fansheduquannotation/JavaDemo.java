package com.wukaixun.gaoji.fanshejizhi.annotation.fansheduquannotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 反射读取Annotation
 * 不是所有类型的Annotation都可以被获取，只能获取Runtime类型的Annotation
 * @author wukaixun
 * @date 2020.12.01
 */
public class JavaDemo {
    public static void main(String[] args) {
        Annotation annotations [] = IMessage.class.getAnnotations();
        System.out.println("-------获取接口所有Annotation-------");
        for(Annotation annotation: annotations){
            System.out.println(annotation);
        }

        System.out.println("------获取class类所有Annotation--------");
        Annotation annotations1 [] = MessageImpl.class.getAnnotations();
        for(Annotation annotation: annotations1){
            System.out.println(annotation);
        }

        System.out.println("--------获取send方法Annotation------");
        try {
            Method method = MessageImpl.class.getDeclaredMethod("send", String.class);
            Annotation annotations2 [] = method.getAnnotations();
            for(Annotation annotation: annotations2){
                System.out.println(annotation);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

@FunctionalInterface
@Deprecated(since = "1.0")
interface IMessage{
    public void send(String msg);
}

@SuppressWarnings("serial")
class MessageImpl implements IMessage, Serializable{
    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
