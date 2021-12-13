<%--
  Created by IntelliJ IDEA.
  User: yx492
  Date: 2021/12/13
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/layui.css">
    <title>upload</title>
</head>
<body>
<form action="../Public/upload" method="post" enctype="multipart/form-data">
    <input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="file" name="file" id="file" class="layui-btn"style="margin: 20px;">
    <input type="submit" value="提交" class="layui-btn" style="margin: 20px;">
</form>
</body>
</html>
