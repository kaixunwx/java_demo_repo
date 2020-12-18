package com.wukaixun.chuji.abstractclass;


/**
 * 抽象类demo
 * @author wukaixun
 * @date 2020/09/09
 */


abstract class Action {
    // 定义行为代码
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;

    public void command(int code){
        switch(code){
            case EAT: {
                this.eat();
                break;
            }
            case SLEEP: {
                this.sleep();
                break;
            }
            case WORK: {
                this.work();
                break;
            }
        }

    }

    // 定义抽象行为方法
    abstract void eat();
    abstract void sleep();
    abstract void work();
}


class Person extends Action{
    public void eat(){
        System.out.println("人类安静的坐下吃饭");
    }

    public void sleep(){
        System.out.println("人类静静的躺下睡觉");
    }

    public void work(){
        System.out.println("人类到办公室上班");
    }
}

class Robot extends Action{
    public void eat(){
        System.out.println("机器人插上电源充电");
    }

    // 机器人不需要睡觉
    public void sleep(){}

    public void work(){
        System.out.println("机器人日复一日的重复工作");
    }
}

class Pig extends Action{
    public void eat(){
        System.out.println("猪睡醒了就吃");
    }

    public void sleep(){
        System.out.println("猪吃饱了就睡");
    }

    // 猪不工作
    public void work(){}
}

public class JavaDemo{
    public static void main(String[] args) {
        Action personAction = new Person();
        Action robotAction = new Robot();
        Action pigAction = new Pig();

        System.out.println("-------人类行为-------");
        personAction.command(Action.EAT);
        personAction.command(Action.SLEEP);
        personAction.command(Action.WORK);
        System.out.println("------机器人行为------");
        robotAction.command(Action.EAT);
        robotAction.command(Action.SLEEP);
        robotAction.command(Action.WORK);
        System.out.println("------猪猪行为--------");
        pigAction.command(Action.EAT);
        pigAction.command(Action.SLEEP);
        pigAction.command(Action.WORK);
    }
}


