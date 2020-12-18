package com.wukaixun.gaoji.ioanli.shuzibijiao.util;

import java.util.Scanner;

public class InputUtil {
    public static final Scanner INPUT = new Scanner(System.in);

    /**
     * 通过键盘输入数字并返回标准int类型数字
     * @param promote 提示信息
     * @return int数字
     */
    public static int getInt(String promote){
        int result = 0;
        System.out.println(promote);
        while (INPUT.hasNextLine()){
            String msg = INPUT.nextLine();
            if(msg.matches("\\d+")){
                result = Integer.parseInt(msg);
                break;
            } else{
                System.out.println("Invalid input!" + promote);
            }
        }
        return result;
    }
}
