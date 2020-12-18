package com.wukaixun.gaoji.zijieliuhezifuliu.wenjianjiakaobei;


import java.io.*;

/**
 * 利用输入输出流实现整个文件夹拷贝
 *
 * @author wukaixun
 * @date 2020.11.18
 */
public class JavaDemo {
    public static void main(String[] args) {
        FileUtil fu = new FileUtil("/Users/wukaixun/hello/", "/Users/wukaixun/hello2/");
        System.out.println(fu.copyDir() ? "文件拷贝成功!" : "文件拷贝失败!");
    }
}

class FileUtil {
    File srcFile;
    File desFile;

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtil(String src, String des) {
        this(new File(src), new File(des));
    }

    public boolean copyDir() {
        try {
            this.copyImpl(this.srcFile);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private void copyImpl(File file) throws Exception {
        if (file.isDirectory()) {  // 是目录
            File files[] = file.listFiles();
            for (int x = 0; x < files.length; x++) {
                copyImpl(files[x]);
            }
        } else { // 是文件
            String srcFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "");  // 获取原始文件路径
            File desFile = new File(this.desFile, srcFilePath);
            this.copyFileImpl(file, desFile);
        }
    }

    private boolean copyFileImpl(File srcFile, File desFile) throws Exception{
        if (!srcFile.exists()) {
            System.out.println("源文件不存在!");
            return false;
        }
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();
        }

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            input.transferTo(output);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }
    }
}
