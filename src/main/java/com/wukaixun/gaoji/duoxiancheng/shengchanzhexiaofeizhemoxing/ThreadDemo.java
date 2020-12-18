package com.wukaixun.gaoji.duoxiancheng.shengchanzhexiaofeizhemoxing;

/**
 * 生产者消费者模型
 * 多线程最原始实现方案 整个过程由开发者通过原生代码操作控制
 * @author wukaixun
 * @date 2020.10.13
 */
class Food{
    private String name;
    private Double price;
    private boolean flag = true;  // flag为true允许生产，不允许消费 flag为false允许消费不允许生产

    public synchronized void set(String name, Double price) {
        if(!this.flag){  // 不允许生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.price = price;
        // 生产完毕后flag为false 表示可以消费 并尝试唤醒可能在等待的消费者线程
        this.flag = false;
        super.notify();
    }

    public synchronized String get() {
        if(this.flag){ // flag为true表示还未生产，需要等待生产者生产后消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            return "吃掉:" + this.name + ", 花费:" + this.price;
        } finally {  // 消费者执行完成后无论如何都要执行唤醒操作
            this.flag = true;
            super.notify();
        }
    }
}

class Producer implements Runnable{
    private Food food;
    public Producer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for(int x = 0; x< 100;x++){
            if(x % 2 == 0){
                System.out.println("生产面包");
                this.food.set("面包", 2.0);
            } else {
                System.out.println("生产香肠");
                this.food.set("香肠", 1.0);
            }
        }
    }
}

class Consumer implements Runnable{
    private Food food;
    public Consumer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i ++){
            System.out.println(this.food.get());
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Food food = new Food();
        new Thread(new Producer(food)).start();
        new Thread(new Consumer(food)).start();
    }
}
