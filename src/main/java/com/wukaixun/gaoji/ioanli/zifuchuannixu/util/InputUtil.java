package com.wukaixun.gaoji.ioanli.zifuchuannixu.util;

import java.util.Scanner;

public class InputUtil {
    public static final Scanner INPUT = new Scanner(System.in);

    public static String getStr(String promote){
        System.out.println(promote);
        String msg = "";
        if (INPUT.hasNextLine()){
            msg = INPUT.nextLine();
        }
        return msg;
    }
}
