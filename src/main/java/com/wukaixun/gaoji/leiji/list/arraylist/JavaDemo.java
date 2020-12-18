package com.wukaixun.gaoji.leiji.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList保存自定义对象
 *
 * @author wukaixun
 * @date 2020.12.03
 * 使用ArrayList保存自定义对象，当涉及到remove和contains操作时，必须要覆写自定义对象的equals方法
 */
public class JavaDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("吴凯勋", 24));
        list.add(new Person("王培培", 25));
        list.add(new Person("宋鑫龙", 23));

        list.remove(new Person("吴凯勋", 24));
        list.forEach(System.out::println);
        System.out.println(list.contains(new Person("宋鑫龙", 23)));
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
    public String toString() {
        return "姓名:" + this.name + "," + "年龄:" + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Person)){
            return false;
        }

        Person per = (Person) obj;
        return this.name.equals(per.name) && this.age == per.age;

    }
}
