package com.wukaixun.gaoji.zijieliuhezifuliu.scaner;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 使用Scanner实现键盘输入信息的标准化定义
 * @author wukaixun
 * @date 2020.11.23
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日:");
        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String msg = scanner.next("\\d{4}-\\d{2}-\\d{2}");
            System.out.println("输入生日为:" + new SimpleDateFormat("yyyy-MM-dd").parse(msg));
        } else{
            System.out.println("生日格式不正确!");
        }
        scanner.close();
    }
}
