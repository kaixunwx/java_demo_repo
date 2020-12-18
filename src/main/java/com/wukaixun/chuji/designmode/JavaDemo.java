package com.wukaixun.chuji.designmode;

/**
 * 设计模式之工厂模式
 * @author wukaixun
 * @date 2020/09/10
 */

interface IFood{
    public void eat();
}

class Bread implements IFood{
    public void eat(){
        System.out.println("吃面包");
    }
}

class Milk implements IFood{
    public void eat(){
        System.out.println("喝牛奶");
    }
}

/**
 * 工厂类
 */
class Factory{
    public static IFood getInstance(String className){
        if(className.equals("bread")){
            return new Bread();
        } else if(className.equals("milk")){
            return new Milk();
        } else{
            return null;
        }
    }
}




public class JavaDemo {
    public static void main(String[] args) {
        IFood bread = Factory.getInstance("bread");
        bread.eat();
        IFood milk = Factory.getInstance("milk");
        milk.eat();
    }
}
