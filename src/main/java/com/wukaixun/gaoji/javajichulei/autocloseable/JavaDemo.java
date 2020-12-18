package com.wukaixun.gaoji.javajichulei.autocloseable;

/**
 * AutoCloseable接口学习
 * AutoCloseable接口中只有一个close方法
 * 必须结合异常处理才可以实现close方法的自动调用
 * @author wukaixun
 * @date 2020.10.15
 */
interface IMessage extends AutoCloseable{  // 继承utoCloseable接口
    public void send();
}

class NetMessage implements IMessage{
    private String msg;

    public NetMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public void send() {
        if(this.open()){
            System.out.println("[SEND] 发送消息:" + this.msg);
        }
    }

    public boolean open(){
        System.out.println("[OPEN] 打开消息发送通道");
        return true;
    }

    @Override
    public void close() throws Exception{
        System.out.println("[CLOSE] 关闭消息发送通道");
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        try(IMessage nm = new NetMessage("你好啊")){  // 必须是带资源的try catch结构才会自动调用close方法
            nm.send();
        } catch (Exception e){

        }

    }
}
