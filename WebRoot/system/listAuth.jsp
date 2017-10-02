<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>权限名称</th>
        <th>&nbsp;</th>
        <th>访问地址</th>
        <th>等级</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
         <c:forEach items="${parentAuths}" var="p">     
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
         <td>${p.id}</td>
        <td>${p.name}</td>
         <td>&nbsp;</td>
        <td>${p.url}</td>
        <td>${p.levels}</td>
        <td>${p.status}</td>
        <td></td>
        </tr> 
       <c:forEach items="${sonAuths}" var="s">  
         <c:if test="${s.parentId==p.id}">  
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
         <td>${s.id}</td>
          <td>&nbsp;</td>
         <td>${s.name}</td>
        <td>${s.url}</td>
        <td>${s.levels}</td>
        <td>${s.status}</td>
        <td><a href="#" class="tablelink">查看</a>    
           <a href="auth?method=get&id=${s.id}" class="tablelink">修改</a></td>
        </tr> 
          </c:if> 
        </c:forEach>
        
        </c:forEach>
       
        </tbody>
    </table>
    
   
   
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
