package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshediaoyonggouzaofangfa;

import com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshehuoquleijiegou.Person;

import java.lang.reflect.Constructor;

/**
 * 通过反射机制调用类构造方法
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Person.class;
//        Constructor<?> [] constructors = cls.getConstructors();  // 获取所有构造方法
//        for(Constructor<?> temp: constructors){
//            System.out.println(temp);
//        }

        Constructor<?> constructor = cls.getConstructor(String.class, int.class);  // 通过指定构造方法的参数类型获取指定构造方法
        Object obj = constructor.newInstance("吴凯勋",24);  // 通过获取到的构造方法实例化类对象
        System.out.println(obj);
    }
}
