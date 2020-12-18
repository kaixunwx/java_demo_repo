package com.wukaixun.gaoji.streamshujuliu.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream数据流基本使用
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "JSP", "JavaScript", "JSON", "Python", "Ruby", "Go", "NodeJs");
        Stream<String> stream = list.stream();  // 获取Stream接口对象
        // 进行数据filter操作
//        List<String> result = stream.filter((ele) -> ele.toLowerCase().contains("p")).collect(Collectors.toList());
//        System.out.println("包含字母p的语言:" + result);
        // 进行分页和跳跃操作
        List<String> result1 = stream.filter((ele) -> ele.toLowerCase().contains("j")).skip(1).limit(2).collect(Collectors.toList());
        System.out.println("跳过1个元素后限制2个长度内包含字母j的语言:" + result1);
    }
}
