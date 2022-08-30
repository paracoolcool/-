<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/10/24
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1.0" />
<%--    <meta http-equiv='refresh' content='1';url='/Product'>--%>
    <title>商城首页</title>

    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/page1.css">

    <script src="jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
            $.ajax("${pageContext.request.contextPath}/Product",function () {
                var my = session.getAttribute("products");
                console.log(my)
            })
        })

    </script>
    <script>
    </script>
<%--    <script src="bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>--%>
    <style>
        @font-face {
            font-family: 'icomoon';
            src:  url('fonts/icomoon.eot?1vi3ks');
            src:  url('fonts/icomoon.eot?1vi3ks#iefix') format('embedded-opentype'),
            url('fonts/icomoon.ttf?1vi3ks') format('truetype'),
            url('fonts/icomoon.woff?1vi3ks') format('woff'),
            url('fonts/icomoon.svg?1vi3ks#icomoon') format('svg');
            font-weight: normal;
            font-style: normal;
            font-display: block;
        }
        .div_03{
            width: 100%;
            height: 100%;
        }
        .imgbox{
            width: 100%;
            height: 100%;
        }
        .imgbox img{
            width: 100%;
            height: 100%;
        }
        .img01{
            width: 100%;
            height: 100%;
        }
        .each:hover{
            border: 1px solid red;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $(".dropdown").mouseenter(function () {
                $(".dd").show();
            })
            $(".dropdown").mouseleave(function () {
                $(".dd").hide();
            })
        })
    </script>
</head>
<body>
<%--    顶部导航栏开始--%>
    <section class="shortcut">
        <div class="w">
<%--            <div class="fl">--%>
<%--                你好！请<a href="i.jsp">登录</a>--%>
<%--            </div>--%>
            <div class="fr">
                <ul>
                    <li><a>我的订单</a></li>
                    <li>|</li>
                    <li><a href="myself.jsp" >我的商城</a></li>
                    <li>|</li>
                    <li><a>商城会员</a></li>
                    <li>|</li>
                    <li><a>企业采购</a></li>
                    <li>|</li>
                    <li><a>客户服务</a></li>
                    <li>|</li>
                    <li><a>手机商城</a></li>
                    <li>|</li>
                    <li>
                        <div class="demo_02">
                            <a >更多</a>
                            <div class="more">
                                <a>帮助</a>
                                <a>滴滴</a>
                                <a>哔哔</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </section>
<%--顶部导航栏结束--%>
<%--推荐区开始--%>
    <section class="header">
        <div class="w">
            <div>
                <a href="#"><img src="./images/img1.png"></a>
                <a href="#"><img src="./images/img2.png"></a>
                <a href="#"><img src="./images/img3.png"></a>
                <a href="#"><img src="./images/img4.png"></a>
                <a href="#"><img src="./images/img5.png"></a>
            </div>
        </div>
    </section>
<%--推荐区结束--%>
<%--内容导航开始--%>
    <section class="container">
        <div class="w">
            <%--搜索区--%>
            <div class="search">
                <img src="./images/Tmall.png">
                <form class="search_area">
                    <input type="text" placeholder="搜索商品/手机/服饰" id="sc_input">
                    <input type="button" value="搜索" id="sc_btn">
                    <div class="shopcar">
                        <img src="./images/shopcar.png">
                        <a href="${pageContext.request.contextPath}/MyCart">我的购物车</a>
                        <a id="tip">99+</a>
                    </div>
                </form>

            </div>
            <div id="navDemo">
                <div class="dropdown">
                    <div class="dt">
                        全部商品分类
                    </div>
                    <div class="dd">
                        <ul>
                            <li><a href="#">家用电器</a></li>
                            <li><a href="#">手机&nbsp;/</a>&nbsp;<a href="#">运营商&nbsp;/</a>&nbsp;<a href="#">数码</a></li>
                            <li><a href="#">零食&nbsp;/</a>&nbsp;<a href="#">茶酒&nbsp;/</a>&nbsp;<a href="#">进口商品</a></li>
                            <li><a href="#">母婴玩具</a></li>
                            <li><a href="#">男鞋&nbsp;/</a>&nbsp;<a href="#">女鞋&nbsp;/</a>&nbsp;<a href="#">箱包</a></li>
                            <li><a href="#">医药保健</a></li>
                            <li><a href="#">汽车&nbsp;/</a>&nbsp;<a href="#">配件&nbsp;/</a>&nbsp;<a href="#">用品</a></li>
                            <li><a href="#">家纺&nbsp;/</a>&nbsp;<a href="#">家饰&nbsp;/</a>&nbsp;<a href="#">鲜花</a></li>
                            <li><a href="#">生鲜水果</a></li>
                            <li><a href="#">大家电&nbsp;/</a>&nbsp;<a href="#">生活电器</a></li>
                            <li><a href="#">美妆&nbsp;/</a>&nbsp;<a href="#">个人护理</a></li>
                            <li><a href="#">女装&nbsp;/</a>&nbsp;<a href="#">内衣</a></li>
                            <li><a href="#">男装&nbsp;/</a>&nbsp;<a href="#">运动户外</a></li>
                            <li><a href="#">图书音像</a></li>
                            <li><a href="#">腕表&nbsp;/</a>&nbsp;<a href="#">眼睛&nbsp;/</a>&nbsp;<a href="#">珠宝饰品</a></li>
                        </ul>
                    </div>
                </div>
                <div class="navitems">
                    <ul>
                        <li><a>服装城</a></li>
                        <li><a>美妆馆</a></li>
                        <li><a>超市</a></li>
                        <li><a>生鲜</a></li>
                        <li><a>邑大国际</a></li>
                        <li><a>闪购</a></li>
                        <li><a>拍卖</a></li>
                        <li><a>二手市场</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
<%--内容导航结束--%>
<%--中间轮播图和内容区开始--%>
      <div class="w">
            <div class="main">
                <div style="width: 100%;height: 100%">
                    <div class="carousel">
                        <div class="div_03">
                            <div class="imgbox">
                                <img class="img-slide img" src="images/index_banner3.png">
                                <img class="img-slide img" src="images/index_banner4.png">
                                <img class="img-slide img" src="images/index_banner5.png">
                            </div>
                        </div>
                    </div>
                    <div class="newsflash">
                        <img class="img01" src="images/OIP-C.jpg">
                    </div>
                </div>
           </div>
      </div>
<%--商品陈列区开始--%>
    <div class="w" >
        <div style="width: 100%;height: 100%;display: flex;flex-wrap: wrap;justify-content: space-around;background-color: #f9f9f9">
            <c:forEach items="${products}" begin="0" end="9"  var="p">
            <div style="width:220px;height: 304px" class="each">
                <a href="${pageContext.request.contextPath}/productDetail?id=${p.id}">
                    <div style="width: 100%;height: 60%">
                        <img src="images/product/2.jpg"style="height: 100%;width: 100%">
                    </div>
                    <div style="width: 100%;height: 40%">
                        <p style="height: 50%">${p.title}</p>
                        <p style="height: 50%">￥：${p.price}</p>
                    </div>
                </a>
            </div>
            </c:forEach>
        </div>
    </div>
<%--    底部区域开始--%>
    <footer class="footer">
        <div class="w">
            <div class="mod_service">
                <ul>
                    <li>
                        <h5>图标</h5>
                        <div class="svic_1">
                            <h4>正品保障</h4>
                        </div>
                    </li>
                    <li>
                        <h5>图标</h5>
                        <div class="svic_1">
                            <h4>送上宿舍</h4>
                        </div>
                    </li>
                    <li>
                        <h5>图标</h5>
                        <div class="svic_1">
                            <h4>良心价格</h4>
                        </div>
                    </li>
                    <li>
                        <h5>图标</h5>
                        <div class="svic_1">
                            <h4>服务周到</h4>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mod_message">
                <div class="img">
                    <p>联系作者</p>
                    <img src="./images/wenxin.png">
                </div>
            </div>
            <div class="mod_copyright">
                <div>
                    <p>地址：广东省江门市五邑大学48栋1016</p>
                    <p>联系电话：18718559622；邮箱：728218552@qq.com</p>
                </div>
            </div>
        </div>

    </footer>

</body>
<script type="text/javascript">
    var index= 0,len;
    var imgBox = document.getElementsByClassName("img-slide");
    len = imgBox.length;
    imgBox[index].style.display = 'block'
    function slideShow() {

        index ++;

        // 防止数组溢出

        if(index >= len) index = 0;

        // 遍历每一个元素

        for(var i=0; i<len;i++){
            imgBox[i].style.display = 'none';

        }
        // 每次只有一张图片显示
        imgBox[index].style.display = 'block';
    }
    setInterval(slideShow, 3000);
</script>
<%--<script>--%>
<%--    $(window).on("resize scroll",function(){--%>

<%--        var windowHeight = $(window).height();//当前窗口的高度--%>
<%--        var scrollTop = $(window).scrollTop();//当前滚动条从上往下滚动的距离--%>
<%--        var docHeight = $(document).height(); //当前文档的高度--%>
<%--        console.log(scrollTop, windowHeight, docHeight);--%>
<%--        //当 滚动条距底部的距离 + 滚动条滚动的距离 >= 文档的高度 - 窗口的高度--%>
<%--        //换句话说：（滚动条滚动的距离 + 窗口的高度 = 文档的高度）  这个是基本的公式--%>
<%--        if (scrollTop + windowHeight >= docHeight) {--%>
<%--            console.log("===加载更多数据===");--%>
<%--        }--%>
<%--    });--%>
<%--</script>--%>
<script>
    $("#sc_btn").click(function () {

        var y = $("#sc_input").val();

        console.log(y)
        $.ajax({
            traditional: true,
            type:"post",
            url:"${pageContext.request.contextPath}/QuickSearch",
            data:{
                title:$("#sc_input").val()
            }, success:function(data,status){

                location.reload();
            }

        })
    })



</script>
</html>
