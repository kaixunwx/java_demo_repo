package com.wukaixun.gaoji.jihegongjulei.collections;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Collections集合操作类
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("-----一次性向list中添加元素-----");
        Collections.addAll(list, "wukaixun", "songxinlong", "wangpeipei");
        System.out.println(list);
        System.out.println("-------反转list------");
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("-----list排序-----");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("-----二分查找 返回元素下标-----");
        System.out.println(Collections.binarySearch(list, "songxinlong"));

    }
}
