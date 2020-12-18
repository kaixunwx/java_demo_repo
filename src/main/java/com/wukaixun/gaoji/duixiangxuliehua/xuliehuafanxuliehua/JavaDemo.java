package com.wukaixun.gaoji.duixiangxuliehua.xuliehuafanxuliehua;

import java.io.*;

/**
 * 对象序列化和反序列化
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
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + "，年龄:" + this.age;
    }
}
