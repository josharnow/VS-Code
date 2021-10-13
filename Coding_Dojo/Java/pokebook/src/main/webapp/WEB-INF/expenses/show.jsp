<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Expense</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<div class="d-flex spaceBetween">
		<h1 class="blueText">Expense Details</h1>
		<a class="verticalFlexCenter" href="/expenses">Go back</a>
	</div>
	
	<div>
<%-- 		<c:forEach var="expense" items="${expenses}"> --%>
		<div class="d-flex centeredDiv">
			<p>Expense Name: </p>
			<p><c:out value="${expense.expenseName}"/></p>
		</div>
		<div class="d-flex centeredDiv">
			<p>Description: </p>
			<p><c:out value="${expense.description}"/></p>
		</div>			
		<div class="d-flex centeredDiv">
			<p>Vendor: </p>
			<p><c:out value="${expense.vendor}"/></p>
		</div>		
		<div class="d-flex centeredDiv">
			<p>Amount Spent: </p>
			<p><c:out value="${expense.cost}"/></p>
		</div>
<%-- 		</c:forEach> --%>
	</div>
	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>