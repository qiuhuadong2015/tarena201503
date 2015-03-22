<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/20
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>达内－NetCTOSS</title>
  <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
  <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
  <script type="text/javascript" src="/javascript/jquery-2.1.3.js"></script>
  <script type="text/javascript">
    //登陆验证
    function check_login(){
      //验证账号是否为空
      var admin_code=$("#admin_code").val();
      if(admin_code==""){
        $("#admin_code_message").text("请输入用户名");
        return;
      }
      //验证密码是否为空
      var password=$("#password").val();
      if(password==""){
        $("#password_message").text("请输入密码");
        return;
      }
      //自行补充格式验证
      //提交表单，验证账号密码是否正确
      $.post(
              "checkLogin.form",
//              变成请求的属性,形如:?xxx=xxx and xxx=xxx
              $("#loginForm").serialize(),
              function (data) {
                if(data.loginStatus==1){
                  //账号错误
                  $("#admin_code_message").text("账号错误");
                }else if(data.loginStatus==2){
                  //密码错误
                  $("#password_message").text("密码错误");
                }else{
                  //登陆成功，跳转到系统首页
                  window.location.href="toIndex.form";
                }
              }
      );
    }

    //输入文本框获得焦点时，重置
  </script>
</head>
<body class="index">
<div class="login_box">
  <form id="loginForm">

  <table>
    <tr>
      <td class="login_info">账号：</td>
      <td colspan="2"><input id="admin_code" name="adminCode" type="text" class="width150" /></td>
      <td class="login_error_info"><span id="admin_code_message" class="required">30长度的字母、数字和下划线</span></td>
    </tr>
    <tr>
      <td class="login_info">密码：</td>
      <td colspan="2"><input id="password" name="password" type="password" class="width150" /></td>
      <td><span id="password_message" class="required">30长度的字母、数字和下划线</span></td>
    </tr>
    <tr>
      <td class="login_info">验证码：</td>
      <td class="width70"><input type="text" class="width70" /></td>
      <td><img src="../images/valicode.jpg" alt="验证码" title="点击更换" /></td>
      <td><span class="required">
        <%--验证码错误--%>
      </span></td>
    </tr>
    <tr>
      <td></td>
      <td class="login_button" colspan="2">
        <a href="javascript:check_login()"><img src="../images/login_btn.png" /></a>
      </td>
      <td><span class="required">
        <%--用户名或密码错误，请重试--%>
      </span></td>
    </tr>
  </table>
  </form>
</div>
</body>
</html>
