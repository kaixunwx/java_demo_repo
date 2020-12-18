package com.wukaixun.gaoji.leiji.list;

import java.util.List;

/**
 * List简单学习
 * @author wukaixun
 * @date 2020.12.03
 */
public class JavaDemo {
    public static void main(String[] args) {
        List<String> list = List.of("吴凯勋", "王培培", "宋鑫龙");
        Object temp[] = list.toArray();
        for(Object tmp: temp){
            System.out.print(tmp + ",");
        }
    }
}
