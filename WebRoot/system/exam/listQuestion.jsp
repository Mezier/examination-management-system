<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>问题列表</title>
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
<style type="text/css">
.input{width:200px;height:30px;color:red}
p{text-align:center;}
</style>

</head>


<body>
  <form action="question?method=list" method="post"  id="myForm">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="#">题库管理</a></li>
    <li><a href="#">问题列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png" 
onclick="javascript:window.location='addQuestion.jsp'"/></span>添加</li>
        <li class="click"><span><img src="../images/t02.png" /></span>修改</li>
        <li><span><img src="../images/t03.png" /></span>删除</li>
        <li><span><img src="../images/t04.png" /></span>统计</li>
        <font color="red"></font>
        <li>题目类型 1为单选择题，2为多选题，3为判断题，4为填空题   5.问答题</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="../images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
  
    <p>
    科目编号<input type="text" name="subjectId" class="input" value=""/>
    题目类型<input type="text" name="qtype" class="input" value=""/>
    题目内容<input type="text" name="content" class="input" value=""/>
    <input type="submit" value="搜索" class="input"/></p>
    <table class="tablelist">
    	<thead>
    	<tr>
    	 
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
         <th>科目编号</th>
          <th>题目类型</th>
         <th>题目内容</th>
         <th>答案</th>
         <th>状态</th>
		  <th>操作</th>
       </tr>
        
        </thead>
        <tbody>
        
        <c:forEach items="${questions}" var="q">
        <tr>
	        <td><input name="" type="checkbox" value="" /></td>
	       
	        <td>${q.id}</td>
	     	<td>${q.subjectId}</td>
	     	<td>${q.type}</td>
	     	<td>${q.title}</td>
	     	
	     	<td>${q.answer}</td>
	        <td>${q.status}</td>
	        <td><a href="question?method=update&id=${q.id}" class="tablelink">修改</a>     
	        <a href="question?method=del&id=${q.id}" class="tablelink">删除</a>
	        
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
    
    <input type="hidden" name="page" id="currentPage" value="1"/>
   	<input type="hidden" name="max" id="max" value="9"/>

    
    </div>
    
    </form>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
