package com.wukaixun.gaoji.bijiaoqi.comparable;

import java.util.Arrays;

/**
 * Comparable比较器
 * @author wukaixun
 * @date 2020.10.20
 */
public class JavaDemo {
    public static void main(String[] args) {
        Person [] people = new Person[]{
                new Person("吴凯勋", 99),
                new Person("陈琪", 88),
                new Person("朱玉", 35)
        };
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
}

class Person implements Comparable<Person>{
    private  String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[Person对象] 姓名:" + this.name + " 年龄:" + this.age + "\n";
    }

    @Override
    /**
     * 比较规则
     * 当前对象 > 比较对象返回正数
     * 当前对象 < 比较对象返回负数
     * 当前对象 = 比较对象返回0
     */
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}
