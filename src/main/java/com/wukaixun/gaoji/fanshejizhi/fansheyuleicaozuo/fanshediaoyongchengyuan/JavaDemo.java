package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshediaoyongchengyuan;

import java.lang.reflect.Field;

/**
 * 反射调用类成员属性
 *
 * @author wukaixun
 * @date 2020.11.25
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshehuoquleijiegou.Person");
        Field [] fields = cls.getFields();  // 获取父类成员属性
        for(Field field: fields){
            System.out.println(field);
        }
        System.out.println("-------------------------------");
        Field [] fields1 = cls.getDeclaredFields();  // 获取本类成员属性
        for(Field field: fields1){
            System.out.println(field);
        }

        Object obj = cls.getConstructor().newInstance();  // 反射实例化对象
        Field field = cls.getDeclaredField("name");  // 获取成员对象
        field.setAccessible(true);  // name属性为private 需要解除封装
        field.set(obj, "吴凯勋");  // 设置name属性value值
        System.out.println(field.get(obj));;  // 获取name属性value值
        // 虽然Field支持直接解除封装后操作成员属性，但是实际开发中不建议这样使用，推荐使用setter，getter方法

        System.out.println("-----获取name成员类型----");
        System.out.println("name成员类型:" + field.getType().getSimpleName());
    }
}
