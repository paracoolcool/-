<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/4/8
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加收货地址</title>
</head>
<body>
    <div class="box">
        <form action="addAddress" method="post">
            收货人：<input type="text" name="name"><br/>
            联系电话：<input type="text" name="phone"><br/>
            省/直辖市：<select name="sheng">
            <option value="广东">广东</option>

        </select><br/>
            城市：<select name="city">
            <option value="江门">江门</option>
        </select><br/>
            区县：<select name="area">
            <option value="蓬江区">蓬江区</option>
            <option value="新会区">新会区</option>
            <option value="江海区">江海区</option>
        </select><br/>
            详细地址：<input type="text" name="add_msg"><br/>
            地址类型：<select name="type">
                        <option value="家">家</option>
                        <option value="公司">公司</option>
                        <option value="学校">学校</option>
                    </select><br/>
            <input type="submit" value="保存">
            <input type="reset" value="重置">
        </form>
    </div>
</body>
</html>
