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
      <a  href="./index">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./bookindex">订书<span class="sr-only">(current)</span></a></li>
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
        <button type="submit" class="btn btn-default">Submit</button>
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
	<table class="table table-bordered table-striped table-hover table-condensed">
  		<tr align="center">
  			<td>序号</td>
			<td>课程名称</td>
			<td>课程属性</td>
			<td>专业</td>
			<td>年级</td>
			<td>任课教师</td>
			<td>教材名称</td>
			<td>作者</td>
			<td>版次</td>
			<td>出版社</td>
			<td>操作</td>
  		</tr>
  		<c:forEach items="${bookList}" var="book" varStatus="num">
			<tr align="center">
				<td>${num.index+1}</td>
				<td><c:out value="${book.course_name}"/></td>
				<td><c:out value="${book.course_type}"/></td>
				<td><c:out value="${book.major}"/></td>
				<td><c:out value="${book.grade}"/></td>
				<td><c:out value="${book.teacher}"/></td>
				<td><c:out value="${book.book_name}"/></td>
				<td><c:out value="${book.author}"/></td>
				<td><c:out value="${book.times}"/></td>
				<td><c:out value="${book.publish}"/></td>
				<td>
				<a href="${pageContext.request.contextPath}/cost?id=${book.id}">购买</a>
				<c:if test="${sessionScope.username=='17425036'}">
				<a href="${pageContext.request.contextPath}/bookdelete?id=${book.id}">删除</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${sessionScope.username=='17425036'}">
<form class="form-inline" action="${pageContext.request.contextPath}/book" method="post">
  <div class="form-group">
    <label for="exampleInputName2">课程名称</label>
    <input type="text" class="form-control" id="course_name" name="course_name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">课程属性</label>
    <input type="text" class="form-control" id="course_type" name="course_type">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">专业</label>
    <input type="text" class="form-control" id="major" name="major">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">年级</label>
    <input type="text" class="form-control" id="grade" name="grade">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">任课教师</label>
    <input type="text" class="form-control" id="teacher" name="teacher">
  </div>
  <p></p>
  <div class="form-group">
    <label for="exampleInputEmail2">教材名称</label>
    <input type="text" class="form-control" id="book_name" name="book_name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">作者</label>
    <input type="text" class="form-control" id="author" name="author">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">版次</label>
    <input type="text" class="form-control" id="times" name="times">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">出版社</label>
    <input type="text" class="form-control" id="publish" name="publish">
  </div>
  <button type="submit" class="btn btn-default">提交</button>
</form>
</c:if>
</body>
</html>