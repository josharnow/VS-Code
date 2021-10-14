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
	<title>***INSERT PAGE TITLE***</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<!--- ... --->
	<h1>Person Details:></h1>
	<table class="table">
	    <thead class="thead-dark">
	        <tr>
	            <th>Name</th>
	            <th>License Number</th>
	            <th>State</th>
	            <th>Exp Date</th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	            <td>
	                <c:out value="${person.firstName}"/>
	                <c:out value="${person.lastName}"/>
	            </td>
	            <td><c:out value="${person.license.state}"/></td>
	            <td><c:out value="${person}"/></td>
	            <td>
	                <c:out value="${person.license.expirationDate}"/>
	            </td>
	        </tr>
	    </tbody>
	</table>
	<!--- ... --->
	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>