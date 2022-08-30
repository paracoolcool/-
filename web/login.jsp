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
  <p>用户登录</p>
  <!--表单开始-->
  <form  action="Login"   method="post">
    <!--用户名-->
    <div class="form-group">
      <label for="username" class="col-md-3 control-label">账号：</label>
      <div class="col-md-8">
        <input name="username" type="text" class="form-control" id="username"  placeholder="请输入用户名">
      </div>
    </div>
    <!--密码-->
    <div class="form-group">
      <label for="password" class="col-md-3 control-label"> 密码：</label>
      <div class="col-md-8">
        <input name="password" type="password" class="form-control" id="password"  placeholder="请输入密码">
      </div>
    </div>
    <!-- 记住我-->
    <div class="form-group">
      <div class="col-md-offset-3 col-md-6">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="auto">自动登录
          </label>
        </div>
      </div>
    </div>
    <!--提交按钮-->
    <div class="form-group">
      <label class="col-md-3 control-label"></label>
      <div class="col-md-8">
        <input id="btn-login" class="btn btn-primary" type="submit" value="登录" />
        <span class="pull-right"><small>还没有账号？</small><a href="register.jsp">注册</a></span>
      </div>
    </div>
  </form>
</div>

</body>

</html>
