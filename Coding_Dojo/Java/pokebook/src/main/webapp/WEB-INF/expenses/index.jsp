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
            		<th class="tableBorders"><b>Actions</b></th>
       			</tr>
    		</thead>
    		<tbody class="tableBottomBorder">
         		<c:forEach var="expense" items="${expenses}"><!-- loop over all the books to show the details as in the wireframe! -->
         		<tr>
         			<td class="tableBorders"><c:out value="${expense.id}"/></td>
         			<td class="tableBorders"><a href="/expenses/${expense.id}"><c:out value="${expense.expenseName}"/></a></td>
         			<td class="tableBorders"><c:out value="${expense.vendor}"/></td>
         			<td class="tableBorders"><fmt:formatNumber type="currency"><c:out value="${expense.cost}"/></fmt:formatNumber></td>
         		    <td class="tableBorders">
         		    	<div class="d-flex flexSpaceEvenly">
         		    		<a href="/expenses/edit/${expense.id}">edit</a>
         		    		<form action="/expenses/${expense.id}/destroy" method="post"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
         		    	</div>
         		    </td>
         		    	
         			<%-- <td class="tableBorders"><a href="/expenses/edit/${expense.id}">edit</a> <form action="/expenses/${expense.id}/destroy" method="post"><button type="submit">delete</button></form></td> --%>
         		</tr>
         		</c:forEach>
	    	</tbody>
		</table>
		
		<h2 class="blueText leftMargin2 textPadding">Track an expense:</h2>

		<c:url var="actionUrl" value="/expenses" />
		<form:form modelAttribute="expense" class="d-flex flex-column formWidth centeredForm" action="${actionUrl}" method="POST">		
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