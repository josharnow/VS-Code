<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Simple Receipt</title>
</head>
<body>
    <h1>Customer Name: <c:out value="${name}"/></h1> <!-- Pulls in information from FruitController.java; outputs output an escaped attribute that was set to the key of "fruit" which comes from our controller.  -->
	<h3>Item name: <c:out value="${itemName}"/></h3>
	<h3>Price: $<c:out value="${price}"/></h3>
	<h3>Description: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${vendor}"/></h3>
</body>
</head>