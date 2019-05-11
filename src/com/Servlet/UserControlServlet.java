package com.Servlet;

import com.JavaBean.User;
import com.JavaBean.UserDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserControlServlet" , value="/UserControlServlet")
public class UserControlServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //实例化业务对象
        UserDao userDao=new UserDao();
        //调用获取数据方法
        List<User> users=userDao.getAllUser();
        //存储数据
        request.setAttribute("users",users);
        //带数据跳转到其他页面
        request.getRequestDispatcher("user.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
