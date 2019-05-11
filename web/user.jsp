<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/5
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.JavaBean.*" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./resource/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./resource/bootstrap/css/bootstrap.min.css">
    <script src="./resource/jquery.js"></script>
    <script src="./resource/bootstrap/js/bootstrap.js"></script>
</head>
<%
    @SuppressWarnings("unchecked")
    List<User> users = (List<User>) request.getAttribute("users");
%>
<body>
    <div class="container">
        <div class="row">
            <table class="table">
                <tr align="center">
                    <th>ID</th>
                    <th>姓名</th>
                    <th>联系方式</th>
                    <th>操作</th>
                </tr>
                <%
                    for(User user:users){
                %>
                <tr align="center">
                    <td><a href="update.jsp?id=<%=user.getId()%>&name=<%=user.getName()%>&tel=<%=user.getTel()%>"><%=user.getId()%></a></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getTel()%></td>
                    <td><a href="UserDeleteServlet?id=<%=user.getId()%>" class="btn" role="button">删除</a> </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="4"><a href="add.jsp" class="btn" target="iframe_a" role="button">增加</a></td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
