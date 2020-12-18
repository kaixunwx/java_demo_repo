package com.wukaixun.gaoji.fanshejizhi.fansheyudailishejimoshi.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 *
 * @author wukaixun
 * @date 2020.11.30
 */
public class JavaDemo2 {
    public static void main(String[] args) {
        WuLiangYe wuLiangYe = new WuLiangYe();
        MaoTai maoTai = new MaoTai();
        FuRongWang fuRongWang = new FuRongWang();

        InvocationHandler invocationHandler1 = new GuiTai(wuLiangYe);
        InvocationHandler invocationHandler2 = new GuiTai(maoTai);
        InvocationHandler invocationHandler3 = new GuiTai(fuRongWang);

        ISellWine proxy1 = (ISellWine) Proxy.newProxyInstance(maoTai.getClass().getClassLoader(), maoTai.getClass().getInterfaces(), invocationHandler1);
        ISellWine proxy2 = (ISellWine) Proxy.newProxyInstance(wuLiangYe.getClass().getClassLoader(), wuLiangYe.getClass().getInterfaces(), invocationHandler2);
        ISellSmoke proxy3 = (ISellSmoke) Proxy.newProxyInstance(fuRongWang.getClass().getClassLoader(), fuRongWang.getClass().getInterfaces(), invocationHandler3);

        proxy1.sellWine();
        proxy2.sellWine();
        proxy3.sellSmoke();

    }
}

class GuiTai implements InvocationHandler {
    private Object platform;

    public GuiTai(Object platform) {
        this.platform = platform;
    }

    private void startSell() {
        System.out.println("开始销售 柜台:" + this.getClass().getSimpleName());
    }

    private void endSell() {
        System.out.println("销售结束");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnData = null;
        this.startSell();
        returnData = method.invoke(platform, args);
        this.endSell();
        return returnData;
    }
}


interface ISellWine {
    public void sellWine();
}

class WuLiangYe implements ISellWine {
    @Override
    public void sellWine() {
        System.out.println("【卖酒】五粮液");
    }
}

class MaoTai implements ISellWine {
    @Override
    public void sellWine() {
        System.out.println("【卖酒】茅台");
    }
}


interface ISellSmoke {
    public void sellSmoke();
}

class FuRongWang implements ISellSmoke {
    @Override
    public void sellSmoke() {
        System.out.println("【卖烟】芙蓉王");
    }
}



