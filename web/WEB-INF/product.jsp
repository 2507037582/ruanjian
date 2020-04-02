<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,javabean.product" %>
<html>
  <head>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <title>$Title$</title>
  </head>
  <body>
  <p style="height: 50px"></p>
  <div align="center">
    <h1>商品信息管理</h1>
  </div>
  <p style="height: 80px;"></p>
  <table class="table table-bordered table-hover">
    <tr>
      <td>序号</td>
      <td>商品名称</td>
      <td>商品种类</td>
      <td>商品单价</td>
      <td>商品数量</td>
      <td>操作</td>
    </tr>
    <tr>
      <td>1</td>
      <td>华为matebook20</td>
      <td>电脑</td>
      <td>5500元</td>
      <td>20台</td>
      <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">添加</button></td>
    </tr>

    <tr>
      <td>2</td>
      <td>小米</td>
      <td>电脑</td>
      <td>1000</td>
      <td>50</td>
      <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">添加</button></td>
    </tr>

  </table>


  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title" id="exampleModalLabel">商品添加</h4>
        </div>
        <div class="modal-body">
          <form action="index1.jsp" method="post">
            <div class="form-group">
              <label for="recipient-name" class="control-label">商品名：</label>
              <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
              <label for="message-text" class="control-label">商品种类：</label>
              <input type="text" class="form-control" name="type">
            </div>
            <div class="form-group">
              <label for="recipient-name" class="control-label">商品单价：</label>
              <input type="text" class="form-control" name="price">
            </div>
            <div class="form-group">
              <label for="message-text" class="control-label">商品数量：</label>
              <input type="text" class="form-control" name="num">
            </div>
            <div class="modal-footer">
              <input type="submit" value="提交">
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
