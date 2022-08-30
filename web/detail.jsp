<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/4/1
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/detail.css">
    <script src="jquery.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <div class="w" style="height: 700px">
        <div class="div1">
            <img src="images/product/2.jpg">
        </div>
        <div class="div2" style="height: 450px">
            <div class="detail_title">
                <h1>${product.title}</h1>
                <p>${product.sell_point}</p>
            </div>
            <div class="price">
                <span>价格：</span>
                <span class="jiage">￥${product.price}</span><br/>
                <span>库存:${product.num}</span>
            </div>
            <select id="select">
                <c:forEach items="${list}" var="addr">
                    <option value="${addr.aid}" id="addr">${addr.province_name}${addr.city_name}${addr.area_name}${addr.address}&nbsp;${addr.name}</option>
                </c:forEach>
            </select>
            <button  id="btn_buy">加入购物车</button>
            <button  id="btn_buy1">直接购买</button><br/>
            <h3 style="margin-top:200px">难以抉择？看看视频推荐吧</h3>
        </div><br/>

        <iframe src="//player.bilibili.com/player.html?aid=726820224&bvid=BV1VS4y1z7tx&cid=728648416&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
        <iframe src="//player.bilibili.com/player.html?aid=213720355&bvid=BV1Ea411a7oQ&cid=588822886&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe><br/>
        <a href="${pageContext.request.contextPath}/Download?filename=video.mp4">下载视频</a>
    </div>

</body>

<script>
    $(function () {

        $("#btn_buy").click(function () {
            var price = '${product.price}';
            var id = '${product.id}'
            $.post("${pageContext.request.contextPath}/AddCart",{
                    id:id,
                    price:price
                },
                function(data,status){
                   if(status == "success"){
                       alert("添加购物车成功！")
                   }
                });
        })
    })

    $("#btn_buy1").click(function () {

        let aid = $("#select").find("option:selected").val();
        $.ajax({
            traditional: true,
            type:"post",
            url:"${pageContext.request.contextPath}/Purchaser",
            data:{
                aid:aid,
                sum:${product.price},
                
            }, success:function(data,status){
                if(status=="success"){
                    alert("购买成功");
                    location.reload();
                }

            }

        })
    })
</script>

</html>
