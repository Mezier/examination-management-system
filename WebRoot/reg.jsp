<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<style>
.file {
	position: absolute;
	top: 0;
	right: 80px;
	height: 24px;
	filter: alpha(opacity :0);
	opacity: 0;
	width: 260px
}
</style>
		<title>学员注册界面</title>
		<script type="text/javascript" src="js/login.js"></script>
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
		<div class="div3">
			<div style="width: 978px; height: 67px;">
				<div class="div4"
					style="background-image: url(images/dl_03.jpg);">
				</div>
			
			<div class="div5" style="background-image: url(images/dl_07.jpg);"></div>
			<div class="divs">
			<form action="reg" method="post"
				enctype="multipart/form-data">

				<p>用户名：<input name="userName" class="input" /></p>
				<p>密&nbsp;&nbsp;码：<input type="password" name="pass" class="input"/></p>
				<!-- <p>确认密码：<input type="password" name="pass" class="input" /></p> -->
				<p>年&nbsp;&nbsp;龄：<input name="age" class="input" /></p>
				<p>性&nbsp;&nbsp;别：<select name="sex">
					                  <option value="男">男</option>
					                  <option value="女">女</option>
				                  </select></p>
				<p>班&nbsp;&nbsp;级：<input type="text" name="classes" class="input">
					                 
				                  </p>
				<p>电&nbsp;&nbsp;话：<input name="tel" class="input" /></p>
				<p>地&nbsp;&nbsp;址：<input name="address" class="input" /></p>
				<p>上传图像：<input type="file" name="photo" /></p>
				<p><input type="submit" 
					value="注册" /></p>
			</form>
		</div>
		</div>
		</div>
	</body>
</html>

