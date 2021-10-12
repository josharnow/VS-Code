<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<h1>All Books</h1>
	<table>
    	<thead>
       		<tr>
            	<th>ID</th>
           		<th>Title</th>
            	<th>Language</th>
            	<th>Number of Pages</th>
       		</tr>
    	</thead>
    	<tbody>
         	<c:forEach var="book" items="${books}">
         	<tr>
         		<td><c:out value="${book.id}"></c:out></td>
         		<td><c:out value="${book.title}"></c:out></td>
         		<td><c:out value="${book.language}"></c:out></td>
         		<td><c:out value="${book.numberOfPages}"></c:out></td>
         	</tr>
         	</c:forEach>  <!-- loop over all the books to show the details as in the wireframe! -->
	    </tbody>
	</table>
	
	
<%-- 			<c:forEach var="fruit" items="${fruitsFromMyController}">
			<tr>
				<td><c:out value="${fruit.name}"/></td>
				<td><fmt:formatNumber value="${fruit.price}" type="currency"/></td>
			</tr>
		</c:forEach>
	 --%>
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>