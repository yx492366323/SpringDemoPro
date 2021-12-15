<%--
  Created by IntelliJ IDEA.
  User: yx492
  Date: 2021/12/14
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/layui.css">
    <title>视频管理系统</title>
</head>
<body>
<input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
<div class="layui-form" style="margin-top:20px;">
    <div style="width: 225px; float: left;margin-left:20px;">
        <select name="city" lay-verify="test" id="searchType" lay-search>
            <option value="UserName">UserName</option>
            <option value="IDCard">IDCardNumber</option>
            <option value="Phone">PhoneNumber</option>
            <option value="UserRoles">UserRoles</option>
        </select>
    </div>
    <input class="layui-input" name="condition" id="searchCondition" autocomplete="off"
           style="width: 225px; float: left; margin-left: 20px;">
    <button onclick="search()" type="button" class="layui-btn" style="width: 225px; margin-left: 20px;">搜索</button>
</div>
<table class="layui-hide" id="test" lay-filter="test" style="position: relative; top: 200px; "></table>
</body>
<script src="js/layui.js"></script>
<script src="js/jquery.js"></script>
<script src="js/videoinfo.js"></script>
<script type="text/html" id="btn">
    <button onclick="btnAct('del',this)" type="button" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
</script>
</html>
