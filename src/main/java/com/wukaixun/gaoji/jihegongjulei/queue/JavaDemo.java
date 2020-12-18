package com.wukaixun.gaoji.jihegongjulei.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 队列使用 先进先出
 * @author wukaixun
 * @date 2020.12.09
 */
public class JavaDemo {
    public static void main(String[] args) {
        System.out.println("-----普通队列使用，顺序先进先出-----");
        Queue<String> queue = new LinkedList<>();
        queue.add("X");
        queue.add("A");
        queue.add("Z");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println("-----优先级队列使用,顺序根据对象compareTo方法-----");
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.add("X");
        queue1.add("A");
        queue1.add("Z");
        while (!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }
    }
}
