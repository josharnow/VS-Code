<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Form</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="/books" method="post" modelAttribute="book">
    	<p>
        	<form:label path="title">Title</form:label>
        	<form:errors path="title"/>
       	 	<form:input path="title"/>
    	</p>
    	<p>
        	<form:label path="description">Description</form:label>
        	<form:errors path="description"/>
        	<form:textarea path="description"/>
    	</p>
    	<p>
        	<form:label path="language">Language</form:label>
        	<form:errors path="language"/>
        	<form:input path="language"/>
    	</p>
    	<p>
        	<form:label path="numberOfPages">Pages</form:label>
        	<form:errors path="numberOfPages"/>     
        	<form:input type="number" path="numberOfPages"/>
    	</p>    
    	<input type="submit" value="Submit"/>
	</form:form>    
	
	
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>