package com.wukaixun.gaoji.fanshejizhi.renshifanshejizhi;

import com.wukaixun.gaoji.fanshejizhi.Student;

/**
 * 获取Class对象的三种方法
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        // 方法1 通过实例化对象获取
        Student student = new Student();  // new 产生一个Student对象 一个Class对象
        Class stuClass = student.getClass(); // 获取class对象
        System.out.println(stuClass.getName());  // 获取类的完整名称

        // 方法2  通过类.class获取
        Class stuClass1 = Student.class;
        System.out.println(stuClass1.getName());
        System.out.println(stuClass == stuClass1);  // 判断第一种方式获取的class对象和第二种方式获取的class对象是否同一个

        // 方法3  通过Class.forName()获取
        Class stuClass2 = Class.forName("com.wukaixun.gaoji.fanshejizhi.Student");  // 此路径必须是真实路径
        System.out.println(stuClass2.getName());
        System.out.println(stuClass == stuClass2);
    }
}
