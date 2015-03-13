<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/5
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
  <title>登陆</title>
  <style>
    h1, h2, h3, h4, p, div {
      padding: 0;
      margin: 0;
    }

    div {
      border: 1px solid #ddd;
      padding: 5px;
      width: 280px;
      margin: 0 auto;
    }

    div h2 {
      color: white;
      background: black;
      text-align: center;
      padding: 6px;
    }

    div p {
      background: #eee;
      padding: 6px;
    }

    div h3 {
      background: #ddd;
      text-align: center;
      padding: 6px;
    }

    div h4 {
      color: red;
      background: black;
      text-align: center;
    }
  </style>
</head>
<body>
  <h1>Spring参数传递演示</h1>
  <div>
    <form action="" method="post"Z>
      <h2>登陆</h2>
      <p>账号：<input type="text" name="username"></p>
      <p>密码：<input type="password" name="pwd"></p>
      <h3><input type="submit" value="login"></h3>
    </form>
  </div>
</body>
</html>
