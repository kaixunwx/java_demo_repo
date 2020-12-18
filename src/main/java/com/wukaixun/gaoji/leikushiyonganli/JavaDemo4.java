package com.wukaixun.gaoji.leikushiyonganli;

import java.util.Random;

/**
 * 模拟扔硬币1000次，记录正面和反面出现次数
 * @author wukaixun
 * @date 2020.10.21
 */
public class JavaDemo4 {
    public static void main(String[] args) {
        Coin coin = new Coin();
        coin.throwCoin(100000);
        System.out.println("正面次数:"+ coin.getFront());
        System.out.println("背面次数:"+ coin.getBack());
    }
}

class Coin{

    private int front;
    private int back;
    Random random = new Random();

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public void throwCoin(int time){
        for(int x=0;x<time;x++){
            int y = random.nextInt(2);
            if(y == 0){
                this.front ++;
            } else {
                this.back ++;
            }
        }
    }
}
