package com.wukaixun.gaoji.leiji.set.treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * 使用TreeSet存储自定义类型
 * 在使用自定义类进行比较处理的时候，一定要将该类中的所有属性依次进行大小比较，
 * 否则某些或某个属性相同的时候会被认为是相同数据。因此得出结论TreeSet是通过Comparable接口实现重复元素判断
 * @author wukaixun
 * @date 2020.12.03
 */
public class JavaDemo {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("吴凯勋",24));
        set.add(new Person("吴凯勋", 21));
        set.add(new Person("朱玉", 24));
        set.add(new Person("王培培", 26));
        set.forEach(System.out::println);
    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + "," + "年龄：" + this.age;
    }

    @Override
    public int compareTo(Person per) {
        if(this.age < per.age){
            return -1;
        } else if(this.age > per.age){
            return 1;
        } else {
            return this.name.compareTo(per.name);
        }
    }
}

