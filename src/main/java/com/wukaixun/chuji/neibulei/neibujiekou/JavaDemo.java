package com.wukaixun.chuji.neibulei.neibujiekou;

/**
 * static定义内部借口
 * @author wukaixun
 * @date 2020/09/24
 */

interface MessageWrapper{
    static interface IMessage{
        public String getContent();
    }

    static interface IChannel{
        public boolean connect();
    }

    public static void send (IMessage msg, IChannel channel){
        if(channel.connect()){
            System.out.println(msg.getContent());;
        } else {
            System.out.println("消息通道建立失败，消息无法发送！");
        }
    }
}

class DefaultMessage implements MessageWrapper.IMessage{
    @Override
    public String getContent(){
        return "https://www.mldn.cn";
    }
}

class ChannelImpl implements MessageWrapper.IChannel{
    @Override
    public boolean connect() {
        return true;
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        MessageWrapper.send(new DefaultMessage(), new ChannelImpl());
    }
}
