<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!--enctype="multipart/form-data" 使用二进制提交-->
<form action="upload"  method="post" enctype="multipart/form-data">
    <input type="text" name="fname" placeholder="请输入文件名"/><br />
    <input type="file" name="myfile">
    <button>保存头像</button>
</form>
<%--<img src="myfile/<%=request.getAttribute("fname") %>"/>--%>

<%--<img src="myfile/${fname}" width="200px" height="400px"/>--%>

</body>
</html>