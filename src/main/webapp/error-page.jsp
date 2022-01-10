<%--
  Created by IntelliJ IDEA.
  User: smirs
  Date: 08.01.2022
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<h1>Ошибка</h1>
Exception: <%=exception%><br/>
Message: <%=exception.getMessage()%><br/>
</body>
</html>
