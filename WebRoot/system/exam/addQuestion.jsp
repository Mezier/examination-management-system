<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javaScript" src="../js/jquery-1.4.2.js"></script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
   
   function showOption(){
    $("#option1 input").attr({'checked':''});
    $("#option2 input").attr({'checked':''});
     $("#option3 input").attr({'checked':''});
      $("textarea").text("");
    var ids=document.getElementById("options").value; 
	 var id=parseInt(ids);
      
	 for(var i=1;i<6;i++){
	    if(i==id){
		  document.getElementById("option"+i).style.display="block";
		}else{
		   document.getElementById("option"+i).style.display="none";
		}
	 }
  
   }




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
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="question?method=save" method="post">
    <ul class="forminfo">
      <li><label>科目</label>
       <select class="dfinput" name="subjectId">
       <option value="0">未选择</option>
       <c:forEach items="${subjects}" var="sub">
	<option value="${sub.id}">${sub.name}</option>
    </c:forEach>
</select>
</li>

   


    <li><label>题目</label><textarea id="questionName" style="width:600px;height:200px" wrap="virtual" class="dfinput" name="questionName"></textarea><i>标题不能超过30个字符</i></li>
    
     <li><label>类型</label>
     <select id="options" class="dfinput" name="qtype" onchange="showOption()">
	<option value="0">请选择</option>
	<option value="1">单选</option>
	<option value="2">多选</option>
	<option value="3">判断题 </option>
	<option value="4">填空 </option>        
	<option value="5">简答题</option>
</select></li>
    
    <li>
    
     <table class="table" width="100%" id="option1" style="display:none"><thead><tr style="text-align: center;"><th></th>
					<th>正确</th><th width="85%">答案/选项</th></tr></thead><tbody>
                    <tr>
                    <td  style="text-align: center;">A</td>
                    <td  style="text-align: center;"><input name="answer" value="A" type="radio" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">B</td>
                    <td  style="text-align: center;"><input name="answer" value="B" type="radio" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">C</td>
                    <td  style="text-align: center;"><input name="answer" value="C" type="radio" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">D</td>
                    <td  style="text-align: center;"><input name="answer" value="D" type="radio" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    
                    </tbody></table>
                    
                    
                    
                    <table class="table" width="100%" id="option2" style="display:none"><thead><tr style="text-align: center;"><th></th>
					<th>正确</th><th width="85%">答案/选项</th></tr></thead><tbody>
                    <tr>
                    <td  style="text-align: center;">A</td>
                    <td  style="text-align: center;"><input name="answer" value="A" type="checkbox" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">B</td>
                    <td  style="text-align: center;"><input name="answer" value="B" type="checkbox" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">C</td>
                    <td  style="text-align: center;"><input name="answer" value="C" type="checkbox" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">D</td>
                    <td  style="text-align: center;"><input name="answer" value="D" type="checkbox" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    <tr>
                    <td  style="text-align: center;">E</td>
                    <td  style="text-align: center;"><input name="answer" value="E" type="checkbox" id="qf_03fef6"  /></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="content"></textarea></td>
                    </tr>
                    
                    </tbody></table>
                    
                    
           <table class="table" width="100%" id="option3" style="display:none"><thead><tr style="text-align: center;"><th></th>
					<th></th><th width="85%"></th></tr></thead><tbody>
                    
                    <tr>
                   
                     <td  style="text-align: center; position: relative; left: 80px;">对<input name="answer" value="T" type="radio" id="qf_03fef6"  />
                      &nbsp; 错<input name="answer" value="F" type="radio" id="qf_03fef6" /></td>
                    </tr>
                    </tbody></table>
           <table class="table" width="100%" id="option4" style="display:none"><thead><tr style="text-align: center;"><th></th>
					<th>正确</th></tr></thead><tbody>
                    <tr>
                    <td  style="text-align: center;"></td>
                    <td  style="text-align: center;"></td>
                    <td  style="text-align: center;"><textarea class="dfinput" style="width:600px" id="answer1" name="answerFill"></textarea></td>
                    </tr>
                    
                   </tbody></table> 
    </li>
 
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
