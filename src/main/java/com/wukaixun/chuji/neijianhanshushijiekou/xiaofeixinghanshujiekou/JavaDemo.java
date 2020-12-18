package com.wukaixun.chuji.neijianhanshushijiekou.xiaofeixinghanshujiekou;

import java.util.function.Consumer;

/**
 * 内建函数接口之消费型函数接口
 * @author wukaixun
 * @date 2020.09.24
 */
public class JavaDemo {
    public static void main(String[] args) {
        Consumer<String> con = System.out:: println;
        con.accept("呵呵");
    }
}
