package com.wukaixun.gaoji.shuxuecaozuo.math;

/**
 * 保留小数后n位
 * Math提供的round方法是将小数位全部进位后取整
 * 如果需要保留n位小数，需要自行编写
 */
class MathUtil{
    private MathUtil(){}; // 构造方法私有化

    /**
     *
     * @param num 要进行保留小数操作的数值
     * @param scale  四舍五入保留小数位数
     * @return 四舍五入处理后的结果
     */
    public static double round(double num, int scale){
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}

/**
 * Math类学习
 * @author wukaixun
 * @date 2020.10.15
 */
public class JavaDemo {
    public static void main(String[] args) {
        // 求绝对值
        System.out.println("-15.22的绝对值:" + Math.abs(-15.22));

        // 5的对数
        System.out.println("5的对数：" + Math.log(5));

        // 四舍五入
        System.out.println("5.5四舍五入:" + Math.round(5.5));
        System.out.println("-5.5四舍五入:" + Math.round(-5.5));
        System.out.println("-5.51四舍五入:" + Math.round(-5.51));

        System.out.println("18.53211保留两位小数:" + MathUtil.round(18.53211, 2));

    }
}
