package com.wukaixun.gaoji.guojihuachengxu.messageformat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * MessageFormat类实现文本格式化
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo4 {
    public static void main(String[] args) {
        Locale loc = Locale.CHINA;
        // 读取中国区域的资源文件
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("Message", loc);
        String str = resourceBundle1.getString("info");
        str = MessageFormat.format(str, "吴凯勋", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(str);
    }
}
