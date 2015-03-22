<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/12
  Time: 10:37
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
    //排序按钮的点击事件
    function sort(btnObj) {
      if (btnObj.className == "sort_desc")
        btnObj.className = "sort_asc";
      else
        btnObj.className = "sort_desc";
    }

    //启用
    function startFee() {
      var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
      document.getElementById("operate_result_info").style.display = "block";
    }
    //删除
    function deleteFee(id) {
      var isDelete = window.confirm("确定要删除此资费吗？");
      if(isDelete){
        window.location.href="deleteCost.form?id="+id;
        document.getElementById("operate_result_info").style.display = "block";
      }
    }
  </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
  <img src="../images/logo.png" alt="logo" class="left"/>
  <span>当前账号：<b>scott</b></span>
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
    <!--排序-->
    <div class="search_add">
      <div>
        <input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
      </div>
      <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.form';" />
    </div>
    <!--启用操作的操作提示-->
    <div id="operate_result_info" class="operate_success">
      <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
      删除成功！
    </div>
    <!--数据区域：用表格展示数据-->
    <div id="data">
      <table id="datalist">
        <tr>
          <th>资费ID</th>
          <th class="width100">资费名称</th>
          <th>基本时长</th>
          <th>基本费用</th>
          <th>单位费用</th>
          <th>创建时间</th>
          <th>开通时间</th>
          <th class="width50">状态</th>
          <th class="width200"></th>
        </tr>
        <c:forEach items="${costs}" var="cost">
          <tr>
            <td>${cost.cost_id}</td>
            <td><a href="free_detail.thml">${cost.name}</a></td>
            <td>${cost.base_duration}</td>
            <td>${cost.base_cost}</td>
            <td>${cost.unit_cost}</td>
            <%--<td>${cost.createtime}</td>--%>
            <td><fmt:formatDate value="${cost.createtime}" pattern="yy-MM-dd hh:mm:ss"/></td>
            <td><fmt:formatDate value="${cost.startime}" pattern="yy-MM-dd hh:mm:ss"/></td>
            <%--<td>${cost.startime}</td>--%>
            <td>
              <c:choose>
                <c:when test="${cost.status==0}">暂停</c:when>
                <c:otherwise>开通</c:otherwise>
              </c:choose>
            </td>
            <td>
              <input type="button" value="启用" class="btn_start" onclick="startFee();" />
              <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.form?id=${cost.cost_id}';" />
              <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${cost.cost_id});" />
            </td>
          </tr>
        </c:forEach>
        <%--<tr>--%>
          <%--<td>1</td>--%>
          <%--<td><a href="fee_detail.html">包 20 小时</a></td>--%>
          <%--<td>20 小时</td>--%>
          <%--<td>24.50 元</td>--%>
          <%--<td>3.00 元/小时</td>--%>
          <%--<td>2013/01/01 00:00:00</td>--%>
          <%--<td></td>--%>
          <%--<td>暂停</td>--%>
          <%--<td>--%>
            <%--<input type="button" value="启用" class="btn_start" onclick="startFee();" />--%>
            <%--<input type="button" value="修改" class="btn_modify" onclick="location.href='fee_modi.html';" />--%>
            <%--<input type="button" value="删除" class="btn_delete" onclick="deleteFee();" />--%>
          <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
          <%--<td>2</td>--%>
          <%--<td><a href="fee_detail.html">包 40 小时</a></td>--%>
          <%--<td>40 小时</td>--%>
          <%--<td>40.50 元</td>--%>
          <%--<td>3.00 元/小时</td>--%>
          <%--<td>2013/01/21 00:00:00</td>--%>
          <%--<td>2013/01/23 00:00:00</td>--%>
          <%--<td>开通</td>--%>
          <%--<td>--%>
          <%--</td>--%>
        <%--</tr>--%>
      </table>
      <p>业务说明：<br />
        1、创建资费时，状态为暂停，记载创建时间；<br />
        2、暂停状态下，可修改，可删除；<br />
        3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
        4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
      </p>
    </div>
    <!--分页-->
    <div id="pages">
      <%--<a href="#">上一页</a>--%>

      <%--如果当前是第一页，则不允许点上一页--%>
      <c:choose>
        <c:when test="${costPage.currentPage==1}">
          <a href="#">上一页</a>
        </c:when>
        <c:otherwise>
          <a href="findCost.form?currentPage=${costPage.currentPage-1}">上一页</a>
        </c:otherwise>
      </c:choose>

      <%--循环输出页码，并在输出时判断循环变量是否等于当前页，如果是则在输出页码时设置current_page样式--%>
      <c:forEach begin="1" end="${costPage.totalPage}" var="p">
        <c:choose>
          <c:when test="${p==costPage.currentPage}">
            <a href="findCost.form?currentPage=${p}" class="current_page">${p}</a>
          </c:when>
          <c:otherwise>
            <a href="findCost.form?currentPage=${p}">${p}</a>
          </c:otherwise>
        </c:choose>
      </c:forEach>

      <%--<a href="#" class="current_page">1</a>--%>
      <%--<a href="#">2</a>--%>
      <%--<a href="#">3</a>--%>
      <%--<a href="#">4</a>--%>
      <%--<a href="#">5</a>--%>
      <%--<a href="#">下一页</a>--%>

        <%--如果当前是第一页，则不允许点上一页--%>
        <c:choose>
          <c:when test="${costPage.currentPage==costPage.totalPage}">
            <a href="#">下一页</a>
          </c:when>
          <c:otherwise>
            <a href="findCost.form?currentPage=${costPage.currentPage+1}">下一页</a>
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
