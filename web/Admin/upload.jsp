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
    <link rel="stylesheet" href="css/layui.css">
    <title>视频上传</title>
</head>
<body>

<div class="layui-upload">
    <input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
    <div class="layui-upload-list" style="max-width: 1000px;">
        <table class="layui-table">
            <colgroup>
                <col>
                <col width="150">
                <col width="260">
                <col width="150">
            </colgroup>
            <thead>
            <tr><th>文件名</th>
                <th>大小</th>
                <th>上传进度</th>
                <th>操作</th>
            </tr></thead>
            <tbody id="demoList"></tbody>
        </table>
    </div>
    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
</div>

<script src="js/layui.js"></script>
<script src="js/upload.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

</body>
</html>
