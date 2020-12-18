package com.wukaixun.gaoji.zijieliuhezifuliu.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream字节流学习
 * @author wukaixun
 * @date 2020.11.09
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users" + File.separator + "wukaixun" + File.separator + "hello" + File.separator + "demo.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(OutputStream output = new FileOutputStream(file, true)){  // true为追加，默认为false 覆盖
            String str = "hello wukaixun!\r\n";
            output.write(str.getBytes());
        } catch (IOException e){

        }
    }
}
