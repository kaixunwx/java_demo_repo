package com.wukaixun.gaoji.bijiaoqi.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator比较器
 * @author wukaixun
 * @date 2020.10.20
 */
public class JavaDemo {
    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("吴凯勋", 99),
                new Person("陈琪", 88),
                new Person("朱玉", 35)
        };
//        Comparator<Person> comparator = (p1, p2)-> p1.getAge() - p2.getAge();
        Arrays.sort(people, (p1, p2)-> p1.getAge() -p2.getAge());
        System.out.println(Arrays.toString(people));
    }
}

//class PersonComparator implements Comparator<Person>{
//    @Override
//    public int compare(Person p1, Person p2) {
//        return p1.getAge() - p2.getAge();
//    }
//}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "[Person对象] 姓名:" + this.name + " 年龄:" + this.age + "\n";
    }
}
