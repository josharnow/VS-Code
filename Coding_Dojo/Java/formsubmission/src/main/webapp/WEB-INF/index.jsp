<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Form Submission</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
	<link rel="stylesheet" type="text/css" href="css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="css/style.css" --%>
</head>
<body>
	<h3>Login</h3>
	
    <form action='/login' method='POST'><%-- action attribute: This is the route that handles what happens when the submit button is pressed. The method mapped to this route will process the form (not to be confused with the one that shows the form--that's "/"). | method attribute: Our options are GET and POST; most likely, we'll want this to be a POST request (but if you don't set it, the default is GET). --%>
		<label for="email">Email:</label>
    		<input type="text" name="email" id="email"><%-- Each input element should have a unique value for its name attribute. --%>
    		
		<label for="password">Password:</label>
    		<input type="text" name="password" id="password">
    		
    	<button type="submit">Login</button>
    	<!-- <input type='submit' value='login'> -->
    </form>
    
    <h1>TEST</h1>
    
    <h3>Pay</h3>
    <form action="/processPayment" method="post">
        <input type="hidden" name="productID" value="128">
        <label>Credit Card Number</label>
        <input type="text" name="creditCardNumber">
        <label>Expiration Date</label>
        <input type="date" name="expDate">
        <input type="submit">
    </form>

	<script type="text/javascript" src="js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>