<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current visit count: <c:out value="${counter}"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
	<link rel="stylesheet" type="text/css" href="css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="css/style.css" --%>
</head>
<body>
	<p>You have visited <a href="/">localhost:8080</a> <c:out value="${countToShow}"/> times.</p>
	<a href="/">Test another visit?</a>
	
	
	<script type="text/javascript" src="js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>