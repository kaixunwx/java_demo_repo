package com.wukaixun.gaoji.guojihuachengxu.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ResourceBundle类学习
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo2 {
    public static void main(String[] args) throws Exception{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("haha");
        String val = resourceBundle.getString("info");
        System.out.println("val:" + val);
    }
}
