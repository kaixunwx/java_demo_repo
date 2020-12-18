package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshehuoquleijiegou;

public class Person extends MyClass implements IChannel, IMessage {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名:" + this.name + "，年龄:" + this.age;
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void send() {
        if (this.connect()) {
            System.out.println("哈哈哈哈哈");
        }
    }
}
