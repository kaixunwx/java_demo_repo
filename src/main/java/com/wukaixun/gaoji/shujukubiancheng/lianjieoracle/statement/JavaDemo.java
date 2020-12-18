package com.wukaixun.gaoji.shujukubiancheng.lianjieoracle.statement;


import java.sql.*;
import java.util.Date;

/**
 * 通过JDBC连接Oracle数据库
 * 通过Statement接口操作数据库
 * @author wukaixun
 * @date 2020.12.14
 */
public class JavaDemo {
    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DATABASE_USER = "wkx";
    private static final String DATABASE_PASSWORD = "w2740201";

    public static void main(String[] args) throws Exception {
        Connection coon = null;
        Class.forName(DATABASE_DRIVER);  // 向容器中加载数据库驱动
        coon = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = coon.createStatement();
        // 插入，更新，删除操作
//        String insertSql = "insert into news(nid, title, read_time, price, content, pubdate) VALUES" +
//                " (news_seq.nextval, '今日说法', 24, 9.99, '哈哈哈哈哈'， TO_DATE('2020-12-16', 'yyyy-mm-dd'))";
//        String updateSql = "update news set title='晚间新闻', content='吴凯勋老帅了' where nid = 10";
//        int rows = statement.executeUpdate(updateSql);
//        System.out.println("更新操作影响行数:" + rows);

        // 查询操作
        String querySql = "select nid,title,read_time,price,content,pubdate from news";
        ResultSet rs = statement.executeQuery(querySql);
        while (rs.next()) {
            int nid = rs.getInt(1);
            String title = rs.getString(2);
            int readTime = rs.getInt(3);
            double price = rs.getDouble(4);
            String content = rs.getString(5);
            Date date = rs.getDate(6);
            System.out.println("nid:" + nid + "," + "title:" + title + "," + "read_time:" + readTime + "," + "price:" + price + "," +
                    "content:" + content + "," + "date:" + date);
        }
        coon.close();
    }
}
