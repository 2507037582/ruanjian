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
  <script type="text/javascript">
    $('#myModal').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
   
  </script>
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
        <li class="active"><a href="./allscore">全部成绩</a></li>
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
      <tr align="\center">
      <td>姓名</td>
      <td>大学物理C</td>
      <td>计算机组成原理</td>
      <td>物理实验C</td>
      <td>形势与政策(4)</td>
      <td>面向对象程序设计</td>
      <td>马克思主义基本原理</td>
      <td>软件工程概论</td>
      <td>小型软件项目综合课程设计</td>
      <td>体育IV</td>
      <td>计算机组成原理实验</td>
      <td>面向对象程序设计上机实验</td>
      <td>大学英语IV</td>
      <td>绩点</td>
      </tr>
      <c:forEach items="${allscore4List}" var="allscore4" varStatus="num">
			<tr align="center">
				<td><c:out value="${allscore4.name}"/></td>
				<td><c:out value="${allscore4.a}"/></td>
				<td><c:out value="${allscore4.b}"/></td>
				<td><c:out value="${allscore4.c}"/></td>
				<td><c:out value="${allscore4.d}"/></td>
				<td><c:out value="${allscore4.e}"/></td>
				<td><c:out value="${allscore4.f}"/></td>
				<td><c:out value="${allscore4.g}"/></td>
				<td><c:out value="${allscore4.h}"/></td>
				<td><c:out value="${allscore4.i}"/></td>
				<td><c:out value="${allscore4.j}"/></td>
				<td><c:out value="${allscore4.k}"/></td>
				<td><c:out value="${allscore4.l}"/></td>
				<td><c:out value="${allscore4.grade}"/></td>
			</tr>
		</c:forEach>
  </table>
</body>
</html>