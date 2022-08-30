<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/3/4
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <script src="jquery.min.js"></script>
  <style>
    body{
      text-align: center;

    }
    .loginDiv {

      border: 1px solid red;
      height: 280px;
      width: 500px;
      background-color: rgba(255, 255, 255, 0.85);
      margin: 130px 60px 0 450px;
      border-radius: 10px;
      color: #666666;
      padding: 8px;
    }
  </style>
</head>
<body>
<div class="loginDiv">
  <p>用户注册</p>
  <!--表单开始-->
  <form action="Register" method="post">
    <!--用户名-->
    <div class="form-group">
      <label for="phone" class="col-md-3 control-label">电话：</label>
      <div class="col-md-8">
        <input name="phone" type="text" class="form-control" id="phone"  placeholder="请输入电话">
      </div>
    </div>
    <!--用户名-->
    <div class="form-group">
      <label for="name" class="col-md-3 control-label">昵称：</label>
      <div class="col-md-8">
        <input name="name" type="text" class="form-control" id="name"  placeholder="请输入昵称">
      </div>
    </div>
    <!--密码-->
    <div class="form-group">
      <label for="password" class="col-md-3 control-label"> 密码：</label>
      <div class="col-md-8">
        <input name="password" type="text" class="form-control" id="password"  placeholder="请输入密码">
      </div>
    </div>
    <div class="form-group">
      <label for="password_sure" class="col-md-3 control-label"> 确认密码：</label>
      <div class="col-md-8">
        <input name="password_sure" type="text" class="form-control" id="password_sure"  placeholder="请再次输入密码">
      </div>
    </div>

    <!--提交按钮-->
    <div class="form-group">
      <label class="col-md-3 control-label"></label>
      <div class="col-md-8">
        <input id="btn-login" class="btn btn-primary" type="submit" value="注册" />
        <span class="pull-right"><small>已有账号？</small><a href="login.jsp">返回登录</a></span>
      </div>
    </div>
  </form>
  <p style="color: red">${registerMsg}</p>
</div>
</body>





</html>
