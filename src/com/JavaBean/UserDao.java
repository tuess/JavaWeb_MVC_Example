package com.JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //查询全部人员
    public List<User> getAllUser(){
        List<User> users=new ArrayList<User>();
        Connection con=DataBase.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement("SELECT TOP 1000 [id]\n" +
                    "      ,[name]\n" +
                    "      ,[tel]\n" +
                    "  FROM [test].[dbo].[User]");
            rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String tel=rs.getString(3);
                User user=new User(id,name,tel);
                users.add(user);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DataBase.close(rs);
            DataBase.close(ps);
            DataBase.close(con);
        }
        return users;
    }

    //数据检查
    public boolean check(int id){
        String sql="SELECT COUNT(*) FROM [test].[dbo].[User] WHERE [id]=?;";
        Connection con=DataBase.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals("1")){
                    return true;
                }
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBase.close(ps);
            DataBase.close(con);
        }
        return false;
    }

    //添加人员
    public boolean add(User user){
        String sql="insert into [test].[dbo].[User] values(?,?,?);";
        Connection con=DataBase.getCon();
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(user.id));
            ps.setString(2,user.name);
            ps.setString(3,user.tel);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBase.close(ps);
            DataBase.close(con);
        }
        return false;
    }

    //删除人员
    public boolean delete(int id){
        String sql="DELETE FROM [test].[dbo].[User] WHERE [id]=?;";
        Connection con=DataBase.getCon();
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBase.close(ps);
            DataBase.close(con);
        }
        return false;
    }

    //修改人员
    public boolean update(User user){
        String sql="UPDATE [test].[dbo].[User] SET [name]=?,[tel]=? WHERE [id]=?;";
        Connection con=DataBase.getCon();
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,user.name);
            ps.setString(2,user.tel);
            ps.setString(3, String.valueOf(user.id));
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DataBase.close(ps);
            DataBase.close(con);
        }
        return false;
    }
}
