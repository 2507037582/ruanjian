<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8"/>
	<title>软件172</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header navbar-brand active">
      <a class="active" href="./index">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="./bookindex">订书<span class="sr-only">(current)</span></a></li>
        <li><a href="./allscore">全部成绩</a></li>
        <li class="dropdown">
          <a href="./score" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">成绩录入<span class="caret"></span></a>
          <ul class="dropdown-menu">
             <li><a href="score1.html">大一上</a></li>
            <li><a href="score2.html">大一下</a></li>
            <li><a href="score3.html">大二上</a></li>
            <li><a href="./score4index">大二下</a></li>
            <li><a href="score5.html">大三上</a></li>
            <li><a href="score6.html">大三下</a></li>
            <li><a href="score7.html">大四上</a></li>
            <li><a href="score8.html">大四下</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="./textindex">文件下载</a></li>
       <li><a href="./passwordindex">修改密码</a></li>
      <li><a href="./costindex">订单</a></li>
        <li><a href="./login">退出登录</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><font  size="4">最新通知</font></label>

<table class="table table-bordered table-striped table-hover table-condensed">
  		<tr align="center">
  			<td>时间</td>
			<td>标题</td>
			<td>内容</td>
  		</tr>
  		<c:forEach items="${firstList}" var="first" varStatus="num">
			<tr align="center">
				<td><c:out value="${first.time}"/></td>
				<td><c:out value="${first.title}"/></td>
				<td><c:out value="${first.content}"/></td>
			</tr>
		</c:forEach>
	</table>

<p style="height: 20px"></p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><font  size="4">历史通知</font></label>
<table class="table table-bordered table-striped table-hover table-condensed">
  		<tr align="center">
  			<td>序号</td>
  			<td>时间</td>
			<td>标题</td>
			<td>内容</td>
			<td>操作</td>
  		</tr>
  		<c:forEach items="${emailList}" var="email" varStatus="num">
			<tr align="center">
				<td>${num.index+1}</td>
				<td><c:out value="${email.time}"/></td>
				<td><c:out value="${email.title}"/></td>
				<td><c:out value="${email.content}"/></td>
				<td>
				<c:if test="${sessionScope.username=='17425036'}">
				<a href="${pageContext.request.contextPath}/sendemail?id=${email.id}">发送通知</a>
				<a href="${pageContext.request.contextPath}/emaildelete?id=${email.id}">删除</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
<p style="height: 50px"></p>
<c:if test="${sessionScope.username=='17425036'}">
<form action="${pageContext.request.contextPath}/emailsubmit" method="post">
  <div class="form-group">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="title"><font  size="4">邮箱标题</font></label>
    <input type="text" class="form-control" id="title" name="title">
  </div>
  <div class="form-group">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="exampleInputPassword1"><font  size="4">邮箱内容</font></label>
    <input type="text" class="form-control" id="content" name="content">
  </div>
  <div align="center">
  <button type="submit" class="btn btn-default">提交</button>
  </div>
</form>
</c:if>
</body>
</html>