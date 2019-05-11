package com.Servlet;

import com.JavaBean.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet",value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取表单提交的数据
        int id= Integer.parseInt(request.getParameter("id"));
        //实例化业务对象
        UserDao userDao = new UserDao();
        //检查数据
        boolean result = userDao.check(id);
        if(result){
           //调用删除方法
            boolean deleteresult = userDao.delete(id);
            if(deleteresult){
                response.getWriter().print("<script>alert('删除成功！')</script>");
                response.getWriter().print("<script language=javascript>setTimeout(parent.location.href='http://localhost:8080/JavaWeb_MVC_war_exploded/',3000);</script>");
            }
    }
        else{
            response.getWriter().print("<script>alert('id不存在！');</script>");
            response.getWriter().print("<script language=javascript>setTimeout(parent.location.href='http://localhost:8080/JavaWeb_MVC_war_exploded/',3000);</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
