package com.wukaixun.gaoji.ioanli.shuzibijiao.service.impl;

import com.wukaixun.gaoji.ioanli.shuzibijiao.service.INumberService;
import com.wukaixun.gaoji.ioanli.shuzibijiao.util.InputUtil;

public class NumberServiceImpl implements INumberService {
    /**
     * 输入数字并获取最大值和最小值
     *
     * @param count 输入数字的数量
     * @return 最大值和最小值
     */
    @Override
    public int[] stat(int count) {
        int[] result = new int[2];
        int[] data = new int[count];
        for (int i = 0; i < data.length; i++) {
            data[i] = InputUtil.getInt(String.format("请输入第%s个数字:", i + 1));
        }
        result[0] = data[0];
        result[1] = data[1];
        for (int i = 0; i < data.length; i++) {
            if (result[0] < data[i]) { // 找出最大值
                result[0] = data[i];
            }
            if (result[1] > data[i]) { // 找出最小值
                result[1] = data[i];
            }
        }
        return result;
    }
}
