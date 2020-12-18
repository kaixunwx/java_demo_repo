package com.wukaixun.gaoji.leikushiyonganli;

import java.util.Arrays;
import java.util.Random;

/**
 * Random使用案例
 * 生成1-30的随机数组
 * @author wukaixun
 * @date 2020.10.21
 */
public class JavaDemo2 {
    public static void main(String[] args) {
        int[] result = NumberFactory.create(5);
        System.out.println(Arrays.toString(result));
    }
}


class NumberFactory {
    private static Random random = new Random();

    /**
     * @param len 要生成数组的长度
     * @return
     */
    public static int[] create(int len) {
        int[] result = new int[len];
        int foot = 0;
        while (foot < len) {
            int x = random.nextInt(30);
            if (x != 0) {
                result[foot++] = x;
            }
        }
        return result;
    }
}


