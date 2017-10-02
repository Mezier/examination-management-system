<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <p><a href="auth?method=add">添加权限</a> </p>
    
    <form action="auth?method=update" method="post">
    <p>输入你要修改权限的id<input type="text" name="id" > </a> </p>
    <p><input type="submit" value="修改权限"> </a> </p>
    </form>
    
    <p><a href="auth?method=list">查看所有权限</a></p>
    <p><a href="addRole.jsp">添加角色</a></p>
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
