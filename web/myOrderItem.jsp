<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/5/20
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>我的订单</title>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }
        table{
            border: 1px solid black;
        }
        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
        td{
            text-align: center;
        }
    </style>
</head>
<body>



<div class="container">
    <div class="row">
        <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">

                    <tbody>
                    <tr class="success">
                        <th colspan="5">订单</th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>下单时间</th>
                    </tr>
                    <c:forEach items="${orderItem}" var="orderItem">
                        <tr class="active">
                            <td width="60" width="40%"><input type="hidden" name="id"
                                                              value="22"> <img src="images/product/2.jpg" width="70"
                                                                               height="60"></td>
                            <td width="30%"><a target="_blank">${orderItem.title}</a></td>
                            <td width="20%">￥${orderItem.price }</td>
                            <td width="10%">${orderItem.num}</td>
                            <td width="15%"><span class="subtotal">￥${orderItem.price }</span></td>
                            <td width="30%"><span class="subtotal">${orderItem.order_time }</span></td>
                        </tr>
                    </c:forEach>
                    </tbody>

            </table>
            <a href="${pageContext.request.contextPath}/Excel"><button>下载订单报表</button></a>
        </div>
    </div>

</div>

<%--<a href="${pageContext.request.contextPath}/Download?filename=video.mp4">下载视频</a>--%>
</body>
</html>
