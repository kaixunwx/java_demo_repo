package com.wukaixun.gaoji.wenjiancaozuo.anli;

import java.io.File;

/**
 * 文件操作案例1
 * 列出某个目录下所有的文件包括子类目
 *
 * @author wukaixun
 * @date 2020.10.22
 */
public class JavaDemo {
    public static void main(String[] args) {
        File file = new File("/Users/wukaixun");
    }

    public static void listDir(File file) {
        if (file.isDirectory()) {
            File result[] = file.listFiles();
            if (result != null){
                for (int x = 0; x < result.length; x++) {
                    listDir(result[x]);
                }
            }
        }else {
            System.out.println(file);
        }
    }
}
