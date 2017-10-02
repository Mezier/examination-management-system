<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模板列表</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../js/jquery.js"></script>

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
    <li><a href="index.jsp">首页</a></li>
    <li><a href="#">考试模板管理</a></li>
    <li><a href="#">模板列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">

    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
    	 
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
     
          <th>模板名称</th>
         <th>所属科目</th>
         <th>总分</th>
         <th>描述</th>
         <th>创建时间</th>
          <th>状态</th>
		  <th>操作</th>
       </tr>
        
        </thead>
        <tbody>
        
        <c:forEach items="${testMolds}" var="t">
        <tr>
	        <td><input name="" type="checkbox" value="" /></td>
	       
	        <td>${t.id}</td>
	         <td>${t.name}</td>
	     	<td>${t.subjectId}</td>
	         <td>${t.score}</td>
	         <td>${t.descriptions}</td>
	         <td>${t.createTime}</td>
	     	<td>${t.status}</td>
	     	
	        
	        <td><a href="exam?method=join&id=${t.id}" class="tablelink">参加考试</a>     
	        
	        
	        </td>
        </tr> 
        </c:forEach>
           
       
        
        
        
       
        
        
        </tbody>
    </table>
    
   
      <div class="pagin">
    	<div class="message">共<i class="blue">${page.totalRecord}</i>条记录，当前显示第&nbsp;<i class="blue">${page.currPage}&nbsp;</i>页 共<i class="blue">${page.totalPage}</i>页</div>
        <ul class="paginList">
      
    	 <li class="paginItem"><a href="question?method=list" >首页</a></li>
     
         
     <c:if test="${page.currPage>1}">
      <li class="paginItem "><a href="question?method=list&currPage=${page.currPage-1}" >上一页</a></li>
      </c:if>
      <c:if test="${page.currPage<page.totalPage}">
	    <li class="paginItem "><a href="question?method=list&currPage=${page.currPage+1}" >下一页</a></li>  
	 </c:if>
    <li class="paginItem "><a href="question?method=list&currPage=${page.totalPage}" >尾页</a></li>
       
        
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="../images/ticon.png" /></span>
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

