package com.wukaixun.gaoji.leiji.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap简单学习
 * @author wukaixun
 * @date 2020.12.03
 */
public class JavaDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("-------观察map存放数据情况-------");
        map.put("one", 1);
        map.put("one", 11);
        map.put("two", 2);
        map.put(null, 0);
        map.put("zero", null);
        System.out.println(map.get("one")); // key重复时，后面的value会覆盖前面的value
        System.out.println(map.get(null));  // 可以用null作为key
        System.out.println(map.get("ten"));
        System.out.println("------观察map.put方法返回值------");
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println("无重复key:" + map1.put("one", 1));
        System.out.println("key重复:" + map1.put("one", 100));  // key重复时，put方法会返回被覆盖的value
    }
}
