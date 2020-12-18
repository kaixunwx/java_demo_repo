package com.wukaixun.chuji.fanxing;

/**
 * 泛型方法使用
 * 使用泛型方法改进传统工厂类
 * @author wukaixun
 * @date 2020/09/14
 */
interface IMessage{
    public void send(String str);
}

interface IChannel{
    public void connect();
}

class MessageImpl implements IMessage{
    public void send(String str){
        System.out.println("send:" + str);
    }
}

class DataBaseChannel implements IChannel{
    public void connect(){
        System.out.println("connect");
    }
}

class Factory{
    public static <T> T getInstance(Class<T> cls){
        try{
            return (T)Class.forName(cls.getCanonicalName()).newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}




public class JavaDemo3 {
    public static void main(String[] args) {
        IMessage message = Factory.getInstance(MessageImpl.class);
        message.send("哈哈哈");
        IChannel channel = Factory.getInstance(DataBaseChannel.class);
        channel.connect();
    }
}
