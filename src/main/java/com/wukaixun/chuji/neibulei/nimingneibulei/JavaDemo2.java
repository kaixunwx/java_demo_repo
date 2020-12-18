package com.wukaixun.chuji.neibulei.nimingneibulei;

/**
 * 匿名内部类使用改进
 * @author wukaixun
 * @date 2020.09.24
 */

interface IMessage2{
    public void send(String msg);

    public static IMessage2 getInstance(){
        return new IMessage2() { // 匿名内部类
            @Override
            public void send(String msg) {
                System.out.println(msg);
            }
        };
    }
}


public class JavaDemo2 {
    public static void main(String[] args) {
        IMessage2.getInstance().send("哈哈哈");
    }
}
