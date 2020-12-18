package com.wukaixun.gaoji.fanshejizhi.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
    public static String MY_CLASS_PATH = "/Users/wukaixun/Message.class";  // 要用编译后的.class文件

    public Class<?> loadData(String className) throws Exception{
        byte [] data = this.loadClassData();
        if(data != null){
            return super.defineClass(className, data, 0, data.length);
        }
        return null;
    }

    /**
     * 读取二进制类文件
     * @return
     * @throws Exception
     */
    private byte[] loadClassData() throws Exception{
        InputStream input = null;
        ByteArrayOutputStream bos = null;
        byte[] data = null;
        try{
            input = new FileInputStream(new File(MY_CLASS_PATH));
            bos = new ByteArrayOutputStream();
            input.transferTo(bos);
            data = bos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(input != null){
                input.close();
            }
            if(bos !=null){
                bos.close();
            }
        }
        return data;
    }
}
