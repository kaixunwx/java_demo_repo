package com.wukaixun.gaoji.shujukubiancheng.lianjieoracle.preparedstatement;

import java.sql.*;
import java.util.Date;

/**
 * 通过JDBC连接Oracle数据库
 * 通过PreparedStatement接口操作数据库
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
//        String title = "新闻联播";
//        int readTime = 1111;
//        double price = 19.99;
//        String content = "今天天气真好";
//        Date date = new Date();

        // 插入操作
//        String insertSql = "insert into news(nid, title, read_time, price, content, pubdate) values(news_seq.nextval,?,?,?,?,?)";
//        PreparedStatement pstmt = coon.prepareStatement(insertSql);
//        pstmt.setString(1, title);
//        pstmt.setInt(2, readTime);
//        pstmt.setDouble(3, price);
//        pstmt.setString(4, content);
//        pstmt.setDate(5, new java.sql.Date(date.getTime()));
//        for(int i=0;i< 30; i++){
//            int rows = pstmt.executeUpdate();
//        }
////        System.out.println("更新操作影响行数:" + rows);
        // 查询操作 模糊查询 分页查询
        int currentPage = 2;
        int pageSize = 10;
        String column = "title";
        String keyword = "新闻";
        String sql = "select * from ( " +
                " select nid,title,read_time,price,content,pubdate,ROWNUM rn" +
                " from news where " + column + " like ? and ROWNUM<=? order by nid asc) temp where temp.rn >?";

        PreparedStatement pstmt = coon.prepareStatement(sql);
        pstmt.setString(1,   keyword + "%");
        pstmt.setInt(2, currentPage * pageSize);
        pstmt.setInt(3, (currentPage - 1) * pageSize);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
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
