package com.wukaixun.gaoji.zijieliuhezifuliu.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Writer 字符输出流学习
 * @author wukaixun
 * @date 2020.11.12
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/wukaixun/hello/demo2.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String str = "呵呵\r\n";
        Writer writer = new FileWriter(file);
        writer.append(str);  // append可以直接像文件中追加内容
//        writer.write(str);
        writer.close();
    }
}
