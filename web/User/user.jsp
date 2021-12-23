<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>青年大学习</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel="stylesheet" href="css/user.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="background-color: #ff4917;">
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <div class="layui-logo layui-hide-xs" id="Title">青年大学习</div>
        <ul class="layui-nav" id="Nav">
            <li class="layui-nav-item">
                <a class="Nav-all" href="javascript:Change_iframe(1);">
                    <span style="width: 90px;display: block;">学习内容</span>
                    <span class="layui-badge Nav-all" style="left: 80px;">${count1}</span>
                </a>
            </li>
            <li class="layui-nav-item Nav-all">
                <a class="Nav-all" href="javascript:Change_iframe(2);">账号信息</a>
            </li>
        </ul>
        <div id="Refresh" onclick="Reload_iframe()">
            <i class="layui-icon layui-icon-refresh" style="font-size: 30px;"></i>
            <h4>刷 新</h4>
        </div>
        <ul class="layui-nav layui-layout-right" id="user-menu-img">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a id="user-menu-button" href="javascript:;">
                    <img src="../Public/Img/face_1.jpg" class="layui-nav-img">
                    <span>${username}</span>
                </a>
                <dl class="layui-nav-child">
                    ${AdminLogin}
                    <dd><a href="../Login/logout">Logout</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

<!-- 内容主体区域 -->
<div style="padding: 15px; top:40px; position:fixed; width: 100%;height: 95%;">
    <div class="iframe_div_all" id="iframe_1">
        <iframe class="iframe_one" src="study.jsp" frameborder="0"></iframe>
    </div>
    <div class="iframe_div_all" id="iframe_2" style="display:none">
        <iframe class="iframe_one" src="userinfo.jsp" frameborder="0"></iframe>
    </div>
</div>



</body>
<script src="js/layui.js"></script>
<script src="js/user.js"></script>
</html>