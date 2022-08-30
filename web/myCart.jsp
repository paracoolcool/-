<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/4/22
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我的购物车</title>
    <link href="css/myCart.css" rel="stylesheet">
    <script src="jquery.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="car">

    <div class="good">
        <table><tr><td width=30%>商品名称</td><td width=20%>单价</td><td width=20%>数量</td><td width=30%>操作</td></tr></table>
    </div>
    <c:forEach items="${cart}"  var="c">
    <div class="goods" id="box">
        <table><tr>
            <td width=30%> <input name="jcd" id="${c.cid}" type="checkbox" value="${c.price}" onclick="checkboxOnclick(this)">${c.title}</td>
            <td width=20%>${c.price}</td><td width=20%>${c.num}</td>
            <td width=30%><a href="${pageContext.request.contextPath}/DeleteCart?cid=${c.cid}"><button class="btn1">删除</button></a></td></tr></table>
    </div>
    </c:forEach>
    
    <div class="goods2">
        <table><tr><td width=560><select id="select">
                <c:forEach items="${list}" var="addr">
                    <option value="${addr.aid}" id="addr">${addr.province_name}${addr.city_name}${addr.area_name}${addr.address}&nbsp;${addr.name}</option>
                </c:forEach>
            </select></td>
            <td width=20%>小计：<span id="sum">0</span></td><td>总数：</td></tr></table>
    </div>
    <div class="goods1">
        <table><tr><td width=50%><button id="btn2">确认购买</button></td></tr></table>
    </div>

</div>
</body>
<script>


    /***
     * 对购物车复选框的点击事件，计算总价格
     * @param checkbox
     */
    function checkboxOnclick(checkbox) {
        let a = parseInt(checkbox.value);
        let cid = parseInt(checkbox.id);
        var check_arr = $('#box input[type=checkbox]:checked');
        console.log(check_arr.length);
        cids = new Array();
        $.each(check_arr,function(){
            //想数组里添加一个元素
            cids.push(
                $(this).attr('id')
            );

        });
        console.log(cids);
        let b = parseInt($("#sum").text());
        if (checkbox.checked == true) {
            $("#sum").text(b+a);
            console.log(cids);
        } else {
            $("#sum").text(b-a);
        }
        return $("#sum").text(),cids;
    }


    $("#btn2").click(function () {

        let aid = $("#select").find("option:selected").val();
        $.ajax({
            traditional: true,
            type:"post",
            url:"${pageContext.request.contextPath}/AddOrder",
            data:{
                aid:aid,
                sum:$("#sum").text(),
                cids:cids
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
