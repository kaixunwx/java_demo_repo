package com.wukaixun.chuji.fangfayinyong.gouzaofangfa;

/**
 * 方法引用之构造方法引用
 */
class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名:" + this.name + "," + "年龄:" + this.age;
    }
}

@FunctionalInterface
interface IFunction<R>{
    public R create(String name, int age);
}

public class JavaDemo {
    public static void main(String[] args) {
        IFunction<Person> func = Person:: new;
        System.out.println(func.create("吴凯勋", 24));;
    }
}
