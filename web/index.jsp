<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/5
  Time: 14:47
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
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="jumbotron text-center" style="margin-bottom:0">
                <p>简单的数据库的增删查改</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <iframe src="UserControlServlet" name="iframe_a" width="100%" height="100%" scrolling="no" frameborder="0"></iframe>
        </div>
    </div>
</div>
</body>
</html>
