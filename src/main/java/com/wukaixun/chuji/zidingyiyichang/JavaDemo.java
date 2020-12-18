package com.wukaixun.chuji.zidingyiyichang;

/**
 * 自定义异常使用
 * @author wukaixun
 * 2020/09/22
 */
class BombException extends RuntimeException{
    public BombException(String msg){
        super(msg);
    }
}

class Food {
    public static void eat(int num) throws BombException{
        if(num > 10){
            throw new BombException("吃太多了，爆炸了！");
        } else {
            System.out.println("吃的不多");
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Food.eat(11);
    }
}
