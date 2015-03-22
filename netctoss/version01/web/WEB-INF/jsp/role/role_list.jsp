<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/20
  Time: 10:35
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
    function deleteRole(id) {
      var r = window.confirm("确定要删除此角色吗？");
      if(r){
        window.location.href="deleteRole.form?id="+id;
        document.getElementById("operate_result_info").style.display = "block";
      }
    }

    function toPage(targetPage){
      document.getElementById("current_page").value=targetPage;
      document.forms[0].submit();
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
  <form action="findRole.form" method="post">


    <input type="text" name="currentPage" id="current_page" value="${rolePage.currentPage}"/>


    <!--查询-->
    <div class="search_add">
      <input type="button" value="增加" class="btn_add" onclick="location.href='toAddRole.form';" />
    </div>
    <!--删除的操作提示-->
    <div id="operate_result_info" class="operate_success">
      <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
      删除成功！
    </div> <!--删除错误！该角色被使用，不能删除。-->
    <!--数据区域：用表格展示数据-->
    <div id="data">
      <table id="datalist">
        <tr>
          <th>角色 ID</th>
          <th>角色名称</th>
          <th class="width600">拥有的权限</th>
          <th class="td_modi"></th>
        </tr>

        <c:forEach items="${roles}" var="role">
          <tr>
            <td>${role.role_id}</td>
            <td>${role.name}</td>
            <%--<td>角色管理、管理员管理、资费管理、账务账号、业务账号、账单、报表</td>--%>
            <td>
              <%--循环输出当前角色对应的一组模块名--%>
              <c:forEach items="${role.modules}" var="module" varStatus="varStatus">
                ${module.name}
                <c:if test="${!varStatus.last}">
                  、
                </c:if>
              </c:forEach>
            </td>
            <td>
              <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateRole.form?id=${role.role_id}';"/>
              <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${role.role_id});" />
            </td>
          </tr>
        </c:forEach>

        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td>贾强</td>--%>
          <%--<td>角色管理、管理员管理、资费管理、账务账号、业务账号、账单、报表</td>--%>
          <%--<td>--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='role_modi.html';"/>--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteRole();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td>贾强</td>--%>
          <%--<td>超级管理员、账单管理员</td>--%>
          <%--<td>--%>
            <%--<input type="button" value="修改" class="btn_modify" />--%>
            <%--<input type="button" value="删除" class="btn_delete" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td>贾强</td>--%>
          <%--<td>超级管理员、账单管理员</td>--%>
          <%--<td>--%>
            <%--<input type="button" value="修改" class="btn_modify" />--%>
            <%--<input type="button" value="删除" class="btn_delete" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td>贾强</td>--%>
          <%--<td>超级管理员、账单管理员</td>--%>
          <%--<td>--%>
            <%--<input type="button" value="修改" class="btn_modify" />--%>
            <%--<input type="button" value="删除" class="btn_delete" />--%>
          <%--</td>--%>
        <%--</tr>--%>
      </table>
    </div>
    <!--分页-->
    <div id="pages">
      <%--<a href="#">上一页</a>--%>
      <c:choose>
        <c:when test="${rolePage.currentPage==1}">
          <a href="#">上一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:toPage(${rolePage.currentPage-1})">上一页</a>
        </c:otherwise>
      </c:choose>
      <%--<a href="#" class="current_page">1</a>--%>
      <%--<a href="#">2</a>--%>
      <%--<a href="#">3</a>--%>
      <%--<a href="#">4</a>--%>
      <%--<a href="#">5</a>--%>
      <c:forEach begin="1" end="${rolePage.totalPage}" var="p">
        <c:choose>
          <c:when test="${p==rolePage.currentPage}">
            <a href="javascript:toPage(${p})" class="current_page">${p}</a>
          </c:when>
          <c:otherwise>
            <a href="javascript:toPage(${p})">${p}</a>
          </c:otherwise>
        </c:choose>
      </c:forEach>
      <%--<a href="#">下一页</a>--%>
      <c:choose>
        <c:when test="${rolePage.currentPage==rolePage.totalPage}">
          <a href="#">下一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:toPage(${rolePage.currentPage+1})">下一页</a>
        </c:otherwise>
      </c:choose>
    </div>
  </form>
</div>
<!--主要区域结束-->
<div id="footer">
  <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
  <p>版权所有(C)加拿大达内IT培训集团公司 </p>
</div>
</body>
</html>
