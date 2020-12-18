package com.wukaixun.gaoji.leikushiyonganli;

/**
 * 正则案例
 * 验证邮箱是否合法
 * @author wukaixun
 * @date 2020.10.21
 */
public class JavaDemo3 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("输入参数格式不正确!");
            System.exit(1);
        }
        String email = args[0];
        if(ifAvailable(email)){
            System.out.println("邮箱合法！" + email);
        }else{
            System.out.println("邮箱不合法！" + email);
        }


    }

    public static boolean ifAvailable(String email){
        if(email == null || "".equals(email)){
            return false;
        }
        String regex = "\\w+@(163.com|intel.com)";
        return email.matches(regex);
    }
}
