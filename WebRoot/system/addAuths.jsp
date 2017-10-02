<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
     
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <form action="auth?method=save" method="post">
    <div class="formbody">
    
    <div class="formtitle"><span>添加权限信息</span></div>
    
    <ul class="forminfo">
    <li><label>权限名</label><input name="name" type="text" class="dfinput" value="${auth.name}"/><i>标题不能超过30个字符</i></li>
   
    <li><label>引用地址</label><input name="url" type="text" class="dfinput" value="${auth.url}"/></li>
   	<li id="levels"><label>等级 </label>
   			<select name="levels" class="dfinput" value="${auth.levels}" style="width:50px;margin-top:10px;">
   			
   			<option <c:if test="${auth.levels=='1' }"> selected="selected"</c:if> >一级</option>
   			<option <c:if test="${auth.levels=='2' }"> selected="selected"</c:if> >二级</option>
   			</select> </li>
   	<li id="pid"><label>父级 </label>
   			<select name="parentId" class="dfinput" style="width:100px;margin-top:10px;">
   			<option value="0">无</option>
   			  <c:forEach items="${auths}" var="aut">
              <option value="${aut.id}" <c:if test="${auth.parentId==aut.id }"> selected="selected"</c:if> >${aut.name }</option>
              </c:forEach>
   			</select> </li>		
   			
   	 <li><label>是否审核</label><cite><input name="status" type="radio" value="1" checked="checked" />是
   	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="status" type="radio" value="0" />否</cite></li>		
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    
    
    </div>
	</form>

</body>
</html>
