<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/11
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<form action="UserUpdateServlet" name="form1" method="post" onsubmit="return registry()">
    <table class="table">
        <tr>
            <td>ID：</td>
            <td><input type="text" name="id" id="id" class="form-control" value="<%=request.getParameter("id")%>" readonly="readonly" /></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" id="name" class="form-control" value="<%=request.getParameter("name")%>"></td>
        </tr>
        <tr>
            <td>联系方式：</td>
            <%--此处有个神秘bug，该输入框中会每次自增加8个空格，所以要用正则表达式匹配空格--%>
            <td><input type="text" name="tel" id="tel" class="form-control" value="<%=request.getParameter("tel")%>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" class="btn" value="修改"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function registry() {
        var name = document.getElementById("name").value;
        var tel = document.getElementById("tel").value;
        var reg=/(^\s+)|(\s+$)|\s+/g;
        if(name==null){
            alert("姓名不能为空！");
            return false;
        }
        if(reg.test(name)){
            alert("姓名中不能包含空格！");
            return false;
        }
        if(tel==null){
            alert("联系方式不能为空！");
            return false;
        }
        else if(tel.length!==11){
            alert("联系方式必须为11位！")
            return false;
        }
        if(reg.test(tel)){
            alert("联系方式中不能包含空格！");
            return false;
        }
        return true;
    }
</script>
</html>
