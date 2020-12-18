package com.wukaixun.gaoji.wenjiancaozuo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File文件操作类学习
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        // 文件创建删除
//        File file = new File("/Users/wukaixun/java/message/demo.txt");
//        if(!file.getParentFile().exists()) { // 判断文件父目录是否存在，不存在则先创建父目录
//            System.out.println("父目录不存在，创建父目录");
//            file.getParentFile().mkdirs(); //mkdirs是创建多级目录， mkdir创建单级目录
//        }
//        if(file.exists()){
//            System.out.println("文件已存在，删除文件");
//            file.delete();
//        } else {
//            System.out.println("创建文件");
//            file.createNewFile();
//        }

        // 读取文件信息
//        File file = new File("/Users/wukaixun/timg.jpeg");
//        System.out.println("文件是否可读:" + file.canRead());
//        System.out.println("文件是否可写:" + file.canWrite());
//        System.out.println("文件是否可执行:" + file.canExecute());
//        System.out.println("文件大小:" + MathUtil.round(file.length() / (double) 1024 / 1024, 3));
//        System.out.println("文件最后修改日期:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
//        System.out.println("是文件吗:" + file.isFile());
//        System.out.println("是目录吗:" + file.isDirectory());
//        if(file.isFile() && !file.isDirectory()){
//            System.out.println("是文件");
//        } else {
//            System.out.println("是目录");
//        }

        // 列出目录下文件
        File file = new File("/Users/wukaixun");
        if(file.isDirectory()){
            File result[] = file.listFiles();
            System.out.println(Arrays.toString(result));
        }

    }
}

class MathUtil {
    public static double round(double num, int scale) {
        return Math.round(Math.pow(10, scale) * num) / Math.pow(10, scale);
    }
}
