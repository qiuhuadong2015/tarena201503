<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/20
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>达内－NetCTOSS</title>
  <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
  <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
  <script language="javascript" type="text/javascript">
    //保存成功的提示消息
    function showResult() {
      showResultDiv(true);
      window.setTimeout("showResultDiv(false);", 3000);
    }
    function showResultDiv(flag) {
      var divResult = document.getElementById("save_result_info");
      if (flag)
        divResult.style.display = "block";
      else
        divResult.style.display = "none";
    }
  </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
  <img src="../images/logo.png" alt="logo" class="left"/>
  <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
  <jsp:include page="/WEB-INF/jsp/main/menu.jsp"/>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
  <!--保存操作后的提示信息：成功或者失败-->
  <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
  <form action="addRole.form" method="post" class="main_form">
    <div class="text_info clearfix"><span>角色名称：</span></div>
    <div class="input_info">
      <input type="text" class="width200" name="name"/>
      <span class="required">*</span>
      <div class="validate_msg_medium">不能为空，且为20长度的字母、数字和汉字的组合</div>
    </div>
    <div class="text_info clearfix"><span>设置权限：</span></div>
    <div class="input_info_high">
      <div class="input_info_scroll">
        <ul>
          <c:forEach items="${modules}" var="module">
            <li>
              <input id="chbox_module_${module.name}" type="checkbox" name="module_ids" value="${module.module_id}"/>
              <label for="chbox_module_${module.name}">${module.name}</label>
            </li>
          </c:forEach>
          <%--<li><input type="checkbox" />管理员管理</li>--%>
          <%--<li><input type="checkbox" />角色管理</li>--%>
          <%--<li><input type="checkbox" />资费管理</li>--%>
          <%--<li><input type="checkbox" />账务账号</li>--%>
          <%--<li><input type="checkbox" />业务账号</li>--%>
          <%--<li><input type="checkbox" />账单</li>--%>
          <%--<li><input type="checkbox" />报表</li>--%>
        </ul>
      </div>
      <span class="required">*</span>
      <div class="validate_msg_tiny">至少选择一个权限</div>
    </div>
    <div class="button_info clearfix">
      <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
      <input type="button" value="取消" class="btn_save" />
    </div>
  </form>
</div>
<!--主要区域结束-->
<div id="footer">
  <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
  <br />
  <span>版权所有(C)加拿大达内IT培训集团公司 </span>
</div>
</body>
</html>
