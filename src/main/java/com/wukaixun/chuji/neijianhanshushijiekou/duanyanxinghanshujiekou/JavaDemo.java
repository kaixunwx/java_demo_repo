package com.wukaixun.chuji.neijianhanshushijiekou.duanyanxinghanshujiekou;

import java.util.function.Predicate;

/**
 * 内建函数接口之断言型函数接口
 * @author wukaixun
 * @date 2020.09.24
 */
public class JavaDemo {
    public static void main(String[] args) {
        Predicate<String> pre = "haha":: equalsIgnoreCase;
        System.out.println(pre.test("HAHA"));
    }
}
