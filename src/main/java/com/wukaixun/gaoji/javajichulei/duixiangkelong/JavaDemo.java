package com.wukaixun.gaoji.javajichulei.duixiangkelong;

/**
 * 对象克隆操作
 * @author wukaixun
 * @date 2020.10.15
 */
class Member implements Cloneable{
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + "]" + "姓名:" + this.name + "，年龄:" + this.age;
    }

    // 父类中的clone方法是私有的，所以子类要覆写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // 调用父类中的clone
    }
}


public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Member memberA = new Member("吴凯勋", 24);
        Member memberB = (Member) memberA.clone();
        System.out.println("memberA:" + memberA);  // 对象内容相同地址不同
        System.out.println("memberB:" + memberB);
    }
}
