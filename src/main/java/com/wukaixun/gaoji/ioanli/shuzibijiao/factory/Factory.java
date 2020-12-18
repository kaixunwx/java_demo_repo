package com.wukaixun.gaoji.ioanli.shuzibijiao.factory;

import com.wukaixun.gaoji.ioanli.shuzibijiao.service.impl.NumberServiceImpl;

public class Factory {
    public static NumberServiceImpl getInstance(){
        return new NumberServiceImpl();
    }
}
