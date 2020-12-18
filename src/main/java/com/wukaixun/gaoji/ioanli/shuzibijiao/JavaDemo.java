package com.wukaixun.gaoji.ioanli.shuzibijiao;

import com.wukaixun.gaoji.ioanli.shuzibijiao.factory.Factory;
import com.wukaixun.gaoji.ioanli.shuzibijiao.service.INumberService;

public class JavaDemo {
    public static void main(String[] args) {
        INumberService service = Factory.getInstance();
        int [] result = service.stat(3);
        System.out.println("最大值:" + result[0]);
        System.out.println("最小值:" + result[1]);
    }

}
