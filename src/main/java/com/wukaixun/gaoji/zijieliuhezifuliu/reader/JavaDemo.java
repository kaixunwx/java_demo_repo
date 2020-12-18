package com.wukaixun.gaoji.zijieliuhezifuliu.reader;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * Reader字符输入流学习
 * @author wukaixun
 * @date 2020.11.12
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/wukaixun/hello/demo2.txt");
        if(file.exists()){
            Reader reader = new FileReader(file);
            char[] data = new char[1024];
            int len = reader.read(data);
            System.out.println("读取内容:" + new String(data, 0, len));
            reader.close();
        }
    }
}
