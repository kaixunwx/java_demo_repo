package com.wukaixun.gaoji.zhengze;

/**
 * String类对正则表达式的支持
 *
 * @author wukaixun
 * @date 2020.10.19
 */
public class JavaDemo {
    public static void main(String[] args) {
        // 判断日期是否符合格式
        String date = "2020-08-11";
        String regex1 = "\\d{4}-\\d{2}-\\d{2}";
        System.out.println("日期是否符合规范：" + date.matches(regex1));

        String phone = "27402011";
        System.out.println("电话号码是否规范:" + ifPhoneNumberAvailable(phone));

        String email = "kaixunwx@intel.abc";
        System.out.println("电子邮件是否符合规范:" + ifEmailAvailable(email));

    }

    /**
     * 判断电话号码是否符合规范
     * 电话号码格式可以为 2740201, 03722740201, (0372)-2740201
     */
    public static boolean ifPhoneNumberAvailable(String phoneNumber) {
//        String regex1 = "\\d{7, 8}";  // 第一种模式 电话号码(7-8位)
//        String regex2 = "(\\d{3,4})?\\d{7, 8}";  // 第二种模式 区号(3-4位)+电话号码(7-8位)
        String regex3 = "(\\d{3,4}|\\(\\d{3,4}\\)-)?\\d{7,8}";
        if(phoneNumber.matches(regex3)){
            return true;
        }
        return false;
    }

    /**
     * 判断电子邮件是否符合格式
     * 电子邮件用户名只能由字母数字下划线组成，开头不能用下划线
     * 电子邮件域名只能是.cn, .com, .gov或.com.cn
     * @param email
     * @return
     */
    public static boolean ifEmailAvailable(String email){
        String regex = "[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|com.cn|gov|net)";
        if(email.matches(regex)){
            return true;
        }
        return false;
    }
}
