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
    <title>账号信息</title>
</head>
<body>
<form class="layui-form layui-form-pane" action="changePassword" method="post">
    <div class="layui-input-inline">
        <input type="password" name="Password" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    </div>
    <input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
</form>
</body>
<script src="js/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</html>
