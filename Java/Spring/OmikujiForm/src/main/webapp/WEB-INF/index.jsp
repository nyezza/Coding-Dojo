<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Omikuji</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1 class="text-primary">Send an Omikuji</h1>
		<form action="/omikuji/show" method="get" class="form-control">
			<label class="form-label">Pick any number from 5 to 25</label>
			<input type="number" name="num" min="5" max="25" class="form-control">
			
			<label class="form-label">Enter the name on any city:</label>
			<input type="text" name="city" class="form-control">
			
			<label class="form-label">Enter the name of any real person:</label>
			<input type="text" name="person" class="form-control">
			
			<label class="form-label">Enter professional endeavor or hobby:</label>
			<input type="text" name="hobby" class="form-control">
			
			<label class="form-label">Enter any type of living things:</label>
			<input type="text" name="living" class="form-control">
			
			<label class="form-label">Say something nice to someone:</label>
			<input type="text" name="someone" class="form-control">
			
			<label class="form-label">Send and show a friend</label>
			<button>Send</button>
		</form>
	</div>
	
</body>
</html>