package com.wukaixun.chuji.danliduoli;

/**
 * 多例设计模式
 * @author wukaixun
 * @date 2020/09/16
 */
class Color{
    private static final Color RED = new Color("红色");
    private static final Color GREEN = new Color("绿色");
    private static final Color BLUE = new Color("蓝色");

    private String title;
    private Color(String title){
        this.title = title;
    };

    public static Color getInstance(String color){
        switch (color){
            case "red": return RED;
            case "green": return GREEN;
            case "blue": return BLUE;
            default: return null;
        }
    }

    public String toString(){
        return this.title;
    }
}


public class JavaDemo2 {
    public static void main(String[] args) {
        Color color = Color.getInstance("red");
        System.out.println(color);
    }
}
