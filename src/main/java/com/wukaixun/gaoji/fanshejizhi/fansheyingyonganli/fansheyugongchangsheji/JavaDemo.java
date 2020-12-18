package com.wukaixun.gaoji.fanshejizhi.fansheyingyonganli.fansheyugongchangsheji;

import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射机制实现高可用工厂模式
 * 传统静态工厂模式随着时间推移，接口越来越多，工厂类也需要跟进更新，在开发过程中耦合度高
 * 通过反射机制和泛型可以实现工厂设计模式不再受限于指定接口和后期维护，可以为所有的接口提供实例化对象
 *
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) {
        IMessage message = Factory.getInstance("com.wukaixun.gaoji.fanshejizhi.fansheyingyonganli.fansheyugongchangsheji.NetMessage", IMessage.class);
        message.send();
        IService service = Factory.getInstance("com.wukaixun.gaoji.fanshejizhi.fansheyingyonganli.fansheyugongchangsheji.HouseService", IService.class);
        service.service();
    }
}

class Factory {
    private Factory() {
    }

    ;  // 工厂构造方法私有化

    /**
     * @param className 接口的子类
     * @param clazz     接口的类型
     * @return 指定接口的实例化对象
     */
    public static <T> T getInstance(String className, Class<T> clazz) {
        T instance = null;
        try {
            instance = clazz.cast(Class.forName(className).getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}


interface IService {
    public void service();
}

class HouseService implements IService {
    public HouseService(){};
    @Override
    public void service() {
        System.out.println("提供住房服务!");
    }
}

interface IMessage {
    public void send();
}

class NetMessage implements IMessage {
    public NetMessage(){};
    @Override
    public void send() {
        System.out.println("发送网络消息!");
    }
}