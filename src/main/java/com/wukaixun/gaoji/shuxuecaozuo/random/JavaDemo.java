package com.wukaixun.gaoji.shuxuecaozuo.random;

import java.util.Random;

/**
 * Random类学习
 *
 * @author wukaixun
 * @date 2020.10.15
 */
public class JavaDemo {
    public static void main(String[] args) {
        Random random = new Random();

        // .nextInt()  返回不大于边界的随机正整数
//        for (int x = 0; x < 10; x++) {
//            System.out.print(random.nextInt(10) + ",");
//        }

        // 彩票36选7  1-36中任意选7个不重复的数字组成彩票号
        int[] data = new int[7];
        int foot = 0;

        while (foot < 7) {
            int num = random.nextInt(37);
            if (isAvailable(num, data)) {
                data[foot++] = num;
            }
        }
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + ",");
        }
    }

    /**
     * 判断当前数字是否可用
     *
     * @param num  当前获取到的随机整数
     * @param temp 当前的彩票号数组
     * @return 数字是否可用
     */
    public static boolean isAvailable(int num, int[] temp) {
        if (num == 0) {
            return false;
        }
        for (int x = 0; x < temp.length; x++) {
            if (num == temp[x]) {
                return false;
            }
        }
        return true;
    }
}
