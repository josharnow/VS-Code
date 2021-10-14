<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- for rendering errors on PUT routes --%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Page</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Ninjas</h1>
<%-- 	<c:forEach var="i" items="${mafia.vampires}">
		<h6> <c:out value="${i.name}"></c:out> </h6>
	</c:forEach> --%>
	
	
	<table class="table table-sm table-striped text-center" id="tableBox">
    <thead class="tableTopBorder">
       	<tr>
            <th class="tableBorders"><b>First Name</b></th>
           	<th class="tableBorders"><b>Last Name</b></th>
            <th class="tableBorders"><b>Age</b></th>
            <th class="tableBorders"><b>Action</b></th>
       	</tr>
    </thead>
    <tbody class="tableBottomBorder">
         <c:forEach var="ninja" items="${dojo.ninjas}"><!-- loop over all the books to show the details as in the wireframe! -->
         <tr>
         	<td class="tableBorders"><c:out value="${ninja.firstName}"/></td>
<%--          	<td class="tableBorders"><a href="/expenses/${expense.id}"><c:out value="${expense.expenseName}"/></a></td> --%>
         	<td class="tableBorders"><c:out value="${ninja.lastName}"/></td>
         	<%-- <td class="tableBorders"><fmt:formatNumber type="currency"><c:out value="${expense.cost}"/></fmt:formatNumber></td> --%>
         	<td class="tableBorders"><c:out value="${ninja.age}"/></td>
        	<td class="tableBorders">
         		<div class="d-flex flexSpaceEvenly">
         			<a href="/ninjas/${ninja.id}/edit">edit</a>
         			<form action="/ninjas/${ninja.id}/destroy" method="post"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
         		</div>
         	</td>
         		    	
         	<%-- <td class="tableBorders"><a href="/expenses/edit/${expense.id}">edit</a> <form action="/expenses/${expense.id}/destroy" method="post"><button type="submit">delete</button></form></td> --%>
         </tr>
         </c:forEach>
	</tbody>
	</table>
	
	<a href="/ninjas/new"><button>Add New Ninja</button></a>
	<a href="/dojos/new"><button>Create New Dojo</button></a>
	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>