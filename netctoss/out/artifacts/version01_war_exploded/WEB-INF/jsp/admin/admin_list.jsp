<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/20
  Time: 18:56
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
  <script language="javascript" type="text/javascript">
    //显示角色详细信息
    function showDetail(flag, a) {
      var detailDiv = a.parentNode.getElementsByTagName("div")[0];
      if (flag) {
        detailDiv.style.display = "block";
      }
      else
        detailDiv.style.display = "none";
    }
    //重置密码
    function resetPwd() {

      var isReset=window.confirm("是否重置密码？");
      if(!isReset){
        return;
      }

      //得到选中的checkbox
      var checkObjs=$(":checkbox[name='check_admin']:checked");
      //判断是否选中了checkbox
      if(checkObjs.length==0){
        alert("请至少选择一个管理员");
        return;
      }
      //取得选中的checkbox行的ID值
      var ids=new Array();
      for(var i=0;i<checkObjs.length;i++){
        //先找到checkbox的爷爷，也就是tr
        var trObj=$(checkObjs[i]).parent().parent();
        //找到该行中第2列，下标为1的td
        var tdObj=$(trObj).children().eq(1);
        //取得ID值
//        alert($(tdObj).text());
        ids.push($(tdObj).text());
      }
      //提交请求
      $.post(
              "resetPassword.form",
              {
                "ids":ids.toString()
              },
              function(data){
                alert(data.message);
              }
      );


    }
    //删除
    function deleteAdmin() {
      var r = window.confirm("确定要删除此管理员吗？");
      document.getElementById("operate_result_info").style.display = "block";
    }
    //全选
    function selectAdmins(inputObj) {
      var inputArray = document.getElementById("datalist").getElementsByTagName("input");
      for (var i = 1; i < inputArray.length; i++) {
        if (inputArray[i].type == "checkbox") {
          inputArray[i].checked = inputObj.checked;
        }
      }
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
  <form action="" method="">
    <!--查询-->
    <div class="search_add">
      <div>
        模块：
        <select id="selModules" class="select_search">
          <option>全部</option>
          <option>角色管理</option>
          <option>管理员管理</option>
          <option>资费管理</option>
          <option>账务账号</option>
          <option>业务账号</option>
          <option>账单管理</option>
          <option>报表</option>
        </select>
      </div>
      <div>角色：<input type="text" value="" class="text_search width200" /></div>
      <div><input type="button" value="搜索" class="btn_search"/></div>
      <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
      <input type="button" value="增加" class="btn_add" onclick="location.href='admin_add.html';" />
    </div>
    <!--删除和密码重置的操作提示-->
    <div id="operate_result_info" class="operate_fail">
      <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
      <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
    </div>
    <!--数据区域：用表格展示数据-->
    <div id="data">
      <table id="datalist">
        <tr>
          <th class="th_select_all">
            <input type="checkbox" onclick="selectAdmins(this);" />
            <span>全选</span>
          </th>
          <th>管理员ID</th>
          <th>姓名</th>
          <th>登录名</th>
          <th>电话</th>
          <th>电子邮件</th>
          <th>授权日期</th>
          <th class="width100">拥有角色</th>
          <th></th>
        </tr>
        <c:forEach items="${admins}" var="admin">
          <tr>
            <td><input type="checkbox" name="check_admin"/></td>
            <td>${admin.admin_id}</td>
            <td>${admin.name}</td>
            <td>${admin.admin_code}</td>
            <td>${admin.telephone}</td>
            <td>${admin.email}</td>
            <td><fmt:formatDate value="${admin.enrolldate}" pattern="yyyy-MM-dd"/></td>
            <td>
              <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">
                <c:forEach items="${admin.roles}" var="role" varStatus="varStatus">
                  <c:if test="${varStatus.first}">${role.name}</c:if>
                  <c:if test="${varStatus.index==1}">……</c:if>
                </c:forEach>
              </a>
              <!--浮动的详细信息-->
              <div class="detail_info">
                <%--超级管理员，角色管理员，账单管理员，报表管理员，业务账号管理员，账务账号管理员，aa，bb--%>
                <c:forEach items="${admin.roles}" var="role" varStatus="varStatus">
                  ${role.name}
                  <c:if test="${!varStatus.last}">、</c:if>
                </c:forEach>
              </div>
            </td>
            <td class="td_modi">
              <input type="button" value="修改" class="btn_modify" onclick="location.href='admin_modi.html';" />
              <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin();" />
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
    <!--分页-->
    <div id="pages">
      <a href="#">上一页</a>
      <a href="#" class="current_page">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">下一页</a>
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
