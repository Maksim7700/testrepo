<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.time.*" %>
<!DOCTYPE html>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="/js/menu.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/style.css" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css" href="/css/main.css">
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<H1>Current Time</H1> <%= LocalTime.now() %>
<a href="/products">Products</a>
<c:forEach items="${orders}" var="order">
    <hr>
    <p>Price : ${order.price}</p>
    <p>Quantity : ${order.quantity}</p>
    <p>Item : ${order.item}</p>
    <p>Time : ${order.time}</p>
    <c:url var="deleteLink" value="/delete">
        <c:param name="orderId" value="${order.id}"></c:param>
    </c:url>
        <c:if test="${order.afterTime}"><a href="${deleteLink}">Delete</a></c:if>
</c:forEach>
<form:form action="" method="post" modelAttribute="order">
    <form:input path="quantity"/>
    <form:select path="item">
        <form:option value="Phone"/>
        <form:option value="Tv"/>
        <form:option value="Notebook"/>
        <input type="submit" value="sent">
    </form:select>
</form:form>


</div>
</body>
</html>