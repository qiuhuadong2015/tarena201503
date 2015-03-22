<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path=request.getContextPath();
%>
<ul id="menu">
  <%--每个用户都能访问首页，固定要显示--%>
  <li>
    <c:if test="${currentModuleId==0}">
      <a href="<%=path%>/login/toIndex.form" class="index_on"></a>
    </c:if>
    <c:if test="${currentModuleId!=0}">
      <a href="<%=path%>/login/toIndex.form" class="index_off"></a>
    </c:if>
  </li>

    <%--业务模块需要根据用户权限来动态初始化--%>

    <c:forEach items="${canViewModules}" var="module">
      <c:if test="${module.module_id==1}">
        <c:if test="${currentModuleId==1}">
          <li><a href="<%=path%>/role/findRole.form" class="role_on"></a></li>
        </c:if>
        <c:if test="${currentModuleId!=1}">
          <li><a href="<%=path%>/role/findRole.form" class="role_off"></a></li>
        </c:if>
      </c:if>
      <c:if test="${module.module_id==2}">
        <c:if test="${currentModuleId==2}">
          <li><a href="<%=path%>/admin/findAdmin.form" class="admin_on"></a></li>
        </c:if>
        <c:if test="${currentModuleId!=2}">
          <li><a href="<%=path%>/admin/findAdmin.form" class="admin_off"></a></li>
        </c:if>
      </c:if>
      <c:if test="${module.module_id==3}">
        <c:if test="${currentModuleId==3}">
          <li><a href="<%=path%>/cost/findCost.form" class="fee_on"></a></li>
        </c:if>
        <c:if test="${currentModuleId!=3}">
          <li><a href="<%=path%>/cost/findCost.form" class="fee_off"></a></li>
        </c:if>
      </c:if>
      <c:if test="${module.module_id==4}">
        <c:if test="${currentModuleId==4}">
          <li><a href="<%=path%>/account/findAccount.form" class="account_on"></a></li>
        </c:if>
        <c:if test="${currentModuleId!=4}">
          <li><a href="<%=path%>/account/findAccount.form" class="account_off"></a></li>
        </c:if>
      </c:if>
      <c:if test="${module.module_id==5}">
        <c:if test="${currentModuleId==5}">
          <li><a href="<%=path%>/service/findService.form" class="service_on"></a></li>
        </c:if>
        <c:if test="${currentModuleId!=5}">
          <li><a href="<%=path%>/service/findService.form" class="service_off"></a></li>
        </c:if>
      </c:if>
      <c:if test="${module.module_id==6}">
        <li><a href="#" class="bill_off"></a></li>
      </c:if>
      <c:if test="${module.module_id==7}">
        <li><a href="#" class="report_off"></a></li>
      </c:if>

    </c:forEach>



    <%--每个用户都能访问个人信息、修改密码，固定显示--%>
  <li><a href="#" class="information_off"></a></li>
  <li><a href="#" class="password_off"></a></li>
</ul>