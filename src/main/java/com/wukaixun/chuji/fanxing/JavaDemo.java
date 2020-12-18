package com.wukaixun.chuji.fanxing;

/**
 * 泛型的基本使用
 *
 * @author wukaixun
 * @date 2020/09/10
 */
class Point<T> {
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return this.x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getY() {
        return this.y;
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        Point<Integer> point = new Point<>();
        point.setX(20);
        point.setY(30);
        System.out.println("x:" + point.getX());
        System.out.println("y:" + point.getY());
    }
}
