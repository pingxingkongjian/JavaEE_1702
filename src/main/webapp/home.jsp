<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2017/6/7
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: red">主页</h1>
<h1 style="color: yellow">说的就是我同桌</h1>
<p><%=request.getAttribute("nick")%></p>
<a href="second.jsp">第二页</a>
</body>
</html>
