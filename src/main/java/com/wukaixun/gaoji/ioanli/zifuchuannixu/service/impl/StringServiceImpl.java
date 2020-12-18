package com.wukaixun.gaoji.ioanli.zifuchuannixu.service.impl;

import com.wukaixun.gaoji.ioanli.zifuchuannixu.service.IStringService;

public class StringServiceImpl implements IStringService {
    private StringBuffer data = new StringBuffer();

    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String[] result = this.data.toString().split("\\|");
        int center = result.length / 2;
        int head = 0;
        int tail = result.length - 1;
        for (int x = 0; x < center; x++) { // 逆序
            String temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
            head++;
            tail--;
        }
        return result;
    }
}
