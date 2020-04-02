<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>软件172</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
<script type="text/javascript">
    $('#myModal').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
   
  </script>
<style type="text/css">
.box{
	width: 20px;
	height: 20px;
	padding: 2px;
	border:1px solid #ccc;
	border-radius: 2px;
}
</style>

</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-12" style="padding:2em 0;">
			<div class="table-responsive">
			<div>
			<font size="4" color="blue"><b>修改密码：</b></font>
			<p></p>
			</div>
				<table class="table table-bordered table-striped">
					  <tr>
						<td>学号</td>
						<td>姓名</td>
						<td>密码</td>
						<td>操作</td>
					  </tr>
					<c:forEach items="${passwordList}" var="password">
						<tr align="center">
							<td><c:out value="${password.username}"/></td>
							<td><c:out value="${password.name}"/></td>
							<td><c:out value="${password.password}"/></td>
							<td>
							<a id="demo_button" data-toggle="modal" data-target="#demoModal">修改</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div>
			<font size="4" color="blue"><b>修改邮箱：</b></font>
			<p></p>
			</div>
				<table class="table table-bordered table-striped">
					  <tr>
						<td>学号</td>
						<td>姓名</td>
						<td>邮箱</td>
						<td>操作</td>
					  </tr>
					<c:forEach items="${emailList}" var="email">
						<tr align="center">
							<td><c:out value="${email.username}"/></td>
							<td><c:out value="${email.name}"/></td>
							<td><c:out value="${email.email}"/></td>
							<td>
							<a id="demo_button" data-toggle="modal" data-target="#demoModa2">修改</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				 <div class="modal fade" id="demoModal" tabindex="-1" role="dialog" aria-labelledby="demoModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 800px;">
            <div class="modal-content">
                <div class="modal-header">
                   <form class="form-inline" action="${pageContext.request.contextPath}/passwordupdate" method="post">
                        <div class="form-group">
                          <label for="exampleInputName2">密码</label>
                          <input type="text" class="form-control" id="exampleInputName2" name="password">
                          <button type="submit" class="btn btn-success">提交</button>
                        </div>
                    </form>
                    <p></p>
                    
                </div>
                
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <div class="modal fade" id="demoModa2" tabindex="-1" role="dialog" aria-labelledby="demoModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 800px;">
            <div class="modal-content">
                <div class="modal-header">
                   <form class="form-inline" action="${pageContext.request.contextPath}/emailupdate" method="post">
                        <div class="form-group">
                          <label for="exampleInputName2">邮箱</label>
                          <input type="email" class="form-control" id="email" name="email">
                          <button type="submit" class="btn btn-success">提交</button>
                        </div>
                    </form>
                    <p></p>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
			</div>
		</div>
	</div>
</div>
<a href="./index"><button type="button" class="btn btn-success" style="margin-left: 1185px">返回首页</button></a>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstable.js"></script>
<script type="text/javascript">
	$('#mytable').SetEditable({
		$addButton: $('#add')
	});
</script>
</body>
</html>