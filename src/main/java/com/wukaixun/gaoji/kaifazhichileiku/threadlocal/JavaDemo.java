package com.wukaixun.gaoji.kaifazhichileiku.threadlocal;

/**
 * ThreadLocal类学习
 * ThreadLocal主要解决线程同步问题
 * @author wukaixun
 * @date 2020.10.20
 */
public class JavaDemo {
    public static void main(String[] args) {
        new Thread(()->{
            Message message = new Message();
            message.setInfo("线程A的消息");
            Channel.setMessage(message);
            Channel.send();
        }, "线程A").start();

        new Thread(()->{
            Message message = new Message();
            message.setInfo("线程B的消息");
            Channel.setMessage(message);
            Channel.send();
        }, "线程B").start();

        new Thread(()->{
            Message message = new Message();
            message.setInfo("线程C的消息");
            Channel.setMessage(message);
            Channel.send();
        }, "线程C").start();
    }
}

class Message{
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Channel{
    private static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<Message>();
    public static void setMessage(Message msg){
        THREADLOCAL.set(msg);
    }

    public static void send(){
        System.out.println("[" + Thread.currentThread().getName() + "]" + THREADLOCAL.get().getInfo());
    }
}
