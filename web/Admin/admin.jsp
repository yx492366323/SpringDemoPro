<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Online Pring System</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">Online Print System</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    <span>${username}</span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/user.html">As user</a></dd>
                    <dd><a href="../Login/logout">Sign out</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">统计信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:Change_iframe(1);">数据报表</a></dd>
                        <dd><a href="javascript:Change_iframe(2);">系统信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:Change_iframe(3);">用户信息管理</a></dd>
                        <dd><a href="javascript:Change_iframe(4);">用户密码修改</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a href="javascript:Change_iframe(5);">打印订单管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">设备管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:Change_iframe(6);">打印业务类型</a></dd>
                        <dd><a href="javascript:Change_iframe(7);">增加业务类型</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px; height: 100%;">
            <div class="iframe_div_all" id="iframe_1">
                <iframe class="iframe_one" src="/AdminPrint/statistics.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_2">
                <iframe class="iframe_one" src="/ManageUser/server.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_3">
                <iframe class="iframe_one" src="/ManageUser/user_information.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_4">
                <iframe class="iframe_one" src="/ManageUser/user_password.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_5">
                <iframe class="iframe_one" src="/AdminPrint/orderManager.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_6">
                <iframe class="iframe_one" src="/AdminPrint/model.html" frameborder="0"></iframe>
            </div>
            <div class="iframe_div_all" id="iframe_7">
                    <iframe class="iframe_one" src="/AdminPrint/modelInsert.html" frameborder="0"></iframe>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <h3 id="footer">后台系统 ©2021 Created by 张佳伟</h3>
    </div>
</div>
</body>
<script src="js/layui.js"></script>
<script src="js/admin.js"></script>
</html>