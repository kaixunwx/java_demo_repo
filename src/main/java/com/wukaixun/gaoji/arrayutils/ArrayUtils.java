package com.wukaixun.gaoji.arrayutils;

public class ArrayUtils {
    /**
     * 冒泡排序
     *
     * @param data
     * @return
     */
    public static int[] arraySort(int[] data, String sequence) {
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data.length - 1 - x; y++) {
                if (sequence.equals("asc")) {  // 升序
                    if (data[y] > data[y + 1]) {
                        int temp = data[y];
                        data[y] = data[y + 1];
                        data[y + 1] = temp;
                    }
                } else if (sequence.equals("desc")) {
                    if (data[y] < data[y + 1]) { // 降序
                        int temp = data[y];
                        data[y] = data[y + 1];
                        data[y + 1] = temp;
                    }
                }
            }
        }
        return data;
    }

    /**
     * 快速排序
     * 快速排序右指针先运动是因为右指针向左运动寻找小于基准数的数值，左指针向右运动寻找大于基准数的数值，
     * 指针相遇后要把基准数和指针指向的数值交换位置，如果左指针先动，小于基准数的值不会被标记，可能会错过应该和
     * 基准数交换的数继续往前走，反而还阻止了右指针寻找小于基准数的位置，只有右指针先动，才能保证两指针相遇时候
     * 指向的数小于基准数
     * @param data     要排序的数组
     * @param leftPos  初始左坐标
     * @param rightPos 初始右坐标
     * @return 排序完成的数组
     */
    public static int[] quickSort(int data[], int leftPos, int rightPos) {
        if (leftPos > rightPos) {
            return data;
        }

        int initLeftPos = leftPos; // 记录初始左坐标
        int initRightPos = rightPos; // 记录初始右坐标
        int baseNum = data[leftPos];

        while (rightPos > leftPos) {
            while (data[rightPos] >= baseNum && rightPos > leftPos) { // 右指针找到小于基准数的值停下
                rightPos--;
            }
            while (data[leftPos] <= baseNum && rightPos > leftPos) { // 左指针找到大于基准数的值就停下
                leftPos++;
            }
            if (rightPos > leftPos) {  // 交换两个指针指向的数字(小于基准数的移动到左半边，大于基准数的移动到右半边)
                swap(data, leftPos, rightPos);
            }
        }

        swap(data, leftPos, initLeftPos);  // 把原基准数移动到两个指针指向的位置，原位置的数值作为新的基准数

        quickSort(data, initLeftPos, leftPos - 1); // 递归排列左半边
        quickSort(data, rightPos + 1, initRightPos);  // 递归排列右半边
        return data;
    }

    /**
     * 交换数组中两数的位置
     *
     * @param data
     * @param leftPos
     * @param rightPos
     */
    public static void swap(int[] data, int leftPos, int rightPos) {
        int temp = data[leftPos];
        data[leftPos] = data[rightPos];
        data[rightPos] = temp;
    }

}
