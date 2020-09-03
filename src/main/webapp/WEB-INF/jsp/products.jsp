<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<c:forEach items="${products}" var="product">
    <p>${product.name}
        ${product.price}
    </p>


</c:forEach>


</div>
</body>
</html>