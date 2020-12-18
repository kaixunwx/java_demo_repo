package com.wukaixun.gaoji.leiji.jiheshuchu;

import java.util.*;

/**
 * 集合标准输出方案
 * @author wukaixun
 * @date 2020.12.03
 */
public class JavaDemo {
    public static void main(String[] args) {
        // 1.Iterator迭代输出
        System.out.println("------------Iterator迭代输出------------");
        Set<String> set = new HashSet<>();
        set.add("吴凯勋");
        set.add("朱玉");
        set.add("王培培");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        // ListIterator双向迭代输出
        System.out.println("---------ListIterator双向迭代输出---------");
        List<String> list = new ArrayList<>();
        list.add("吴凯勋");
        list.add("朱玉");
        list.add("王培培");
        // 使用ListIterator实现倒叙输出必须先正序输出一遍
        ListIterator<String> iter1 = list.listIterator();
        System.out.print("正序输出:");
        while (iter1.hasNext()){
            System.out.print(iter1.next() + ",");
        }
        System.out.println();
        System.out.print("倒叙输出:");
        while (iter1.hasPrevious()){
            System.out.print(iter1.previous() + ",");
        }
        System.out.println();
        System.out.println("-----------Enumeration枚举输出------------");
        // Enumeration仅适用于Vector类
        Vector<String> vector = new Vector<>();
        vector.add("吴凯勋");
        vector.add("宋鑫龙");
        vector.add("朱玉");
        Enumeration<String> enu = vector.elements();
        while (enu.hasMoreElements()){
            System.out.println(enu.nextElement());
        }

    }
}
