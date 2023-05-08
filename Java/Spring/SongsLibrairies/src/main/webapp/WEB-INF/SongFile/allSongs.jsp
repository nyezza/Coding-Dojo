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
    <title>All Songs</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>All Songs</h1>
		<hr/>
		<div>
			<a class="btn btn-primary" href="/songs/new">create</a>
			<a class="btn btn-secondary" href="/">Go back to Album</a>
		</div>
		
		<hr/>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Song Title</th>
					<th>Singer</th>
					<th>Album</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${song}" var="song">
					<tr>
						<td><c:out value="${song.id }"></c:out></td>
						<td><a href="/songs/${song.id }"><c:out value="${song.name }"></c:out> </a></td>
						<td><c:out value="${song.singer }"></c:out></td>
						<td><c:out value="{song.matchingAlbum.albumName}"></c:out></td>
						<td>
							<a class="btn btn-success" href="/songs/${song.id }">View</a>
							<a class="btn btn-info" href="/songs/edit/${song.id }">Edit</a>
							<form action="/songs/${song.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
														
							
						</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>