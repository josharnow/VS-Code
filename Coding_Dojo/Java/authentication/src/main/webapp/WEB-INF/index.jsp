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
	<title>Login & Registration</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="/css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<h1 class="text-center">Registration</h1>
	
    <form:form action="/register" method="POST" modelAttribute="newUser">
        <div class="d-flex flex-column centeredForm">
	        <div class="form-group formWidth centeredForm">
	            <form:label path="username">Username:</form:label>
	            <form:input path="username" class="form-control" />
	            <form:errors path="username" class="text-danger" />
	        </div>
	        <div class="form-group formWidth centeredForm">
	            <form:label path="email">Email:</form:label>
	            <form:input path="email" class="form-control" />
	            <form:errors path="email" class="text-danger" />
	        </div>
	        <div class="form-group formWidth centeredForm">
	            <form:label path="password">Password:</form:label>
	            <form:password path="password" class="form-control" />
	            <form:errors path="password" class="text-danger" />
	        </div>
	        <div class="form-group formWidth centeredForm">
	            <form:label path="confirm">Confirm Password:</form:label>
	            <form:password path="confirm" class="form-control" />
	            <form:errors path="confirm" class="text-danger" />
	        </div>
	        
	        <form:button type="submit" class="btn btn-primary formButton align-self-center">Register</form:button>
		</div>
    </form:form>
    
    
    <h1 class="text-center">Login</h1>
    
    <form:form action="/login" method="POST" modelAttribute="newLogin">
        <div class="d-flex flex-column centeredForm">
	        <div class="form-group formWidth centeredForm">
	            <form:label path="email">Email:</form:label>
	            <form:input path="email" class="form-control" />
	            <form:errors path="email" class="text-danger" />
	        </div>
	        <div class="form-group formWidth centeredForm">
	            <form:label path="password">Password:</form:label>
	            <form:password path="password" class="form-control" />
	            <form:errors path="password" class="text-danger" />
	        </div>
	        	
	        	<form:button type="submit" class="btn btn-success formButton align-self-center">Login</form:button>
		</div>
    </form:form>
    
	<script type="text/javascript" src="/js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="/js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>