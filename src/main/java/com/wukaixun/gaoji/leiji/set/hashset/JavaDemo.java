package com.wukaixun.gaoji.leiji.set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * HashSet重复数据消除分析
 * @author wukaixun
 * @date 2020.12.03
 */
public class JavaDemo {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("张三", 25));
        set.add(new Person("李四", 22));
        set.add(new Person("李四", 22));
        set.add(new Person("王五", 15));

        set.forEach(System.out::println);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + ", 年龄:" + this.age;
    }
}
