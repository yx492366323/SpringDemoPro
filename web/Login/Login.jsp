<%--
  Created by IntelliJ IDEA.
  User: yx492
  Date: 2021/12/1
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
<h3>${_csrf}</h3>
</body>
</html>
