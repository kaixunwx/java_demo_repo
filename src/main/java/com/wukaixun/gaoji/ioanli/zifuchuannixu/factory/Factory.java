package com.wukaixun.gaoji.ioanli.zifuchuannixu.factory;

import com.wukaixun.gaoji.ioanli.zifuchuannixu.service.impl.StringServiceImpl;

public class Factory {
    public static StringServiceImpl getInstance(){
        return new StringServiceImpl();
    }
}
