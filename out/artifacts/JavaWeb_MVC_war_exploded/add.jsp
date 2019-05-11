<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/5
  Time: 16:33
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
<body>
<div class="container">
    <div class="row">
        <form action="UserAddServlet" name="form1" method="post" style="width: 100%" onsubmit="return registry()">
            <table class="table">
                <tr>
                    <td>
                        ID：<input type="text" name="id" id="id" class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>
                        姓名：<input type="text" name="name" id="name" class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>
                        联系方式：<input type="tel" name="tel" id="tel" class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="submit" class="btn" value="添加">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script>
    function registry() {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var tel = document.getElementById("tel").value;
        var reg=/(^\s+)|(\s+$)|\s+/g;
        if(id==null){
            alert("Id不能为空！");
            return false;
        }
        else if(id.length!==5){
            alert("ID长度必须为5位！");
            return false;
        }
        else if(reg.test(id)){
            alert("ID中不能包含空格！");
            return false;
        }
        if(name==null){
            alert("姓名不能为空！");
            return false;
        }
        else if(reg.test(name)){
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
        else if(reg.test(tel)){
            alert("联系方式中不能包含空格！");
            return false;
        }
         return true;
    }
</script>
</html>
