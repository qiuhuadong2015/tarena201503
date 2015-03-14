<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/14
  Time: 9:08
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
//    //删除——自己重新写
//    function deleteAccount() {
//      var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
//      document.getElementById("operate_result_info").style.display = "block";
//    }
//    //开通或暂停——自己重新写
//    function setState() {
//      var r = window.confirm("确定要开通此账务账号吗？");
//      document.getElementById("operate_result_info").style.display = "block";
//    }

    function pause_account(id){
      var isPause=window.confirm("确定要暂停此账务账号吗？");
      if(isPause){
        window.location.href="pauseAccount.form?id="+id;
      }
    }

    function start_account(id){
      var isStart=window.confirm("确定要开通此账务账号吗？");
      if(isStart){
        window.location.href="startAccount.form?id="+id;
      }
    }

    function delete_account(id){
      var isDelete=window.confirm("确定要删除此账务账号吗？");
      if(isDelete){
        window.location.href="deleteAccount.form?id="+id;
      }
    }

    //我的追加：翻页
    function to_page(currengt_page){
      //将传入的页码赋值给表单中的页码文本框
      document.getElementById("current_page").value=currengt_page;
      //提交表单，实现带条件的分页查询
      //获取页面的所有表单数组，这里只有一个表单所有下标为0
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
  <ul id="menu">
    <li><a href="../index.html" class="index_off"></a></li>
    <li><a href="../role/role_list.html" class="role_off"></a></li>
    <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
    <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
    <li><a href="../account/account_list.html" class="account_on"></a></li>
    <li><a href="../service/service_list.html" class="service_off"></a></li>
    <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
    <li><a href="../report/report_list.html" class="report_off"></a></li>
    <li><a href="../user/user_info.html" class="information_off"></a></li>
    <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
  </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
  <form action="findAccount.form" method="post">
    <%--追加页码条件，用于翻页--%>
    <input type="text" name="currentPage" id="current_page" value="${accountPage.currentPage}"/>

    <!--查询-->
    <div class="search_add">
      <div>身份证：<input name="idcard_no" value="${accountPage.idcard_no}" type="text" class="text_search" /></div>
      <div>姓名：<input name="real_name" value="${accountPage.real_name}" type="text" class="width70 text_search" /></div>
      <div>登录名：<input name="login_name" value="${accountPage.login_name}" type="text" class="text_search" /></div>
      <div>
        状态：
        <select name="status" class="select_search">
          <option value="-1" >全部</option>
          <option value="0" <c:if test="${accountPage.status==0}">selected</c:if>>开通</option>
          <option value="1" <c:if test="${accountPage.status==1}">selected</c:if>>暂停</option>
          <option value="2" <c:if test="${accountPage.status==2}">selected</c:if>>删除</option>
        </select>
      </div>
      <div><input type="button" value="搜索" class="btn_search" onclick="to_page(1)" /></div>
      <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.html';" />
    </div>
    <!--删除等的操作提示-->
    <div id="operate_result_info" class="operate_success">
      <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
      删除成功，且已删除其下属的业务账号！
    </div>
    <!--数据区域：用表格展示数据-->
    <div id="data">
      <table id="datalist">

        <tr>
          <th>账号ID</th>
          <th>姓名</th>
          <th class="width150">身份证</th>
          <th>登录名</th>
          <th>状态</th>
          <th class="width100">创建日期</th>
          <th class="width150">上次登录时间</th>
          <th class="width200"></th>
        </tr>

        <c:forEach items="${accounts}" var="account">
          <tr>
          <td>${account.account_id}</td>
          <td><a href="account_detail.html">${account.real_name}</a></td>
          <td>${account.idcard_no}</td>
          <td>${account.login_name}</td>
          <td>
            <c:choose>
              <c:when test="${account.status==0}">开通</c:when>
              <c:when test="${account.status==1}">暂停</c:when>
              <c:otherwise>删除</c:otherwise>
            </c:choose>
          </td>
          <td><fmt:formatDate value="${account.create_date}" pattern="yyyy-MM-dd"/></td>
          <td>${account.last_login_time}</td>
          <td class="td_modi">
            <c:choose>
              <c:when test="${account.status==0}">
                <input type="button" value="暂停" class="btn_pause" onclick="pause_account(${account.account_id});" />
                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateAccount.form?id=${account.account_id}';" />
                <input type="button" value="删除" class="btn_delete" onclick="delete_account(${account.account_id});" />
              </c:when>
              <c:when test="${account.status==1}">
                <input type="button" value="开通" class="btn_start" onclick="start_account(${account.account_id});" />
                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateAccount.form?id=${account.account_id}';" />
                <input type="button" value="删除" class="btn_delete" onclick="delete_account(${account.account_id});" />
              </c:when>
              <c:otherwise>

              </c:otherwise>
            </c:choose>
          <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
          <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />--%>
          <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          </td>
          </tr>
        </c:forEach>

        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td><a href="account_detail.html">贾强</a></td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>jiaqiang</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>2013-01-23</td>--%>
          <%--<td>2013-02-23 00:00:00</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>2</td>--%>
          <%--<td><a href="account_detail.html">贾强</a></td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>jiaqiang</td>--%>
          <%--<td>暂停</td>--%>
          <%--<td>2013-01-23</td>--%>
          <%--<td>2013-02-23 00:00:00</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="开通" class="btn_start" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>3</td>--%>
          <%--<td><a href="account_detail.html">贾强</a></td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>jiaqiang</td>--%>
          <%--<td>删除</td>--%>
          <%--<td>2013-01-23</td>--%>
          <%--<td>2013-02-23 00:00:00</td>--%>
          <%--<td class="td_modi">--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>4</td>--%>
          <%--<td><a href="account_detail.html">贾强</a></td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>jiaqiang</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>2013-01-23</td>--%>
          <%--<td>2013-02-23 00:00:00</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>5</td>--%>
          <%--<td><a href="account_detail.html">贾强</a></td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>jiaqiang</td>--%>
          <%--<td>暂停</td>--%>
          <%--<td>2013-01-23</td>--%>
          <%--<td>2013-02-23 00:00:00</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="开通" class="btn_start" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
      </table>
      <p>业务说明：<br />
        1、创建则开通，记载创建时间；<br />
        2、暂停后，记载暂停时间；<br />
        3、重新开通后，删除暂停时间；<br />
        4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
        5、暂停账务账号，同时暂停下属的所有业务账号；<br />
        6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
        7、删除账务账号，同时删除下属的所有业务账号。</p>
    </div>
    <!--分页-->
    <div id="pages">
      <a href="javascript:to_page(1)">首页</a>
      <%--<a href="#">上一页</a>--%>
      <c:choose>
        <c:when test="${accountPage.currentPage==1}">
          <a href="#">上一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:to_page(${accountPage.currentPage}-1)">上一页</a>
        </c:otherwise>
      </c:choose>
      <c:forEach begin="1" end="${accountPage.totalPage}" var="p">
        <c:choose>
          <c:when test="${p==accountPage.currentPage}">
            <a href="javascript:to_page(${p})" class="current_page">${p}</a>
          </c:when>
          <c:otherwise>
            <a href="javascript:to_page(${p})">${p}</a>
          </c:otherwise>
        </c:choose>
      </c:forEach>
      <%--<a href="#" class="current_page">1</a>--%>
      <%--<a href="#">2</a>--%>
      <%--<a href="#">3</a>--%>
      <%--<a href="#">4</a>--%>
      <%--<a href="#">5</a>--%>
      <%--<a href="#">下一页</a>--%>
      <c:choose>
        <c:when test="${accountPage.currentPage==accountPage.totalPage}">
          <a href="#">下一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:to_page(${accountPage.currentPage+1})">下一页</a>
        </c:otherwise>
      </c:choose>
      <a href="javascript:to_page(${accountPage.totalPage})">末页</a>
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
