package com.wukaixun.gaoji.riqi.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类学习
 * 格式化Date类型时间显示
 *
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        // Date转字符串
        // 构造方法public SimpleDateFormat(String pattern);
        // 日期格式: 年(yyyy),月(MM),日(dd),时(HH)，分(mm), 秒(ss), 毫秒(SSS)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        String currentTime = sdf.format(new Date());
        System.out.println("当前时间:" + currentTime);

        // 字符串转Date
        // 字符串格式必须符合SimpleDateFormat定义的格式
        // 如果在字符串定义的时间中使用的数字超过合理范围，将会进行自动进位处理 比如2020-18会自动转为Date类型后会自动进位成2021-06
        String str = "2011-08-21 13:28:33.232";
        Date date = sdf.parse(str);
        System.out.println("Date:" + date);

    }
}
