package com.wukaixun.gaoji.zijieliuhezifuliu.randomaccessfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile学习
 * RandomAccessFile类可以由用户自定义读取文件的位置，而后按照指定的结构读取数据，要求数据长度保持一致
 *
 * @author wukaixun
 * @date 2020.11.19
 */
public class JavaDemo {
    public static void main(String[] args) {
        File file = new File("/Users/wukaixun/hello/randomaccessfile.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // 写入
//            String[] names = new String[]{"zhangsan", "lisi    ", "wangwu  "};
//            int[] ages = new int[]{21, 23, 30};
//            for (int x = 0; x < names.length; x++) {
//                raf.write(names[x].getBytes());
//                raf.writeInt(ages[x]);
//            }

            //读取
            raf.skipBytes(24);
            byte [] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名:" + new String(data, 0, len) + "年龄：" + raf.readInt());
//            System.out.println("姓名:" + new String(data, 0, len));
//            System.out.println("年龄：" + raf.readInt());
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
