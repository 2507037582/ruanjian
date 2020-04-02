<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2_min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
<style>
	.error{
		color: red;
	}
</style>
<script type="text/javascript">
//自定义校验规则
$.validator.addMethod(
	//校验名称
	"checkusername",
	//校验规则
	function(value,element,params){
		//定义一个标志
		var flag=true;
		$.ajax({
			"async":false,
			"url":"${pageContext.request.contextPath}/checkregister",
			"data":{"username":value},
			"type":"POST",
			"dataType":"json",
			"success":function(data){
				flag=data.isExist;
			}
		});
		//返回false代表该校验器不通过
		return !flag;
	}
)
$.validator.addMethod(
	//校验名称
	"checkname",
	//校验规则
	function(value,element,params){
		//定义一个标志
		var flag=true;
		$.ajax({
			"async":false,
			"url":"${pageContext.request.contextPath}/checkname",
			"data":{"name":value},
			"type":"POST",
			"dataType":"json",
			"success":function(data){
				flag=data.isExist;
			}
		});
		//返回false代表该校验器不通过
		return !flag;
	}
)
	$(function(){
		$("#myform").validate({
			rules:{
				"username":{
					"required":true,
					"number":true,
					"rangelength":[7,10],
					"checkusername":true,
					
				},
				"name":{
					"required":true,
					"checkname":true,
				},
				"password":{
					"required":true,
					"rangelength":[5,10]
				},
				"email":{
					"required":true,
					"email":true,

				}
			},
			messages:{
				"username":{
					"required":"<font size=\"3\"><b>用户名不能为空</b></font>",
					"number":"必须输入合法的数字",
					"rangelength":"密码长度必须为7-10位",
					"checkusername":"用户名已存在",
				},
				"name":{
					"required":"<font size=\"3\"><b>姓名不能为空</b></font>",
					"checkname":"姓名已经存在",
				},
				"password":{
					"required":"<font size=\"3\"><b>密码不能为空</b></font>",
					"rangelength":"密码长度必须为5-10位"
				},
				"email":{
					"required":"<font size=\"3\"><b>邮箱不能为空</b></font>",
					"email":"请输入正确格式的电子邮件"
				}
			}
		})
	});
</script>
</head>

<body>


<div class="header" style="left:230px">
  <h1><font size="9" style="color:CornflowerBlue">软件工程专用网站</font></h1>
	
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   <form class="registerform" action="/ruanjian/login" method="post">
   <div class="fm-item">
	   <label for="logonId" class="form-label">用户名：</label>
	   <input type="text"  id="username" class="i-text" name="username"/>
       <label class="error" style="display: none;" for="username" generated="true"></label>
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">姓名：</label>
	   <input type="text"  id="name" class="i-text" name="name"/>
	   <label class="error" for="name" style="display: none;" generated="true"></label>
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">密码：</label>
	   <input type="password" value="" maxlength="100" id="password" class="i-text" name="password"/>  
	   <label class="error" for="password" style="display: none;" generated="true"></label>  
       <div class="ui-form-explain"></div>
  </div>
  <label for="logonId" class="form-label"><a id="demo_button" data-toggle="modal" data-target="#demoModal">没有账号，去注册---></a></label>
  <div class="fm-item">
	   
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"/>
       <div class="ui-form-explain"></div>
  </div>
  </form>
  </div>
  <div class="modal fade" id="demoModal" tabindex="-1" role="dialog" aria-labelledby="demoModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel">注册</h4>
					</div>
					<div class="modal-body">
						<form id="myform" class="form-group" action="${pageContext.request.contextPath }/register" method="post">
							<div class="form-group">
								<label for="">用户名</label>
								<input class="form-control" id="username" name="username" type="text" placeholder="用户名必须为7-10位有效数字"/>
							</div>
							<div class="form-group">
								<label for="">姓名</label>
								<input class="form-control" id="name" name="name" type="text"/>
							</div>
							<div class="form-group">
								<label for="">密码</label>
								<input class="form-control i-text" id="password" name="password" type="password" placeholder="5-10位字母或数字"/>
							</div>
							<div class="form-group">
								<label for="">邮箱</label>
								<input class="form-control i-text" id="email" name="email" type="email" placeholder=""/>
							</div>
							<a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
							<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">确定</button>
					</div>
				</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
</div>
	<div class="bd">
		<ul>
			<li style="background:url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank"></a></li>
			<li style="background:url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank"></a></li>
		</ul>
	</div>
	<div class="hd"><ul></ul></div>
</div>

<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>



</body>
</html>
