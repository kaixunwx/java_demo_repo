package com.wukaixun.gaoji.jihegongjulei.stack;

import java.util.Stack;

/**
 * 栈使用  先进后出
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("吴凯勋");
        stack.push("王培培");
        stack.push("宋鑫龙");
        while (!stack.empty()){
            System.out.println(stack.pop());
        };

    }
}
