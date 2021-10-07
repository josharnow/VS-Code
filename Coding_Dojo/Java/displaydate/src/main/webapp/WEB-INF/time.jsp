<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Time</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
	<link rel="stylesheet" type="text/css" href="css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="css/style.css" --%>
</head>
<body>
	<h1 class="text-center"><c:out value="${time}"/></h1>
	<a href="/">Return to Index</a>
<!-- 	<a class="text-center" href="">Return to Index</a> -->
	
	<script type="text/javascript" src="js/time.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>