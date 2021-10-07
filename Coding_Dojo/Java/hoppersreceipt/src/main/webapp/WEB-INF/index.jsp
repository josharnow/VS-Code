<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Simple Receipt</title>
	<link rel="stylesheet" type="text/css" href="css/style.css"> <%-- YOUR own local CSS --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> <%-- for Bootstrap CSS --%>
</head>
<body>
    <h1>Customer Name: <c:out value="${name}"/></h1> <%-- Pulls in information from ReceiptController.java; outputs output an escaped attribute that was set to the key of "fruit" which comes from our controller.  --%>
	<h3>Item name: <c:out value="${itemName}"/></h3>
	<h3>Price: $<c:out value="${price}"/></h3>
	<h3>Description: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${vendor}"/></h3>
	
	<p class="h2 text-primary">BOOTSTRAP TEST</p>
	
	<script type="text/javascript" src="js/app.js"></script> <%-- YOUR own local JS --%>
	<script src="/webjars/jquery/jquery.min.js"></script> <%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</head>