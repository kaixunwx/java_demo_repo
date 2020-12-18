package com.wukaixun.gaoji.leiji.map.mapentry;

import java.util.Map;

/**
 * Map.Entry使用
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        Map.Entry<String, Integer> entry = Map.entry("吴凯勋", 24);
        System.out.println("key:" + entry.getKey());
        System.out.println("value:" + entry.getValue());
    }
}
