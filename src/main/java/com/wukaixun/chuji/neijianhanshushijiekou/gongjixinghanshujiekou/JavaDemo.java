package com.wukaixun.chuji.neijianhanshushijiekou.gongjixinghanshujiekou;

import java.util.function.Supplier;

/**
 * 内建函数之供给型函数接口
 * @author wukaixun
 * @date 2020.09.24
 */

public class JavaDemo {
    public static String func(String str){
        Supplier<String> sup = str:: toUpperCase;
        return sup.get();
    }
    public static void main(String[] args) {
        String res = func("wukaixun");
        System.out.println(res);
    }
}
