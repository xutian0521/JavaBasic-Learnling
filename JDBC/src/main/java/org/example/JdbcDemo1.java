package org.example;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //System.out.println("11");
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.31.62/eesy","root","123456");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm= conn.prepareStatement("select * from account;");
        //4.执行SQL，得到结果集
        ResultSet rs= pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
