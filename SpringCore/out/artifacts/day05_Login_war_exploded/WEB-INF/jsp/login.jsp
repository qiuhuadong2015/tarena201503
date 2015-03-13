<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/6
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  Hello:  ${msg}

  <form action="/login.form" METHOD="post">
    <input name="msgName" value="${msgName}">
    <input type="submit">
  </form>
${msgName}你好！
</body>
</html>
