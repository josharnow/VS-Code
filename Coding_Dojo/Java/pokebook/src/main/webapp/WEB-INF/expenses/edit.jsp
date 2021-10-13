<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit My Task</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<div class="d-flex spaceBetween sideMargins">
		<h1 class="greenText">Edit Expense</h1>
		<a class="verticalFlexCenter" href="/expenses">Go back</a>
	</div>
	
	<c:url var="actionUrl" value="/expenses/${expense.id}/update" />
	<form:form modelAttribute="expense" class="d-flex flex-column formWidth centeredForm" action="${actionUrl}" method="PUT">
		<form:errors path="expenseName" class="redText"/> <!-- Checks for errors -->
		<p>
			<form:label for="expenseName" path="expenseName">Expense Name: </form:label>
				<form:input type="text" name="expenseName" id="expenseName" path="expenseName"/>
		</p>
				
		<form:errors path="vendor" class="redText"/>
		<p>
			<form:label for="vendor" path="vendor">Vendor: </form:label>
				<form:input type="text" name="vendor" id="vendor" path="vendor"/>
		</p>
					
		<form:errors path="cost" class="redText"/>
		<p>
			<form:label for="amount" path="cost">Amount ($USD): </form:label>
				<fmt:formatNumber type="number" pattern="0.00" value="${expense.cost}" var="expenseCost"/>
				<form:input value="${expenseCost}" type="number" step="0.01" name="cost" id="amount" path="cost"/>
		</p>
			
		<form:errors path="description" class="redText"/>
		<p>
			<form:label for="description" path="description">Description: </form:label>
				<form:textarea rows="" cols="" name="description" id="description" path="description"/>
		</p>
				
			<form:button type="submit" id="formButton">Submit</form:button>
	</form:form>
	

	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>