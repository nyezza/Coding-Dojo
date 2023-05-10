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
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1><c:out value="${newDojo.name}"/> Ninjas</h1>
		<table class="table">
			<thead>
				<tr style="Align-Content:center">
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="matchingDojo" var="newNinja"></c:forEach>
					<tr>
						<td><c:out value="${newNinja.firstName }"/></td>
						<td><c:out value="${newNinja.lastName }"/></td>
						<td><c:out value="${newNinja.age }"/></td>
					</tr>
			</tbody>
		</table>
	</div>
</body>
</html>