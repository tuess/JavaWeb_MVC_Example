package com.Servlet;

import com.JavaBean.User;
import com.JavaBean.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserUpdateServlet",value = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取表单提交的数据
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String tel=request.getParameter("tel");
        //实例化User对象
        User user=new User(id,name,tel);
        //实例化业务对象
        UserDao userDao=new UserDao();
        //调用检查是否存在id
        boolean result = userDao.check(id);
        if(result){
            boolean updateresult = userDao.update(user);
            if(updateresult){
                //输出“修改成功”
                PrintWriter out=response.getWriter();
                out.println("<script>alert('修改成功！')</script>");
                out.print("<script language=javascript>setTimeout(parent.location.href='http://localhost:8080/JavaWeb_MVC_war_exploded/',3000);</script>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
