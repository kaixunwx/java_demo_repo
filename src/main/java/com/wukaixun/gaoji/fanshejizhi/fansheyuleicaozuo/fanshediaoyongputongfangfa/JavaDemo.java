package com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshediaoyongputongfangfa;


import java.lang.reflect.Method;

/**
 * 反射调用类普通方法，在不导入指定类开发包的情况下实现类的属性配置
 * method.invoke
 * @author wukaixun
 * @date 2020.11.24
 */
public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.wukaixun.gaoji.fanshejizhi.fansheyuleicaozuo.fanshehuoquleijiegou.Person");
        Method [] methods = cls.getMethods();  // 获取类所有方法 包含父类
        for(Method method: methods){
            System.out.println(method);
        }

        System.out.println("-------------------------------");
        Method [] methods1 = cls.getDeclaredMethods();  // 获取本类所有方法
        for(Method method: methods1){
            System.out.println(method);
        }

        System.out.println("---------属性配置-----------");
        String value = "wukaixun";
        // 任何情况下如果想保存类中的属性或调用类中的方法都必须保证有实例化对象，不允许导包，就反射实例化
        Object obj = cls.getDeclaredConstructor().newInstance();  // 调用无参构造
        String setMethodName = "setName";
        Method method = cls.getMethod(setMethodName, String.class);  // 获取方法对象 第一个参数是方法名称，第二个参数是方法所需参数类型
        method.invoke(obj, value); // 调用方法设置属性  // 等价于Person对象.setName()
        String getMethodName = "getName";
        Method method1 = cls.getMethod(getMethodName);
        System.out.println(method1.invoke(obj));;  // 等价于Person对象.getName()
    }
}
