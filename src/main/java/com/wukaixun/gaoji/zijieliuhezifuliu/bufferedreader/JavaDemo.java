package com.wukaixun.gaoji.zijieliuhezifuliu.bufferedreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 使用BufferedReader实现键盘输入数据的标准化定义
 * @author wukaixun
 * @date 2020.11.23
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入年龄:");
        String msg = reader.readLine();
        if(msg.matches("\\d{1,3}")){
            System.out.println("输入年龄是:" + msg);
        } else{
            System.out.println("输入年龄不合法!");
        }
    }
}
