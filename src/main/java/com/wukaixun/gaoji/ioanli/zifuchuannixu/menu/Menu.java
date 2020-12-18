package com.wukaixun.gaoji.ioanli.zifuchuannixu.menu;

import com.wukaixun.gaoji.ioanli.zifuchuannixu.factory.Factory;
import com.wukaixun.gaoji.ioanli.zifuchuannixu.service.IStringService;
import com.wukaixun.gaoji.ioanli.zifuchuannixu.util.InputUtil;

import java.util.Arrays;

public class Menu {
    private IStringService stringService;
    public Menu() {
        this.stringService = Factory.getInstance();
        this.choose();
    }

    public void choose(){
        this.show();
        String choose = InputUtil.getStr("请输入选项:");
        switch (choose){
            case "1":
                String str = InputUtil.getStr("请输入字符串:");
                this.stringService.append(str);
                this.choose();
            case "2":
                String [] result = this.stringService.reverse();
                System.out.println("逆序字符串:" + Arrays.toString(result));
                this.choose();
            case "3":
                System.out.println("退出程序!");
                System.exit(1);
        }

    }

    private void show(){
        System.out.println("【1】追加字符串数据\r\n");
        System.out.println("【2】字符串逆序展示\r\n");
        System.out.println("【3】退出程序");
    }
}
