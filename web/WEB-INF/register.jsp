<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>CSS3登录注册切换动画模板 - 站长素材</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
<style>
.error{
	color: red;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#myform").validate({
			rules:{
				"username":{
					"required":true,
				}
			},
			messages:{
				"username":{
					"required":"11",
				},
			}
		})
	});
</script>
</head>
<body>

<div class="materialContainer">
	<div class="box">
		<div class="title">登录</div>
		<div class="input">
			<label for="name">用户名</label>
			<input type="text" name="name" id="name">
			<label class="error" for="username" generated="true">55</label>
			<span class="spin"></span>
		</div>
		<div class="input">
			<label for="pass">密码</label>
			<input type="password" name="pass" id="pass">
			<span class="spin"></span>
		</div>
		<div class="button login">
			<button>
				<span>登录</span>
				<i class="fa fa-check"></i>
			</button>
		</div>
		<a href="javascript:" class="pass-forgot">忘记密码？</a>
	</div>
<form id="myform" action="${pageContext.request.contextPath}/register" method="post">
	<div class="overbox">
		<div class="material-button alt-2">
			<span class="shape"></span>
		</div>
		<div class="title">注册</div>
		<div class="input">
			<label for="regname">用户名</label>
			<input type="text" name="username" id="regname">
			<span class="spin"></span>
		</div>
		<div class="input">
			<label for="regpass">姓名</label>
			<input type="text" name="name" id="regpass">
			<span class="spin"></span>
		</div>
		<div class="input">
			<label for="reregpass">密码</label>
			<input type="password" name="password" id="reregpass">
			<span class="spin"></span>
		</div>
		<div class="button">
			<button type="submit">
				<span>注册</span>
			</button>
		</div>
	</div>
</form>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>

</body>
</html>