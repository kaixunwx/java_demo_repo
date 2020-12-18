package com.wukaixun.gaoji.kaifazhichileiku.optional;

import java.util.Optional;

/**
 * Optional类学习使用
 * Optional类主要用来处理null
 * @author wukaixun
 * @date 2020/10/20
 * Optional.of 保存数据，不允许为空
 * Optional.ofNullable 保存数据，允许为空
 * Optional.get 获取数据
 * Optional.orElse 获取数据，为空时候返回其他值
 */
public class JavaDemo {
    public static void main(String[] args) {
//        MessageUtil.useMessage(MessageUtil.getMessage().get());
        MessageUtil.useMessage(MessageUtil.getMessage().orElse(new MessageImpl())); // 当使用Optional.ofNullable返回null时，可以使用orElse方法处理null
    }
}


interface IMessage{
    public String getContent();
}

class MessageUtil{
    private MessageUtil(){}
    public static Optional<IMessage> getMessage(){
//        return Optional.of(new MessageImpl());
//        return Optional.of(null);  // Optional.of遇到null会直接报错
        return Optional.ofNullable(null); // Optional.ofNullable可以返回null，但调用get方法会报Exception in thread "main" java.util.NoSuchElementException: No value present
    }

    public static void useMessage(IMessage msg){
        System.out.println(msg.getContent());  // 有可能因为传入null，导致NullPointerException
    }
}

class MessageImpl implements IMessage{
    @Override
    public String getContent() {
        return "www.baidu.com";
    }
}
