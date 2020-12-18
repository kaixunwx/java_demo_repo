package com.wukaixun.gaoji.duoxiancheng.sisuo;

/**
 * 演示死锁形成过程及原因
 * @author wukaixun
 * @date 2020.10.13
 */
class NiTouCheA{
    public synchronized void say(NiTouCheB cheB){
        System.out.println("泥头车b臭弟弟给爷让开");
        cheB.get();
    }

    public synchronized void get(){
        System.out.println("泥头车b让路了，爷可以过桥了");
    }
}

class NiTouCheB{
    public synchronized void say(NiTouCheA cheA){
        System.out.println("泥头车a给爷让开");
        cheA.get();
    }

    public synchronized void get(){  // 去掉synchronize关键字就可解除死锁
        System.out.println("泥头车a让路了，爷可以过桥了");
    }
}

public class ThreadDemo implements Runnable{
    private NiTouCheA cheA = new NiTouCheA();
    private NiTouCheB cheB = new NiTouCheB();

    @Override
    public void run() {
        cheA.say(cheB);
    }

    public ThreadDemo(){
        new Thread(this).start();
        cheB.say(cheA);
    }

    public static void main(String[] args) {
        new ThreadDemo();
    }
}
