package com.wukaixun.chuji.neijianhanshushijiekou.gongnengxinghanshujiekou;

import java.util.function.Function;

/**
 * 内建函数接口之功能性函数接口
 * @author wukaixun
 * @date 2020.09.24
 */


public class JavaDemo {
    public static boolean startWith(String str, String start){
        Function<String, Boolean> function = str:: startsWith;
        return function.apply(start);
    }
    public static void main(String[] args) {
        System.out.println(startWith("www.baidu.com", "www"));  // 使用apply方法表示应用
    }
}
