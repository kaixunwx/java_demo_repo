package com.wukaixun.gaoji.jihegongjulei.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 使用Properties实现资源操作
 * Properties主要特点是可以输出资源到文件和从文件加载资源
 *
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
//        prop.put("baidu", "www.baidu.com");
//        prop.put("ali", "www.taobao.com");
//        prop.put("jd", "www.jd.com");
//        System.out.println("----获取属性----");
//        System.out.println(prop.getProperty("baidu"));
//        System.out.println(prop.getProperty("jd"));
//        System.out.println(prop.getProperty("ali"));
//        System.out.println("----获取不存在属性(设置默认值)");
//        System.out.println(prop.getProperty("xiecheng", "www.xiecheng.com"));

//        System.out.println("-----属性输出到文件------");
//        prop.store(new FileOutputStream(new File("/Users/wukaixun/demo.properties")), "test properties");

        System.out.println("----从文件读取属性资源-------");
        prop.load(new FileInputStream(new File("/Users/wukaixun/demo.properties")));
        System.out.println(prop.getProperty("ali"));
    }
}
