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
    <title>All albums</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>All Albums</h1>
		<hr/>
		<div>
		<a class="btn btn-primary" href="/album/new">create</a>
		<a class="btn btn-secondary" href="/songs">Go to Songs</a>
		</div>
		<hr/>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Album Name</th>
					<th>Number of Songs</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${album}" var="album">
					<tr>
						<td><c:out value="${album.id }"></c:out></td>
						<td><a href="/songs/${album.id }"><c:out value="${album.albumName }"></c:out> </a></td>
						<td><c:out value="${album.numberOfSongs }"></c:out></td>
						<td>
							<a class="btn btn-success" href="/albums/${album.id }">View</a>
							<a class="btn btn-info" href="/albums/edit/${album.id }">Edit</a>
							<form action="/${album.id}" method="post" class="btn btn-danger">
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