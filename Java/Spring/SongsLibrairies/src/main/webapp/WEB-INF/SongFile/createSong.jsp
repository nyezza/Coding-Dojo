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
    <title>Create new song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<%-- <div class="container">
		<h1>Create new Song</h1>
		<hr/>
		
		<form:form action="/songs" method="post" modelAttribute="song">
		<form:errors path="*" class="text-danger"></form:errors>
		Title: <form:input path="songName" />
		Singer:<form:input path="singerName" />
		<form:select path="matchingAlbum">
			<c:forEach items="${allAlbums }" var="album">
				<form:option value="${album.id }">${album.albumName }</form:option>
			</c:forEach>
		</form:select>
		<button class="btn btn-success">create</button> 
		
		</form:form>
		
	</div> --%>
</body>
</html>