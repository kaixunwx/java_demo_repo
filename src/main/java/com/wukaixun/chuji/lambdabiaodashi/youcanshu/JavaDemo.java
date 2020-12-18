package com.wukaixun.chuji.lambdabiaodashi.youcanshu;

/**
 * lambda表达式使用之有参数
 * lambda表达式主要目的替换掉只有SAM标准的内部类，即只有一个抽象方法的内部类
 * 当有多个抽象方法时，lambda表达式不能替换
 * @author wukaixun
 * @date 2020.09.24
 */

interface IMath{
    public int add(int x, int y);
}

public class JavaDemo {
//    public static void main(String[] args) {
//        IMath imath = (t1, t2) -> {
//            return t1 + t2;
//        };
//        System.out.println(imath.add(10, 20));
//    }

    // 当抽象方法只有一行代码时，可以进一步简化操作
    public static void main(String[] args) {
        IMath math = (t1, t2) -> t1 + t2;
        System.out.println(math.add(10, 20));;
    }
}
