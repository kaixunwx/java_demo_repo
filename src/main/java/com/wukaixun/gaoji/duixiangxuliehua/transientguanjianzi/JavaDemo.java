package com.wukaixun.gaoji.duixiangxuliehua.transientguanjianzi;

import java.io.*;

/**
 * transient关键字使用
 * 在序列化过程中，对象有些属性并不需要被序列化，比如某些需要计算得出的属性，使用transient关键字可以实现指定属性不被序列化
 * transient关键字修饰的属性序列化保存的是该属性类型的默认值 比如String类型的默认值为null
 * @author wukaixun
 * @date 2020.11.23
 */
public class JavaDemo {
    public static final File SAVE_FILE = new File("/Users/wukaixun/hello/person.txt");
    public static void main(String[] args) throws Exception{
        Person person = new Person("吴凯勋", 24);
        saveObject(person);
        Object obj = loadObj();
        System.out.println("obj:" + obj);
    }



    public static void saveObject(Object obj) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();
    }

    public static Object loadObj() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

}

class Person implements Serializable {
    private transient String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + "，年龄:" + this.age;
    }
}
