<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>青年大学习后台管理系统</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel="stylesheet" href="css/user.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="background-color: #4D5260;">
        <div class="layui-logo layui-hide-xs layui-bg-black">青年大学习后台管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
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
                    <%--                    <dd><a href="/user.html">As User Login</a></dd>--%>
                    <dd><a href="../Login/logout">Logout</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <%--                <li class="layui-nav-item layui-nav-itemed">--%>
                <%--                    <a href="javascript:;">统计信息</a>--%>
                <%--                    <dl class="layui-nav-child">--%>
                <%--                        <dd class="layui-this"><a href="javascript:Change_iframe(1);">系统信息</a></dd>--%>
                <%--                        <dd><a href="javascript:Change_iframe(2);">数据报表</a></dd>--%>
                <%--                    </dl>--%>
                <%--                </li>--%>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a href="javascript:Change_iframe(3);">用户信息管理</a></dd>
                        <%--                        <dd><a href="javascript:Change_iframe(4);">用户密码修改</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">内容管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:Change_iframe(5);">视频管理</a></dd>
                        <dd><a href="javascript:Change_iframe(6);">视频上传</a></dd>
                    </dl>
                </li>
                <%--                <li class="layui-nav-item">--%>
                <%--                    <a href="javascript:;">设备管理</a>--%>
                <%--                    <dl class="layui-nav-child">--%>
                <%--                        <dd><a href="javascript:Change_iframe(7);">增加业务类型</a></dd>--%>
                <%--                    </dl>--%>
                <%--                </li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px; height: 100%;">
            <%--            <div class="iframe_div_all" id="iframe_1">--%>
            <%--                <iframe class="iframe_one" src="admin.jsp" frameborder="0"></iframe>--%>
            <%--            </div>--%>
            <%--            <div class="iframe_div_all" id="iframe_2">--%>
            <%--                <iframe class="iframe_one" src="/ManageUser/server.html" frameborder="0"></iframe>--%>
            <%--            </div>--%>
            <div class="iframe_div_all" id="iframe_3">
                <iframe class="iframe_one" src="userinfo" frameborder="0"></iframe>
            </div>
            <%--            <div class="iframe_div_all" id="iframe_4">--%>
            <%--                <iframe class="iframe_one" src="/ManageUser/user_password.html" frameborder="0"></iframe>--%>
            <%--            </div>--%>
            <div class="iframe_div_all" id="iframe_5">
                <iframe class="iframe_one" src="videoinfo" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_6">
                <iframe class="iframe_one" src="upload" frameborder="0"></iframe>
            </div>
            <%--            <div class="iframe_div_all" id="iframe_7">--%>
            <%--                    <iframe class="iframe_one" src="/AdminPrint/modelInsert.html" frameborder="0"></iframe>--%>
            <%--            </div>--%>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <h3 id="footer">后台系统 ©2021 Created by 张佳伟</h3>
    </div>
</div>
</body>
<script src="js/layui.js"></script>
<script src="js/user.js"></script>
</html>