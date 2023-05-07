<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
    <title>All Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>Display All Books</h1>
		<hr />
		<a class="btn btn-outline-primary" href="/newBook">New Book</a>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Language</th>
					<th scope="col">Number Of Pages</th>
					<th scope="col">Description</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${books }">
					<tr>
						<td>${oneBook.id }</td>
						<td>${oneBook.title }</td>
						<td>${oneBook.language }</td>
						<td>${oneBook.numberOfPages }</td>
						<td>${oneBook.description }</td>
						<td>
						<a class="btn btn-primary" href="/${oneBook.id}">View</a>
						<a class="btn btn-warning" href="/edit/${oneBook.id}">Edit</a>
						<!--  <a class="btn btn-danger" href="/delete/${oneBook.id}">Delete</a>-->
						<form action="/${oneBook.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn btn-danger">
						    
						</form>
						</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>