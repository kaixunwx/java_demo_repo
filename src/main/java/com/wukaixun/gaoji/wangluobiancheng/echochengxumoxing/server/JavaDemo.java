package com.wukaixun.gaoji.wangluobiancheng.echochengxumoxing.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * echo程序模型之服务端
 *
 * @author wukaixun
 * @date 2020.12.10
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待客户端连接...");
        Socket client = server.accept();
        // 服务端需要先接收客户端数据，将数据处理后发送给客户端
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            if (scan.hasNext()) {
                System.out.println("有客户端连接, 地址:" + client.getInetAddress());
                String msg = scan.next().trim();
                if (msg.equalsIgnoreCase("byebye")) {
                    out.println("byebyebye");
                    flag = false;
                } else{
                    out.println("[echo]" + msg);
                }
            }
        }
        scan.close();
        out.close();
        client.close();
        server.close();
    }
}
