<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>First JSP / Fruit Page</title>
</head>
<body>
    <h1>Hello World!</h1>
	<h1>Fruit of the Day</h1>
    <c:out value="${2+2}"/>
	<h2><c:out value="${fruit}"/></h2> <!-- Pulls in information from FruitController.java; outputs output an escaped attribute that was set to the key of "fruit" which comes from our controller.  -->
</body>
</head>