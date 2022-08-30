<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/3/25
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我的</title>
    <script src="jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <style>
        ul {
            float: left;
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 200px;
            background-color: #f1f1f1;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        .rt{
            float: left;
            min-height: 500px;
            overflow: auto;
        }
        .user_msg{
            border-left: 5px solid #c81623;
            background-color: #eeeeee;
            margin-left: 20px;
            width: 1200px;
            height: 80px;
        }
        .address{
            background-color: #eeeeee;
            margin-left: 20px;
            width: 1200px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <ul>
        <li><a class="active" href="index.jsp">回到首页</a></li>
        <li><a href="${pageContext.request.contextPath}/MyCart" target="_blank">我的购物车</a></li>
        <li><a href="${pageContext.request.contextPath}/MyOrderItem" target="_blank">我的订单</a></li>
        <li><a href="upload.jsp">上传头像</a></li>
        <li><a href="${pageContext.request.contextPath}/Logout" id="outLogin">退出登录</a></li>
    </ul>
    <div class="rt">
    <div class="user_msg">
            <div style="float: left;width: 80px;height: 80px" >
                <img src="images/${user.avatar}" width="100%" height="100%">
            </div>
            <div style="float: left;margin-left: 5px">
                <p style="font-weight: bold;flood-color: black">昵称：${user.username}</p>
                <p style="flood-color: #555555">账号:${user.phone}</p>
            </div>
    </div>
        <div class="address">
            <h4>我的收货地址列表</h4>
            <table>
                <tr>
                    <td>地址类型</td>
                    <td>收货人</td>
                    <td>详细地址</td>
                    <td>联系电话</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${list}"  var="addr">
                    <tr>
                        <td>${addr.tag}</td>
                        <td>${addr.name}</td>
                        <td>${addr.province_name}${addr.city_name}${addr.area_name}${addr.address}</td>
                        <td>${addr.phone}</td>
                        <td><a href="${pageContext.request.contextPath}/DeleteAddr?aid=${addr.aid}"><button name="delete" >删除</button></a></td>
                    </tr>
                </c:forEach>

            </table>
            <a href="add_address.jsp"><button id="add_address" style="background-color: cyan;flood-color: white">+新增</button></a>
        </div>
    </div>
</body>

</html>
