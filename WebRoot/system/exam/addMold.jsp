<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加考试模板</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="#">添加考试模板</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
      <form action="mold?method=save" method="post" id="MyForm" >
    <ul class="forminfo">
  
      <li><label>科目</label> 
    <select class="dfinput"  name="subjectId" id="subjectId" onchange="new1()" >
       			<option value="0" >请选择</option>

       			  <c:forEach items="${subjects}" var="s">
       			  <option  value="${s.id}" >${s.name}</option>
       			</c:forEach>
       			
       			  
       			
     </select><i>选择科目后显示题库题目数量，无则不显示</i>
</li>
      <li><label>试卷名称</label>
      <input name="name" id="name" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    
   <li><label>试卷描述说明</label>
   <textarea name="descriptions" cols="" rows="" class="textinput"></textarea></li>
    
     <li><label>大题设置</label>
     <style type="text/css">
     .datalist2{width:90%;border-collapse:collapse;border:1px dotted #aaa;}
			.datalist2 td,th{text-align:center;border:1px dotted #aaa;} 
     </style>
     <table class="table table-bordered" style="" cellspacing="0" cellpadding="3">
					<thead><tr style="text-align:center;">
						<th>大题题型</th>
						
						<th>每题分数</th>
						<th>题目数</th>
						<th></th>
					</tr></thead>
                    
                    <tr>
                    <td>&nbsp;<label for="is_qestion_selected_3" >单选题
                     <input type="checkbox" name="type" id="dxt" value="1"  />
                    </label></td>
                    
                    <td><input type="text" name="score" id="question_cnt_1" class="dfinput" style="width:200px" />  </td>
                    <td><input type="text" name="num"  id="question_score_1"   class="dfinput" style="width:200px" /></td>
                    <td>此类型题目数量为  道</td>
                   </tr>
                   
                      <tr>
                    <td>&nbsp;<label for="is_qestion_selected_3" >多选题
                     <input type="checkbox" name="type" id="dxt1" value="2"  />
                    </label></td>
                   
                    <td><input type="text" name="score" id="question_cnt_2" class="dfinput" style="width:200px"/>  </td>
                    <td><input type="text" name="num"  id="question_score_2"  class="dfinput" style="width:200px"  /></td>
                   <td>此类型题目数量为  道</td>
                   </tr>
                   
                   
                      <tr>
                    <td>&nbsp;<label for="is_qestion_selected_3" >判断题
                     <input type="checkbox" name="type" id="pdt" value="3"  />
                    </label></td>
                    
                    <td><input type="text" name="score"  id="question_cnt_3" class="dfinput" style="width:200px"  />  </td>
                    <td><input type="text" name="num" id="question_score_3"   class="dfinput" style="width:200px"  /></td>
                   <td>此类型题目数量为  道</td>
                   </tr>
                   
                      <tr>
                    <td>&nbsp;<label for="is_qestion_selected_3" >填空题
                     <input type="checkbox" name="type" id="tkt" value="4"/>
                    </label></td>
                   
                    <td><input type="text" name="score" id="question_cnt_4" class="dfinput" style="width:200px" />  </td>
                    <td><input type="text" name="num" id="question_score_4" class="dfinput" style="width:200px" /></td>
                   <td>此类型题目数量为  道</td>
                   </tr>
                   
                    <tr>
                    <td>&nbsp;<label for="is_qestion_selected_3">问答题
                    <input type="checkbox" name="type" id="wdt" value="5" />
                    </label></td>
                   
                    <td><input type="text" name="score" id="question_cnt_5" class="dfinput" style="width:200px" />  </td>
                    <td><input type="text" name="num"  id="question_score_5"   class="dfinput" style="width:200px"  /></td>
                   <td>此类型题目数量为  道</td>
                   </tr>
                    </table>
     
     
     </li>
    
    
    
    <input type="hidden" value="0" id="who" name="who"/>
    <li><label>&nbsp;</label><input  type="submit"  class="btn" value="确认保存"/></li>
    <font color="red"></font>
    </ul>
  </form>
    
    </div>


</body>

</html>

