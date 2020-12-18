package com.wukaixun.gaoji.zijieliuhezifuliu.neicunliu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 内存流使用
 * @author wukaixun
 * @date 2020.11.19
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        // 利用内存流实现小写转大写
        String str = "hello world";
        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int data = 0;
        while ((data = input.read()) != -1){
            output.write(Character.toUpperCase(data));
        }
        System.out.println(output);
        input.close();
        output.close();
    }
}
