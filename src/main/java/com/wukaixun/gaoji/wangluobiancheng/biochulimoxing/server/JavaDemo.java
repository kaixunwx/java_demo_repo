package com.wukaixun.gaoji.wangluobiancheng.biochulimoxing.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO程序模型之服务端
 *
 * @author wukaixun
 * @date 2020.12.10
 */
public class JavaDemo {
    private static class ClientThread implements Runnable{
        private Socket client = null;
        private Scanner scan = null;
        private PrintStream out = null;
        private boolean flag = true;

        public ClientThread(Socket client) throws Exception{
            this.client = client;
            this.scan = new Scanner(client.getInputStream());
            this.scan.useDelimiter("\n");
            this.out = new PrintStream(client.getOutputStream());
        }

        @Override
        public void run(){
            while (this.flag) {
                if (this.scan.hasNext()) {
                    System.out.println("有客户端连接, 地址:" + this.client.getInetAddress());
                    String msg = this.scan.next().trim();
                    if (msg.equalsIgnoreCase("byebye")) {
                        this.out.println("byebyebye");
                        this.flag = false;
                    } else{
                        this.out.println("[echo]" + msg);
                    }
                }
            }

            try {
                this.scan.close();
                this.out.close();
                this.client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待客户端连接...");
        boolean flag = true;
        while (flag) {
            new Thread(new ClientThread(server.accept())).start();
        }

    }
}
