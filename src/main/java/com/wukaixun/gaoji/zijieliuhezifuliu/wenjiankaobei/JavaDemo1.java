package com.wukaixun.gaoji.zijieliuhezifuliu.wenjiankaobei;

import java.io.*;

/**
 * Java实现文件拷贝的最原始方法
 *
 * @author wukaixun
 * @date 2020.11.18
 */
public class JavaDemo1 {
    public static void main(String[] args) throws Exception {
        FileUtils fu = new FileUtils("/Users/wukaixun/hello/demo2.txt", "/Users/wukaixun/hello/demo3.txt");
        System.out.println(fu.copy() ? "文件拷贝成功!" : "文件拷贝失败!");
    }
}

class FileUtils {
    File srcFile;
    File desFile;

    public FileUtils(String src, String des) {
        this(new File(src), new File(des));
    }

    public FileUtils(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public boolean copy() throws Exception {
        if (!this.srcFile.exists()) {
            System.out.println("目标文件不存在!");
            return false;
        }
        if (!this.desFile.getParentFile().exists()) { // 目标文件父路径不存在就创建
            this.desFile.getParentFile().mkdirs();
        }

        byte[] data = new byte[1024];
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(this.srcFile);
            output = new FileOutputStream(this.desFile);
            int len;
            while ((len = input.read(data)) != -1) {
                output.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return true;
    }
}