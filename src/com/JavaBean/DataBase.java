package com.JavaBean;

import java.sql.*;

public class DataBase {
    public static Connection getCon() {
        //在这里只连接数据库，所以只定义Connection
        Connection con = null;
        //加载驱动
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //连接数据库
        try{
            con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=test","sa","157175");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    //关闭连接。在这里统一定义好三个连接的关闭
    public static void close(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement ps){
        if (ps != null) {
           try{
               ps.close();
           }
           catch (SQLException e){
               e.printStackTrace();
           }
        }
    }
    public static void close(Connection con){
        if (con != null) {
            try{
                con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

