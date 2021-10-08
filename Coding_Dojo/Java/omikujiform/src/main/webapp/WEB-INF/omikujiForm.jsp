<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Omikuji</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /><%-- for Bootstrap CSS --%>
	<link rel="stylesheet" type="text/css" href="css/style.css"><%-- YOUR own local CSS --%><%-- href path is "static" folder e.g. href="css/style.css" --%>
</head>
<body>
	<h1 class="text-center">Send an Omikuji!</h1>

	<div class="formBox justify-content-center centeredFormItems">
		<form action="/omikuji/submit" target="" method="POST" id="" class="d-flex flex-column justify-content-center">
			<label for="number" class="centeredFormItems">Pick any number from 5 to 25: </label>
				<input type="number" class="centeredFormItems" name="number" onclick="" id="number"></input>

			<label for="city" class="centeredFormItems">Enter the name of any city: </label>
				<input type="text" class="centeredFormItems" name="city" onclick="" id="city"></input>
				
			<label for="person" class="centeredFormItems">Enter the name of any real person: </label>
				<input type="text" class="centeredFormItems" name="person" onclick="" id="person"></input>

			<label for="endeavor" class="centeredFormItems">Enter professional endeavor or hobby: </label>
				<input type="text" class="centeredFormItems" name="endeavor" onclick="" id="endeavor"></input>

			<label for="livingThing" class="centeredFormItems">Enter any type of living thing: </label>
				<input type="text" class="centeredFormItems" name="livingThing" onclick="" id="livingThing"></input>

			<label for="textBox" class="centeredFormItems">Say something nice to someone: </label>
				<textarea name="textBox" class="centeredFormItems" id="textBox" cols="30" rows="10"></textarea>

			<label for="button" class="centeredFormItems"><i>Send and show a friend</i></label>
				<button type="submit" class="centeredFormItems" name="button" id="button" onclick="">Send</button>
		</form>
	</div>
	
	<script type="text/javascript" src="js/app.js"></script><%-- for YOUR JS --%><%-- src path is "static" folder e.g. src="js/app.js" --%>
	<script src="/webjars/jquery/jquery.min.js"></script><%-- For any Bootstrap that uses JS or jQuery--%>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>