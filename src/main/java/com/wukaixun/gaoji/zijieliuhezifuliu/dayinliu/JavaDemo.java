package com.wukaixun.gaoji.zijieliuhezifuliu.dayinliu;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 打印流学习
 * 打印流在使用中比直接使用outputStream要方便的多，如果程序只是输出内容
 * 推荐同一使用打印流
 * @author wukaixun
 * @date 2020.11.23
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/wukaixun/hello/dayinliu.txt");
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        String name = "吴凯勋";
        int age = 24;
        double salary = 14000.0000;
        writer.printf("姓名: %s, 年龄: %s, 薪水: %s\r\n", name, age, salary);
        writer.close();
    }
}
