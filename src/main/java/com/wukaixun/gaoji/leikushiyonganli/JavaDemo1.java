package com.wukaixun.gaoji.leikushiyonganli;

/**
 * StringBuffer使用案例
 * 定义一个StringBuffer对象，通过append()方法向对象中添加26个小写字母，然后按照逆序的方式输出，并且删除前5个字符
 * @author wukaixun
 * @date 2020.10.21
 */
public class JavaDemo1 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int x ='a'; x <= 'z'; x ++){
            stringBuffer.append((char)x);
        }
        stringBuffer.reverse().delete(0, 5);
        System.out.println(stringBuffer.toString());;
    }
}
