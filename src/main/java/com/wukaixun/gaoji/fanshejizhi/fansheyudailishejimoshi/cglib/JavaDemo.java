package com.wukaixun.gaoji.fanshejizhi.fansheyudailishejimoshi.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaDemo {
    public static void main(String[] args) {
        Message realObject = new Message();  // 真实业务对象
        Enhancer enhancer = new Enhancer();  // 负责代理操作的程序类
        enhancer.setSuperclass(realObject.getClass());  // 假定一个父类
        enhancer.setCallback(new MessageProxy(realObject));  // 设置代理类
        Message proxyObject = (Message) enhancer.create();  // 创建代理对象
        proxyObject.send();

    }
}

class MessageProxy implements MethodInterceptor {
    private Object target;
    public MessageProxy(Object target){
        this.target = target;
    }

    public boolean connect(){
        System.out.println("【消息发送】连接消息通道");
        return true;
    }

    public void close(){
        System.out.println("【消息发送】关闭消息通道");
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnData = null;
        if(this.connect()){
           returnData = method.invoke(this.target, args);
           this.close();
        }
        return returnData;
    }
}

class Message{
    public void send(){
        System.out.println("【消息发送】www.baidu.com");
    }
}
