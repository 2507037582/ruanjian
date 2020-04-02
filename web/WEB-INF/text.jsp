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
      <a href="./index">首页</a>
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
      <li class="active"><a href="./textindex">文件下载</a></li>
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
      <td>文件名</td>
      <td>操作</td>
      </tr>
      <c:forEach items="${textList}" var="text" varStatus="num">
			<tr align="center">
				<td>${num.index+1}</td>
				<td><c:out value="${text.filename}"/></td>
				<td>
				<a href="${pageContext.request.contextPath}/textdownload?filename=${text.filename}">下载</a>
				<c:if test="${sessionScope.username=='17425036'}">
				<a href="${pageContext.request.contextPath}/textdelete?id=${text.id}">删除</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
  </table>
<c:if test="${sessionScope.username=='17425036'}">
<p style="height: 100px"></p>
<div align="center">
 <form action="${pageContext.request.contextPath }/textsubmit" enctype="multipart/form-data" method="post">
         <div class="form-group">
         <label for="exampleInputFile" ><font size="5">文件上传</font></label>
         <p></p>
          <input type="file" name="filename"></input> 
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
    </form>
    </div>
    </c:if>
</body>
</html>