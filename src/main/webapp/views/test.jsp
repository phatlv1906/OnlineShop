<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/lib/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Products</h1>
    
    <p>${not empty list4 ? 'List4 is not empty' : 'List4 is empty or not found'}</p>
    
    <c:if test="${not empty list4}">
        <c:forEach var="product" items="${list4}">
            <div>
                <p>ID: ${product.id}</p>
                <p>Name: ${product.name}</p>
                <p>Description: ${product.description}</p>
                <p>Price: ${product.proprice}</p>
            </div>
        </c:forEach>
    </c:if>
    
    <c:if test="${empty list4}">
        <div>No products found.</div>
    </c:if>
</body>
</html>