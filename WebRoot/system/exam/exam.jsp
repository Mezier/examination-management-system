<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>E​-​L​e​a​r​n​i​n​g​在​线​学​习​系​统​ 思诚科技</title>
<link rel="stylesheet" type="text/css" href="../css/style2.css">
<link rel="stylesheet" type="text/css" href="../css/ext.css">	
<link href="../css/idialog.css" rel="stylesheet">
<link href="../css/tabview0.css" rel="stylesheet" type="text/css" media="screen">
<link href="../css/evabootstrap-full.css" rel="stylesheet" type="text/css">
<link href="../css/navbar-blue.css" rel="stylesheet" type="text/css"> 
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css">


<style>
#scrollUp {
	bottom: 20px;
	right: 20px;
	height: 38px;
	width: 38px;
	background: url("images/top.png")
		no-repeat;
}

.breadcrumb li {
	display: inline;
}

.typocn button {
	line-height: 1.4;
}

.table thead th {
	background-color: #F5F5F5;
	text-align: center;
}

.navbar .brand {
	padding: 6px 20px;
}
.form select,.form textarea,.form input[type="text"],.form input[type="password"],.form input[type="submit"]{
	margin-bottom:0;
}
</style>
<script type="text/javascript">
	var logout_uri = "/lms/?c=Index&m=logout&tc=lms3";
	var lang_ExitConfirm = "您确定要退出本平台吗?";
</script>




</head>

<body class="typocn yui-skin-sam">


	<div class="clearfix"></div>
	<div style="top:15px; margin-top:15px;"></div>	
    
   
	<div class="clearfix"></div>
	<form action="exam?method=subm"  method="post" >
	<div class="container">

		
			
					<div class="inline">
						<div class="page-header intitle3">
							<strong>${mold.name}</strong>
						</div>
						<div class="intitle2">
							<span>考生: 学员</span> <span>考试编号: ${mold.id}</span>
							<span>题目总数: 13</span> <span>考试总分：${mold.score}</span>
							<span>通过分数: ${mold.score*0.6}</span> <br /> <span>
        		创建时间:</span>
						</div>

        <div class="clearfix"></div>
	         <c:if test="${not empty question1}">
                <div class="dati" id="mq_1">
							<div class="MQ" id="content_1">
								<div class="alert alert-info mqtitle">
									<div>单选题，每题仅有一个正确的选项。（本题型共有3题，共3分）</div>
								</div>
								
								<!-- 单选题目 -->
								<c:forEach items="${question1}" var="q" varStatus="status">
					<ul class="datilist">
                     <li id="qstnIdx_1" >     
			             	<div class="lixuanzhe">
							<div class="f_lzx">
							<div style="position: relative; left: -10px;">${status.count}:&nbsp;${q.question.title}<div class="pull-right">
							
							</div>
							</div>
							<div class="clearfix"></div>
							<ol >
						<c:forEach items="${q.options}" var="op" varStatus="status">
		                  <li style="list-style-type: upper-alpha; position: relative; left: 15px;">
							<input type="radio" name="${op.questionId}" value="${status.count}"/> &nbsp;${op.content}
												
						</li>
                 		</c:forEach>	
                 		</ol>	                                        
                 								  <div id="ExamStdAnswer_bdd935c1c81c018362234a2fe7a046d6"
													style="display: block;"></div>
				                  </div>
										</div>
				</li>
	            </ul>
	            </c:forEach>
								<div class="clearfix"></div>

							</div>

						</div>
						</c:if>
						<!-- 多选标题 -->
						<c:if test="${not empty question2}">
                <div class="dati" id="mq_2">
							<div class="MQ" id="content_2">
								<div class="alert alert-info mqtitle">
									<div>多选题，每题至少有一个正确答案，多选，错选，少选不给分。（本题型共有3题，共3分）</div>
								</div>
				    <c:forEach items="${question2}" var="q" varStatus="status">
					<ul class="datilist">
                     <li id="qstnIdx_2">     
			             	<div class="lixuanzhe">
							<div class="f_lzx">
							<div  style="position: relative; left: -10px;">${status.count}:&nbsp;${q.question.title}<div class="pull-right">
							
							</div>
							</div>
							<div class="clearfix"></div>
							<ol >
						<c:forEach items="${q.options}" var="op" varStatus="status">
		                  <li style="list-style-type: upper-alpha; position: relative; left: 15px;">
								<label class="radio"><input type="checkbox" name="${op.questionId}" value="${status.count}"/> &nbsp;${op.content}	</label>
												
						</li>
                 		</c:forEach>	
                 		</ol>	                                        
                 								  <div id="ExamStdAnswer_c516568b0c774ce8187f93c969197f92"
													style="display: block;"></div>
				                  </div>
										</div>
				</li>
	            </ul>
	            </c:forEach>
								<div class="clearfix"></div>

							</div>

						</div>
						</c:if>
						<!-- 判断题 -->
						<c:if test="${not empty question3}">
                <div class="dati" id="mq_3">
							<div class="MQ" id="content_3">
								<div class="alert alert-info mqtitle">
									<div>判断题（本题型共有3题，共3分）</div>
								</div>
								
								
				<c:forEach items="${question3}" var="q" varStatus="status">
					<ul class="datilist">
                     <li id="qstnIdx_3" >     
			             	<div class="lixuanzhe">
							<div class="f_lzx">
							<div >${status.count}:&nbsp;${q.title}<div class="pull-right">
							<label class="checkbox"> </label>
							</div>
							</div>
							<div class="clearfix"></div>
							
						
		                 
								<label class="radio"><input type="radio" name="${q.id}" value="T"/> &nbsp;对	
								<input type="radio" name="${q.id}" value="F"/> &nbsp;错
								</label>
												
						
                 			
                 		                                        
                 								  <div id="ExamStdAnswer_e4898c64d8bfc821b34a464035e0e522"
													style="display: block;"></div>
				                  </div>
										</div>
				</li>
	            </ul>
	            </c:forEach>
								<div class="clearfix"></div>

							</div>

						</div>
						</c:if>
						<!-- 填空题 -->
						<c:if test="${not empty question4}">
                <div class="dati" id="mq_4">
							<div class="MQ" id="content_4">
								<div class="alert alert-info mqtitle">
									<div>填空题，在空白处填写答案。（本题型共有3题，共3分）</div>
								</div>
								
								<c:forEach items="${question4}" var="q" varStatus="status">
								<ul class="datilist">
                          <li id="qstnIdx_10"><a
										name="qstnIdx_10"></a>
										<div class="lixuanzhe">
											<div class="f_lzx">
												<div>${status.count}:&nbsp;${q.title} 
											 <div class="pull-right">
														
													</div>
												</div>
												<div class="clearfix"></div>
                                        
                    <!-- 综合题 -->
                    												<!-- 非综合题 -->
                                        		<input type="text" name="${q.id}"  /><br/>
                                        		
				                  </div>
										</div></li>
	              
	              
	            </ul>
	            </c:forEach>
								<div class="clearfix"></div>

							</div>

						</div>
						</c:if>
						<c:if test="${not empty question5}">
                <div class="dati" id="mq_6">
							<div class="MQ" id="content_6">
								<div class="alert alert-info mqtitle">
									<div>问答题（本题型共有1题，共1分）</div>
								</div>
								
								<c:forEach items="${question5}" var="q" varStatus="status">
								<ul class="datilist">
                          <li id="qstnIdx_13"><a
										name="qstnIdx_13"></a>
										<div class="lixuanzhe">
											<div class="f_lzx">
												<div><a name="qstn_idx_13"></a>${status.count}:&nbsp;${q.title} 
												 <div class="pull-right">
														
													</div>
												</div>
												<div class="clearfix"></div>
                                        
                    <!-- 综合题 -->
                    												<!-- 非综合题 -->
                   <textarea name="${q.id}" cols="90" rows="12" style="width:80%;height:100px;margin-bottom:10px" ></textarea>
                                        											
				                  </div>
										</div></li>
	            </ul>
	            </c:forEach>
								<div class="clearfix"></div>

							</div>

						</div>
               
      </c:if>
						<div class="hidden" id="con_xz_2"></div>
						<div class="hidden" id="con_xz_3"></div>
						<div style="clear: both;"></div>
						<div style="text-align: center; margin-top: 1px;">
							<div class="pull-right">
<div style="float: right; padding-right: 10px">
									<input type="submit" value="提交答卷" class="btn btn-primary btn-large"
										id="sub">
										</input>
								</div>						</div>
						</div>
						
					</div>
				</div>
			
		</form>
	
    
    
<div class="clearfix"></div>
<!--footer start-->
<footer class="footer">
	<div class="container" style="text-align: center;">
		<ul class="footer-links">
			<li><a href="lms/?c=Home.Home" class="dd2">门户首页</a></li>
		
				<li><a href="http://www.seecen.com/" class="dd2">公司主页</a></li> 
			
			<li><a href="mailto:admin@seecen.com" class="dd2">联系我们</a></li> 
			
		</ul>

		<ul class="footer-links">
					 <li>
		技术支持:E​-​L​e​a​r​n​i​n​g技术团队</li>
			<li>邮箱:admin@seecen.com</li>
			<li>	电话:186777888999</li>
			 		</ul>

		<p>©2014 在线学习平台All
		Rights Reserved 版权所有 赣ICP备11009999号		</p>
	</div>
	<div class="clearfix"></div>

</footer>

</body></html>
