<%--
  Created by IntelliJ IDEA.
  User: Jasper
  Date: 2016/11/4
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome user!</title>
</head>
<body>
<form action="/user/login" method="post">
    用户名:<input type="text" name="username" value="${username}"/>
    密码: <input type="password" name="password"/>

    <input type="submit" value="提交"/>
</form>
</body>
</html>
