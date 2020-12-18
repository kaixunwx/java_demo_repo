package com.wukaixun.chuji.designmode;


/**
 * 设计模式之代理模式
 * @author wukaixun
 * @date 2020/09/10
 */
interface IEat{
    public void get();
}

class EatReal implements IEat{
    public void get(){
        System.out.println("【真实业务】取得食物，开始享用");
    }
}

class EatProxy implements IEat{
    private IEat eat;
    public EatProxy(IEat eat){
        this.eat = eat;
    }

    public void get(){
        this.prepare();
        this.eat.get();
        this.clear();
    }

    public void prepare(){
        System.out.println("【代理业务1】购买食材");
        System.out.println("【代理业务2】处理食材");
        System.out.println("【代理业务3】烹饪食材");
    }

    public void clear(){
        System.out.println("【代理业务4】收拾碗筷");
    }
}

public class JavaDemo1 {
    public static void main(String[] args) {
        IEat eat = new EatProxy(new EatReal());
        eat.get();
    }
}
