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
	<div class="container" style=" justify-content:center">
		<h1>Here's Your Omikuji!</h1>
		<p style="background-color: cyan; border: 2px solid black; width:400px" >in <c:out value="${num }"></c:out>  years,
		 you will live in <c:out value="${city }"></c:out> with <c:out value="${person }"></c:out> as your roomate, 
			<c:out value="${hobby }"></c:out> for a living.
			The next time you see a <c:out value="${living }"></c:out>, 
			you will have good luck. Also,<c:out value="${someone }"></c:out>.</p>
		<a href="/omikuji">Go Back</a>
		
	</div> 

</body>
</html>