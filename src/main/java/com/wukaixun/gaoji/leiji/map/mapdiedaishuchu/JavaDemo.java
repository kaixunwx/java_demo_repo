package com.wukaixun.gaoji.leiji.map.mapdiedaishuchu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map迭代输出
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("吴凯勋", 24);
        map.put("王培培", 25);
        map.put("宋鑫龙", 23);
        Set<Map.Entry<String, Integer>>  entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
        System.out.println("-----使用iterator输出map-----");
        while (iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("-----使用foreach输出map-----");
        Set<Map.Entry<String, Integer>>  entrySet1 = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet1){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
