<%--
  Created by IntelliJ IDEA.
  User: smirs
  Date: 08.01.2022
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Banks</title>
</head>
<body>
<style>
    table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        border-collapse: collapse;
        color: #686461;
    }

    caption {
        padding: 10px;
        color: white;
        background: #8FD4C1;
        font-size: 18px;
        text-align: left;
        font-weight: bold;
    }

    th {
        border-bottom: 3px solid #B9B29F;
        padding: 10px;
        text-align: left;
    }

    td {
        padding: 10px;
    }

    tr:nth-child(odd) {
        background: white;
    }

    tr:nth-child(even) {
        background: #E8E6D1;
    }
</style>
<table>
    <caption>
        <c:out value="Банковские вклады"/>
    </caption>
    <tr>
        <th>
            <c:out value="Банк"/>
        </th>
        <th>
            <c:out value="Тип вклада"/>
        </th>
        <th>
            <c:out value="Имя вкладчика"/>
        </th>
        <th>
            <c:out value="Номер счета"/>
        </th>
        <th>
            <c:out value="Сумма вклада"/>
        </th>
        <th>
            <c:out value="Годовой процент"/>
        </th>
        <th>
            <c:out value="Срок вклада"/>
        </th>
    </tr>

    <c:forEach items="${banks}" var="bank">
        <tr>
            <td><c:out value="${bank.name}, ${bank.country}"/></td>
            <td><c:out value="${bank.type}"/></td>
            <td><c:out value="${bank.depositor}"/></td>
            <td><c:out value="${bank.accountID}"/></td>
            <td><c:out value="${bank.depositAmount}"/></td>
            <td><c:out value="${bank.profitability}"/></td>
            <td><c:out value="${bank.timeConstraints}"/></td>
        </tr>
    </c:forEach>
</table>
<caption>
    <ctg:info-time/>
</caption>
</body>
</html>