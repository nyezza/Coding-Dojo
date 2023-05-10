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
    <title>New Dojo</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<br>
		<a class="btn btn-info" href="/">New Ninja</a>
		<hr />
		<form:form action="/dojo" method="post" modelAttribute="newDojo">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
		<br>
		<a class="btn btn-Success" href="/">All Ninja</a>
	</div>
</body>
</html>