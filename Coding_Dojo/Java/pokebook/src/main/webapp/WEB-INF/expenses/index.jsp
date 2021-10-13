<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Read Share</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>	
		<h1 class="blueText leftMargin textPadding">PokeBook</h1>
		<table class="table table-sm table-striped text-center" id="tableBox">
    		<thead class="tableTopBorder">
       			<tr>
            		<th class="tableBorders"><b>ID</b></th>
           			<th class="tableBorders"><b>Expense</b></th>
            		<th class="tableBorders"><b>Vendor</b></th>
            		<th class="tableBorders"><b>Amount</b></th>
       			</tr>
    		</thead>
    		<tbody class="tableBottomBorder">
         		<c:forEach var="expense" items="${expenses}"><!-- loop over all the books to show the details as in the wireframe! -->
         		<tr>
         			<td class="tableBorders"><c:out value="${expense.id}"></c:out></td>
         			<td class="tableBorders"><a href="/expenses/${expense.id}"><c:out value="${expense.expenseName}"></c:out></a></td>
         			<td class="tableBorders"><c:out value="${expense.vendor}"></c:out></td>
         			<td class="tableBorders"><c:out value="${expense.cost}"></c:out></td>
         		</tr>
         		</c:forEach>
	    	</tbody>
		</table>
		
		<h2 class="blueText leftMargin2 textPadding">Track an expense:</h2>
<%-- 		<c:if test="${errorCount > 0}"><p class="redText leftMargin2">There are <c:out value="${errorCount}"/> errors on this form</p></c:if> --%>

		<c:url var="actionUrl" value="/expenses/submitForm" />
		<form:form modelAttribute="expense" class="d-flex flex-column formWidth centeredForm" action="${actionUrl}" method="POST">
<%--  			<c:if test="${expenseNameError != null}"><p class="redText leftMargin2"><c:out value="${expenseNameError}"/></p></c:if> --%>
			<p>
				<form:label for="expenseName" path="expenseName">Expense Name: </form:label>
					<form:errors path="expenseName"/> <!-- Checks for errors -->
					<form:input type="text" name="expenseName" id="expenseName" path="expenseName"/>
			</p>
				
			<p>
				<form:label for="vendor" path="vendor">Vendor: </form:label>
					<form:errors path="vendor"/>
					<form:input type="text" name="vendor" id="vendor" path="vendor"/>
			</p>
					
			<p>
				<form:label for="amount" path="cost">Amount ($USD): </form:label>
					<form:errors path="cost"/>
					<form:input type="text" name="cost" id="amount" path="cost"/>
			</p>
			
			<p>
				<form:label for="description" path="description">Description: </form:label>
					<form:errors path="description"/>
					<form:textarea rows="" cols="" name="description" id="description" path="description"/>
			</p>
				
				<form:button type="submit" id="formButton">Submit</form:button>
		</form:form>
		
		
<%-- 		    <form action='/login' method='POST'>action attribute: This is the route that handles what happens when the submit button is pressed. The method mapped to this route will process the form (not to be confused with the one that shows the form--that's "/"). | method attribute: Our options are GET and POST; most likely, we'll want this to be a POST request (but if you don't set it, the default is GET).
		<label for="email">Email:</label>
    		<input type="text" name="email" id="email">Each input element should have a unique value for its name attribute.
    		
		<label for="password">Password:</label>
    		<input type="text" name="password" id="password">
    		
    	<button type="submit">Login</button>
    	<!-- <input type='submit' value='login'> -->
    </form>
    
    <h1>TEST</h1>
    
    <h3>Pay</h3>
    <form action="/processPayment" method="post">
        <input type="hidden" name="productID" value="128">
        <label>Credit Card Number</label>
        <input type="text" name="creditCardNumber">
        <label>Expiration Date</label>
        <input type="date" name="expDate">
        <input type="submit">
    </form> --%>
	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>