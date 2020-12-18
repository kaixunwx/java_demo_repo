package com.wukaixun.gaoji.ioanli.toupiaoxitong.util;

import java.util.Scanner;

public class InputUtil {
    public static Scanner INPUT = new Scanner(System.in);

    public static int getInt(String promote){
        System.out.println(promote);
        int result = 0;
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
