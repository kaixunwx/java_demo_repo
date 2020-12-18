package com.wukaixun.gaoji.guojihuachengxu;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 实现国际化程序开发
 * 利用Locale和ResourceBundle实现语言环境转换
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo {
    public static void main(String[] args) {
        Locale locale = Locale.US;
        Locale locale1 = Locale.CHINA;
        // 读取美国区域的资源文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message", locale);
        // 读取中国区域的资源文件
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("Message", locale1);
        String str = resourceBundle.getString("info");
        String str1 = resourceBundle1.getString("info");
        System.out.println(str);
        System.out.println(str1);
    }
}
