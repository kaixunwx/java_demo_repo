package com.wukaixun.gaoji.kaifazhichileiku.base64;

import java.util.Base64;

/**
 * base64加密解密使用
 * 复杂加密算法:
 *   -|可以先把盐值加密
 *   -|推荐使用多种加密算法
 *   -|使用不可逆算法
 * @author wukaixun
 * @date 2020.10.20
 */
public class JavaDemo {
    public static void main(String[] args) {
        String password = "w2740201";
        String passwordEncrypt = StringUtil.passwordEncrypt(password);
        System.out.println("加密后密码:" + passwordEncrypt);
        String passwordDecrypt = StringUtil.passwordDecrypt(passwordEncrypt);
        System.out.println("解密后密码:" + passwordDecrypt);
    }
}

class StringUtil{
    public static final String SALT = "wukaixun";  // 盐值
    public static final int REPEAT = 3;  // 加密次数

    /**
     * 加密
     * @param password 原始密码
     * @return 加密后的密码
     */
    public static String passwordEncrypt(String password){
        String str = password + SALT;
        byte [] data = str.getBytes();
        for(int i=0;i<REPEAT;i++){
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }

    /**
     * 解密
     * @param password
     * @return
     */
    public static String passwordDecrypt(String password){
        byte [] data = password.getBytes();
        for(int i =0;i < REPEAT; i ++){
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replace("wukaixun", "");
    }
}


