package com.wukaixun.gaoji.javajichulei.stringbuffer;

/**
 * StringBuffer类使用
 * String 类是在所有项目开发中一定会使用到到一个功能类，并且拥有如下的特征
 *  --|每一个字符串都是String类的一个匿名对象，并且不可修改
 *  --| String有两个常量池：静态常量池， 运行时常量池
 *  --| String对象实例化推荐以直接赋值的形式完成，这样可以直接把对象保存在常量池中方便下次重用
 *  但是String类最大的弊端是: 内容不允许修改，为了解决此问题，专门提供有一个StringBuffer类可以实现字符串内容的修改
 *
 * @author wukaixun
 * @date 2020.10.14
 */
public class JavaDemo {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello");
        change(str);
        System.out.println(str);

        // StringBuffer类还提供了一些String类没有的操作方法
        // 1.插入字符串
        StringBuffer buf = new StringBuffer(".cn");
        System.out.println("-----插入前字符串:" + buf);
        buf.insert(0, "www.").insert(4, "mldn");
        System.out.println("-----插入后字符串:" + buf);
        // 删除指定范围字符串
        StringBuffer buf1 = new StringBuffer("Hello World!");
        System.out.println("-----删除前字符串:" + buf1);
        buf1.delete(0, 6);
        System.out.println("-----删除后字符串:" + buf1);
        // 反转字符串 在原对象基础上反转
        StringBuffer buf2 = new StringBuffer("Hello World!");
        System.out.println("-----反转前字符串:" + buf2);
        buf2.reverse();
        System.out.println("-----反转后字符串:" + buf2);


    }

    public static void change(StringBuffer temp){
        temp.append(" World!");
    }

}
