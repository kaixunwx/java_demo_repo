package com.wukaixun.chuji.lambdabiaodashi.meiyoucanshu;

/**
 * lambda表达式使用之没有参数
 * @author wukaixun
 * @date 2020.09.24
 *
 */
interface IMessage{
    public void send();
}


public class JavaDemo {
    public static void main(String[] args) {
        IMessage message = ()-> {
            System.out.println("Hello World!");
        };
        message.send();
    }
}
