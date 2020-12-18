package com.wukaixun.gaoji.javajichulei.charsequence;

/**
 * CharSequence接口学习
 * CharSequence典型的三个子类就是String，StringBuffer和StringBuilder
 * CharSequence描述的就是字符串
 * @author wukaixun
 * @date 2020.10.15
 */
public class JavaDemo {
    public static void main(String[] args) {
        CharSequence str = "Hello World!";
        System.out.println("原始字符串:" + str);
        // 获取指定下标字符
        System.out.println("----指定下标字符:" + str.charAt(4));
        // 字符串截取
        System.out.println("----字符串截取:" + str.subSequence(6, 11));
    }
}
