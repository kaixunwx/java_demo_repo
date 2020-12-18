package com.wukaixun.gaoji.arrayutils;

import java.util.Arrays;

public class JavaDemo {
    public static void main(String[] args) {
        int[] data = {5, 4, 8, 11, 111, 5674, 23, 95};
//        data = ArrayUtils.arraySort(data, "desc");
        data = ArrayUtils.quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
