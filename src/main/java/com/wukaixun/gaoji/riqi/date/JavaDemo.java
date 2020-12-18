package com.wukaixun.gaoji.riqi.date;

import java.util.Date;

/**
 * Date日期处理类学习
 * @author wukaixun
 * @date 2020.10.16
 */
public class JavaDemo {
    public static void main(String[] args) {
        // Date和long的转换  long可以保存毫秒级的日期记录 即时间戳
        Date date = new Date();
        System.out.println("今日日期:" + date);
        long current = date.getTime();
        current += 86400 * 1000 * 10;
        System.out.println("十天后日期:" + new Date(current));
    }
}
