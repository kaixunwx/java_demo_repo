package com.wukaixun.gaoji.guojihuachengxu.locale;

import java.util.Locale;

/**
 * Locale类使用
 * 通过Locale类可以获取对应国家的语言环境
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo1 {
    public static void main(String[] args) {
        Locale locale = new Locale("zh", "CN");
        System.out.println("locale:" + locale);

        // 通过默认方式获取
        Locale locale1 = Locale.getDefault();
        System.out.println("locale:" + locale1);

        // 通过Locale类定义的常量获取
        Locale locale2 = Locale.CHINA;
        System.out.println("locale:" + locale2);
    }
}
