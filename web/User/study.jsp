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
    <link rel="stylesheet" href="css/study.css">
    <title>学习内容</title>
</head>
<body>
<input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
<div class="layui-form" style="margin-top:20px;">
    <div style="width: 225px; float: left;margin-left:20px;">
        <select name="city" lay-verify="test" id="searchType" lay-search>
            <option value="false">未学习</option>
            <option value="true">已学习</option>
        </select>
    </div>
    <button onclick="search()" type="button" class="layui-btn" style="width: 225px; margin-left: 20px;">搜索</button>
</div>
<table class="layui-hide" id="test" lay-filter="test" style="position: relative; top: 200px; "></table>
<div id ="no_video"></div>
</body>
<script src="js/layui.js"></script>
<script src="js/jquery.js"></script>
<script src="js/study.js"></script>
<script type="text/html" id="btn">
    <button onclick="btnAct('play',this)" type="button" class="layui-btn layui-btn-danger layui-btn-xs">播放</button>
    <button onclick="btnAct('download',this)" type="button" class="layui-btn layui-btn-danger layui-btn-xs">下载</button>
</script>
</html>
