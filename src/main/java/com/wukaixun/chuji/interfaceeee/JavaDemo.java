package com.wukaixun.chuji.interfaceeee;

interface IUSB {
    boolean check();
    void work();
}

class Computer{
    public void plugin(IUSB usb){
        if(usb.check()){
            usb.work();
        } else {
            System.out.println("设备故障，无法使用");
        }
    }
}

class Keyboard implements IUSB{
    public boolean check(){
        return true;
    }

    public void work(){
        System.out.println("开始码字");
    }
}

class Print implements IUSB{
    public boolean check(){
        return false;
    }

    public void work(){
        System.out.println("开始打印");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        IUSB keyboard = new Keyboard();
        IUSB print = new Print();
        computer.plugin(keyboard);
        computer.plugin(print);

    }
}
