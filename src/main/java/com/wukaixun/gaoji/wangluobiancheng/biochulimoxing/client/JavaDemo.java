package com.wukaixun.gaoji.wangluobiancheng.biochulimoxing.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO程序模型之客户端
 * @author wukaixun
 * @date 2020.12.10
 */
public class JavaDemo {
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 9999);
        // 客户端需要支持输入和输出操作，需要准备Scanner和PrintStream
        Scanner scan = new Scanner(client.getInputStream()); // 接收服务端数据流
        scan.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());  // 客服端发送数据流
        boolean flag = true;
        while (flag){
            String input = getInput("请输入要发送的信息:");
            out.println(input);
            if(scan.hasNext()){
                System.out.println(scan.next());
            }
            if(input.equalsIgnoreCase("byebye")){
                flag = false;
            }
        }
        scan.close();
        out.close();
        client.close();
    }

    public static String getInput(String prompt) throws Exception{
        System.out.println(prompt);
        String input = KEYBOARD_INPUT.readLine();
        return input;
    }
}
