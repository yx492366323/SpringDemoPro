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

<form action="login" method="post">
    <input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input id="remember" type="checkbox" name="remember-me" value="true"/>
    <input id="username" type="text" name="username"/>
    <input id="password" type="password" name="password"/>
    <input id="submit" type="submit">
</form>
</body>
</html>
