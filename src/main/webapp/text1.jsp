<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2017/6/10
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IP SEARCH</title>
</head>
<body>
<h1>IP SEARCH</h1>
<form action="text1" method="post">
<input type="text" name="IP" placeholder="请输入要查询的IP地址" >
<input type="submit" value="查询" >
</form>
<p>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.print(message);
        }
    %>
</p>

</body>
</html>
