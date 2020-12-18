package com.wukaixun.gaoji.wangluobiancheng.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP连接客户端
 * @author wukaixun
 * @date 2020.12.10
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket client = new DatagramSocket(9999);
        System.out.println("客户端等待接收数据....");
        byte data [] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);  // 接收数据
        client.receive(packet);
        System.out.println("接收到消息:" + new String(data, 0, packet.getLength()));
        client.close();
    }
}
