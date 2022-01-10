<%--
  Created by IntelliJ IDEA.
  User: smirs
  Date: 14.12.2021
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> XML Parser</title>
</head>
<body>
<div style=" margin: 50px 300px 380px 50px; ">
    <form action="parserServlet" method="post" enctype="multipart/form-data">
        <c:out value="XML-файл:"/>
        <input type="file" name="file" size="50"/> <br><br>
        <c:out value="XSD-файл:"/>
        <input type="file" name="file" size="50"/>
        <br><br>
        <c:out value="Выберите тип парсера:"/>
        <div>
            <input type="radio" id="dom"
                   name="parserType" value="DOM">
            <label for="dom">DOM</label>

            <input type="radio" id="sax"
                   name="parserType" value="SAX">
            <label for="sax">SAX</label>

            <input type="radio" id="stax"
                   name="parserType" value="StAX">
            <label for="stax">StAX</label>
        </div>
        <br>
            <button type="submit" style="height:50px;width:200px">Выполнить</button>

    </form>
</div>
</body>
</html>