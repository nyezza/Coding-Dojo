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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1 style="color:blue">Save Travels</h1>
	<table class="table table-striped">
		<thead>
			<tr style="font:bold;text-align: center">
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${onetravel}" var="onetravel">
			<tr style="text-align: center">
			<td><a href="/expenses/view/${onetravel.id}"><c:out value="${onetravel.expense}"/></a></td>
			<td><c:out value="${onetravel.vendor}"/></td>
			<td><p>$</p><c:out value="${onetravel.amount}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<h2 style="color:blue">Add an expense</h2>
	<form:form action="/expenses" method="post" modelAttribute="travel">
	<form:errors path="*"/>
		<p>
			<form:label path="expense">Expense Name:</form:label>
			<form:errors path="expense"/>
			<form:input path="expense"/>
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor"/>
			<form:input path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amout"/>
			<form:input type="number" step="0.01" min="0" path="amount"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label><hr />
			<form:errors path="description"/>
			<form:input path="description"/>
		</p>
		<input type="submit" value="submit" class="btn btn-success">
	</form:form>
</div>
</body>
</html>