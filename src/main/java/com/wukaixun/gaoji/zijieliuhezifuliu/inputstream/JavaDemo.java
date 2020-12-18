package com.wukaixun.gaoji.zijieliuhezifuliu.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * InputStream学习
 *
 * @author wukaixun
 * @date 2020.11.12
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users" + File.separator + "wukaixun" + File.separator + "hello" + File.separator + "demo.txt");
        InputStream input = new FileInputStream(file);
        // 使用固定长度读取
        byte [] data = new byte[input.available()];
        input.read(data);
        System.out.println("[" + new String(data) + "]");

        // 使用全量方法读取
//        byte [] data = input.readAllBytes();
//        System.out.println("[" + new String(data) + "]");
    }
}
