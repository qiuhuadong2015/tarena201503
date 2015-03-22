<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/14
  Time: 16:45
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
    //显示角色详细信息
    function showDetail(flag, a) {
      var detailDiv = a.parentNode.getElementsByTagName("div")[0];
      if (flag) {
        detailDiv.style.display = "block";
      }
      else
        detailDiv.style.display = "none";
    }
    //删除
    function deleteAccount() {
      var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
      document.getElementById("operate_result_info").style.display = "block";
    }
    //开通或暂停
    function setState() {
      var r = window.confirm("确定要开通此业务账号吗？");
      document.getElementById("operate_result_info").style.display = "block";
    }

    function toPage(targetPage){
      document.getElementById("current_page").value=targetPage;
      document.forms[0].submit();
    }

    function pauseService(id){
      var isaPause=window.confirm("确定要暂停此业务账号吗？");
      if(isaPause){
        window.location.href="pauseService.form?id="+id;
      }
    }

    function startService(id){
      var isStart=window.confirm("确定要开通此业务账号吗？");
      if(isStart){
        window.location.href="startService.form?id="+id;
      }
    }

    function deleteService(id){
      var isDelete=window.confirm("确定要删除此业务账号吗？");
      if(isDelete){
        window.location.href="deleteService.form?id="+id;
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
  <form action="findService.form" method="post">

    <input type="text" name="currentPage" id="current_page" value="${servicePage.currentPage}"/>

    <!--查询-->
    <div class="search_add">
      <div>OS 账号：<input type="text" name="os_username" value="${servicePage.os_username}" class="width100 text_search" /></div>
      <div>服务器 IP：<input type="text" name="unix_host" value="${servicePage.unix_host}" class="width100 text_search" /></div>
      <div>身份证：<input type="text" name="idcard_no" value="${servicePage.idcard_no}" class="text_search" /></div>
      <div>状态：
        <select name="status" class="select_search">
          <option value="-1">全部</option>
          <option value="0" <c:if test="${servicePage.status==0}">selected</c:if>>开通</option>
          <option value="1" <c:if test="${servicePage.status==1}">selected</c:if>>暂停</option>
          <option value="2" <c:if test="${servicePage.status==2}">selected</c:if>>删除</option>
        </select>
      </div>
      <div><input type="button" value="搜索" class="btn_search" onclick="toPage(1)"/></div>
      <input type="button" value="增加" class="btn_add" onclick="location.href='service_add.html';" />
    </div>
    <!--删除的操作提示-->
    <div id="operate_result_info" class="operate_success">
      <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
      删除成功！
    </div>
    <!--数据区域：用表格展示数据-->
    <div id="data">
      <table id="datalist">
        <tr>
          <th class="width50">业务ID</th>
          <th class="width70">账务账号ID</th>
          <th class="width150">身份证</th>
          <th class="width70">姓名</th>
          <th>OS 账号</th>
          <th class="width50">状态</th>
          <th class="width100">服务器 IP</th>
          <th class="width100">资费</th>
          <th class="width200"></th>
        </tr>
        <%--<tr>--%>
          <%--<td><a href="service_detail.html" title="查看明细">1</a></td>--%>
          <%--<td>101</td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>张三</td>--%>
          <%--<td>openlab1</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>192.168.0.23</td>--%>
          <%--<td>--%>
            <%--<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 20 小时</a>--%>
            <%--<!--浮动的详细信息-->--%>
            <%--<div class="detail_info">--%>
              <%--20小时，24.5 元，超出部分 0.03元/分钟--%>
            <%--</div>--%>
          <%--</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td><a href="service_detail.html" title="查看明细">2</a></td>--%>
          <%--<td>101</td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>张三</td>--%>
          <%--<td>openlab2</td>--%>
          <%--<td>暂停</td>--%>
          <%--<td>192.168.100.20</td>--%>
          <%--<td>--%>
            <%--<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 40 小时</a>--%>
            <%--<!--浮动的详细信息-->--%>
            <%--<div class="detail_info">--%>
              <%--40小时，40.5 元，超出部分 0.03元/分钟--%>
            <%--</div>--%>
          <%--</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="开通" class="btn_start" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td><a href="service_detail.html" title="查看明细">3</a></td>--%>
          <%--<td>101</td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>张三</td>--%>
          <%--<td>openlab3</td>--%>
          <%--<td>删除</td>--%>
          <%--<td>192.168.10.23</td>--%>
          <%--<td>--%>
            <%--<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 60 小时</a>--%>
            <%--<!--浮动的详细信息-->--%>
            <%--<div class="detail_info">--%>
              <%--60小时，55 元，超出部分 0.03元/分钟--%>
            <%--</div>--%>
          <%--</td>--%>
          <%--<td class="td_modi">--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td><a href="service_detail.html" title="查看明细">4</a></td>--%>
          <%--<td>102</td>--%>
          <%--<td>230102197902111111</td>--%>
          <%--<td>李四</td>--%>
          <%--<td>openlab1</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>192.168.0.23</td>--%>
          <%--<td>--%>
            <%--<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 20 小时</a>--%>
            <%--<!--浮动的详细信息-->--%>
            <%--<div class="detail_info">--%>
              <%--20小时，24.5 元，超出部分 0.03元/分钟--%>
            <%--</div>--%>
          <%--</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td><a href="service_detail.html" title="查看明细">5</a></td>--%>
          <%--<td>102</td>--%>
          <%--<td>230102197902137862</td>--%>
          <%--<td>张三</td>--%>
          <%--<td>openlab1</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>192.168.0.23</td>--%>
          <%--<td>--%>
            <%--<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 20 小时</a>--%>
            <%--<!--浮动的详细信息-->--%>
            <%--<div class="detail_info">--%>
              <%--20小时，24.5 元，超出部分 0.03元/分钟--%>
            <%--</div>--%>
          <%--</td>--%>
          <%--<td class="td_modi">--%>
            <%--<input type="button" value="暂停" class="btn_pause" onclick="setState();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <c:forEach items="${services}" var="service">
          <tr>
            <td><a href="service_detail.form?id=${service.get("service_id")}" title="查看明细">${service.get("service_id")}</a></td>
            <td>${service.get("account_id")}</td>
            <td>${service.get("idcard_no")}</td>
            <td>${service.get("real_name")}</td>
            <td>${service.get("os_username")}</td>
            <td>${service.get("status")}</td>
            <td>${service.get("unix_host")}</td>
            <td>
              <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.get("cost_name")}</a>
              <!--浮动的详细信息-->
              <div class="detail_info">
                ${service.get("descr")}
              </div>
            </td>
            <td class="td_modi">
              <c:choose >
                <c:when test='${service.get("status")==0}'>
                  <input type="button" value="暂停" class="btn_pause" onclick="pauseService(${service.get("service_id")});" />
                  <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateService.form?id=${service.get("service_id")}';" />
                  <input type="button" value="删除" class="btn_delete" onclick="deleteService(${service.get("service_id")});" />
                </c:when>
                <c:when test='${service.get("status")==1}'>
                  <input type="button" value="开始" class="btn_start" onclick="startService(${service.get("service_id")});" />
                  <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateService.form?id=${service.get("service_id")}';" />
                  <input type="button" value="删除" class="btn_delete" onclick="deleteService(${service.get("service_id")});" />
                </c:when>
                <c:otherwise>

                </c:otherwise>
              </c:choose>

            </td>
          </tr>
        </c:forEach>
      </table>
      <p>业务说明：<br />
        1、创建即开通，记载创建时间；<br />
        2、暂停后，记载暂停时间；<br />
        3、重新开通后，删除暂停时间；<br />
        4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
        5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
        6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
    </div>
    <!--分页-->
    <div id="pages">
      <a href="javascript:toPage(1)">首页</a>
      <c:choose>
        <c:when test="${servicePage.currentPage==1}">
          <a href="#">上一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:toPage(${servicePage.currentPage-1})">上一页</a>
        </c:otherwise>
      </c:choose>
      <c:forEach begin="1" end="${servicePage.totalPage}" var="p">
        <c:choose>
          <c:when test="${p==servicePage.currentPage}">
            <a href="javascript:toPage(${p})" class="current_page">${p}</a>
          </c:when>
          <c:otherwise>
            <a href="javascript:toPage(${p})">${p}</a>
          </c:otherwise>
        </c:choose>
      </c:forEach>
      <c:choose>
        <c:when test="${servicePage.currentPage==servicePage.totalPage}">
          <a href="#">下一页</a>
        </c:when>
        <c:otherwise>
          <a href="javascript:toPage(${servicePage.currentPage+1})">下一页</a>
        </c:otherwise>
      </c:choose>
      <a href="javascript:toPage(${servicePage.totalPage})">末页</a>
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
