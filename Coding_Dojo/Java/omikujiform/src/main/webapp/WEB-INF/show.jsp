<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Omikuji</title>
	<link rel="stylesheet" type="text/css" href="css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="css/style.css" --%>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
</head>
<body>
	<h1 class="text-center">Here's your Omikuji!</h1>
	
	<div class="box">
		<h1 class="text-center">TEST</h1>

		<p>
			In <c:out value="${number}" /> years, you will live in <c:out value="${city}" /> with <c:out value="${person}" /> as your roommate, <c:out value="${endeavor}"/> for a living. The next time you see a <c:out value="${livingThing}"/>, you will have good luck. Also, <c:out value="${textBox}" />.
		</p>
	</div>
	
	<a href="/omikuji" class="">Go Back</a>
	<!-- <a href="/omikuji" class="text-center justify-content-center">Go Back</a>--> <!-- Doesn't work to center anchor link for some reason -->
	
	<script type="text/javascript" src="js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>