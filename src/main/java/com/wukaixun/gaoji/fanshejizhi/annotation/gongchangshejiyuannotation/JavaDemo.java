package com.wukaixun.gaoji.fanshejizhi.annotation.gongchangshejiyuannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/**
 * 工厂设计模式与Annotation结合
 * 由于Annotation的存在，所以对于面向接口的编程的配置处理将可以直接通过Annotation完成配置，可以使代码更加简洁
 * @author wukaixun
 * @date 2020.12.01
 */
public class JavaDemo {
    public static void main(String[] args) {
        MessageService service = new MessageService();
        service.send("哈哈哈哈");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> clazz();
}

@UseMessage(clazz = NetMessageImpl.class)  // 可以通过更换Annotation达到调用不同子类的效果
class MessageService{
    private IMessage message;

    public MessageService(){
        Class<?> clazz = MessageService.class.getAnnotation(UseMessage.class).clazz();
        this.message = (IMessage) Factory.getInstance(clazz);
    }

    public void send(String msg){
        this.message.send(msg);
    }
}

class Factory{
    private Factory(){};

    public static Object getInstance(Class<?>clazz){
        try{
            InvocationHandler handler = new Handler(clazz.getDeclaredConstructor().newInstance());
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

class Handler implements InvocationHandler{
    private Object target;

    public Handler(Object target) {
        this.target = target;
    }

    private boolean connect(){
        System.out.println("【代理操作】打开消息通道");
        return true;
    }

    private void close(){
        System.out.println("【代理操作】关闭消息通道");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if(this.connect()){
                return method.invoke(target, args);
            } else{
                throw new Exception("【ERROR】消息发送失败!");
            }
        } finally {
            this.close();
        }
    }
}

interface IMessage{
    public void send(String msg);
}

class MessageImpl implements IMessage{
    @Override
    public void send(String msg) {
        System.out.println("【消息发送】" + msg);
    }
}

class NetMessageImpl implements IMessage{
    @Override
    public void send(String msg) {
        System.out.println("【网络消息发送】" + msg);
    }
}
