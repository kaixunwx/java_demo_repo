package com.wukaixun.gaoji.wangluobiancheng.udp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP连接服务端
 * @author wukaixun
 * @date 2020.12.10;
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9000);
        String str = "你好啊大煞笔";
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 9999);
        server.send(packet);
        System.out.println("消息发送完毕...");
        server.close();
    }
}
