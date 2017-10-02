function dianji(){
				//document.getElementById("uvcode").src="${ctx }/commons/image.jsp?r="+Math.random();
		document.getElementById("uvcode").src=document.getElementById("uvcode").src+'?';	
			}
function login(){
		//console.info("点击了登陆");
		var userName=document.getElementById("uName").value;
		//console.info(userName)
		var userPass=document.getElementById("uPass").value;
		//console.info(userPass)
		if(userName.length<=0){
			alert("亲！用户名不能为空哦");
			return false;
		}else if(userPass.length<=0){
			alert("亲！密码不能为空哦");
			return false;
		}else{
			return true;
		}
	}
	var a;
	var q="";
	function abd(){
		if(q==""){
			a=document.getElementById("uName").value;
			document.getElementById("uName").value="";	
		}else{
			a=document.getElementById("uName").value;
			document.getElementById("uName").value=q;
		}
	}
	function adb(p){
		if(p==""){
			document.getElementById("uName").value=a;
		}else{
			document.getElementById("uName").value=p;
			q=p;
		}
	}
	