<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiuhuadong2014
  Date: 2015/3/12
  Time: 14:54
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
    //保存结果的提示
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

    //切换资费类型
    function feeTypeChange(type) {
      var inputArray = document.getElementById("main").getElementsByTagName("input");
      if (type == 1) {
        inputArray[5].readonly = true;
        inputArray[5].value = "";
        inputArray[5].className += " readonly";
        inputArray[6].readonly = false;
        inputArray[6].className = "width100";
        inputArray[7].readonly = true;
        inputArray[7].className += " readonly";
        inputArray[7].value = "";
      }
      else if (type == 2) {
        inputArray[5].readonly = false;
        inputArray[5].className = "width100";
        inputArray[6].readonly = false;
        inputArray[6].className = "width100";
        inputArray[7].readonly = false;
        inputArray[7].className = "width100";
      }
      else if (type == 3) {
        inputArray[5].readonly = true;
        inputArray[5].value = "";
        inputArray[5].className += " readonly";
        inputArray[6].readonly = true;
        inputArray[6].value = "";
        inputArray[6].className += " readonly";
        inputArray[7].readonly = false;
        inputArray[7].className = "width100";
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
  <div id="save_result_info" class="save_success">保存成功！</div>
  <form action="updateCost.form" method="post" class="main_form">
    <div class="text_info clearfix"><span>资费ID：</span></div>
    <div class="input_info"><input name="cost_id" type="text" class="readonly" readonly value="${cost.cost_id}" /></div>
    <div class="text_info clearfix"><span>资费名称：</span></div>
    <div class="input_info">
      <input name="name" type="text" class="width300" value="${cost.name}"/>
      <span class="required">*</span>
      <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
    </div>
    <div class="text_info clearfix"><span>资费类型：</span></div>
    <div class="input_info fee_type">
      <input type="radio" name="cost_type" value="1" <c:if test="${cost.cost_type==1}">checked</c:if> id="monthly" onclick="feeTypeChange(1);" />
      <label for="monthly">包月</label>
      <input type="radio" name="cost_type" value="2" <c:if test="${cost.cost_type==2}">checked</c:if> id="package" onclick="feeTypeChange(2);" />
      <label for="package">套餐</label>
      <input type="radio" name="cost_type" value="3" <c:if test="${cost.cost_type==3}">checked</c:if> id="timeBased" onclick="feeTypeChange(3);" />
      <label for="timeBased">计时</label>
    </div>
    <div class="text_info clearfix"><span>基本时长：</span></div>
    <div class="input_info">
      <input name="base_duration" type="text" value="${cost.base_duration}" class="width100" />
      <span class="info">小时</span>
      <span class="required">*</span>
      <div class="validate_msg_long">1-600之间的整数</div>
    </div>
    <div class="text_info clearfix"><span>基本费用：</span></div>
    <div class="input_info">
      <input name="base_cost" type="text" value="${cost.base_cost}" class="width100" />
      <span class="info">元</span>
      <span class="required">*</span>
      <div class="validate_msg_long">0-99999.99之间的数值</div>
    </div>
    <div class="text_info clearfix"><span>单位费用：</span></div>
    <div class="input_info">
      <input name="unit_cost" type="text" value="${cost.unit_cost}" class="width100" />
      <span class="info">元/小时</span>
      <span class="required">*</span>
      <div class="validate_msg_long">0-99999.99之间的数值</div>
    </div>
    <div class="text_info clearfix"><span>资费说明：</span></div>
    <div class="input_info_high">
                    <textarea name="descr" class="width300 height70">${cost.descr}</textarea>
      <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
    </div>
    <div class="button_info clearfix">
      <input type="submit" value="保存" class="btn_save"  onclick="showResult();" />
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
