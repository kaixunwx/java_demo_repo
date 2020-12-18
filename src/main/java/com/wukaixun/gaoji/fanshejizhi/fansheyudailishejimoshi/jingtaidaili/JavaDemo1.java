package com.wukaixun.gaoji.fanshejizhi.fansheyudailishejimoshi.jingtaidaili;

/**
 * 静态代理模式
 * @author wukaixun
 * @date 2020.11.30
 */
public class JavaDemo1 {
    public static void main(String[] args) {
        IMessage message = new MessageProxy(new MessageImpl());
        message.send();
    }
}

interface IMessage{
    public void send();
}

class MessageImpl implements IMessage{
    @Override
    public void send() {
        System.out.println("【消息发送】www.baidu.com");
    }
}


class MessageProxy implements IMessage{
    private IMessage message;

    public MessageProxy(IMessage message){
        this.message = message;
    }

    public boolean connect(){
        System.out.println("【消息发送】连接消息通道");
        return true;
    }

    public void close(){
        System.out.println("【消息发送】关闭消息通道");
    }

    @Override
    public void send() {
        if(this.connect()){
            message.send();
        }
        this.close();
    }
}
