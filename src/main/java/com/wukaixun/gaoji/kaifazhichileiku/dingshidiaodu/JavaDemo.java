package com.wukaixun.gaoji.kaifazhichileiku.dingshidiaodu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java基础定时调度学习
 * @author wukaixun
 * @date 2020.10.20
 */
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("["+ Thread.currentThread().getName() +"]" + "定时任务启动, 启动时间:" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 1000);  // 延迟一秒启动， 只启动一次
        timer.scheduleAtFixedRate(new MyTask(), 1000, 1000);  // 延迟一秒启动，每秒调度一次
    }
}
