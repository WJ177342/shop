<%--
  Created by IntelliJ IDEA.
  User: WJ177
  Date: 2020/9/27
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=application.getContextPath()%>/admin" method="post">
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
