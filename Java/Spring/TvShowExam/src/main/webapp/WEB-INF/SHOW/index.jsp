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
    <title>All Show</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">

<h1>Welcome, <c:out value="${user.userName }"/></h1>
 
<hr />
<div style="display:flex; justify-content: space-between"> 
<h2>TV SHOWS 🎬</h2>
<a href="/logout">LogOut 🌍</a>
</div>
   <hr />

<table class="table">
<thead>
<tr>
<th> ID </th>
<th> Title </th>
<th> Network </th>
</tr>
</thead>
<tbody>
<c:forEach items="${allShows}" var ="oneshow">
<tr>
<td> <c:out value="${oneshow.id }"></c:out> </td>
<td> <a href="/shows/${oneshow.id }"> <c:out value="${oneshow.title }"/></a> </td>
<td> <c:out value="${oneshow.network }"></c:out> </td>
</tr>
</c:forEach>
</tbody>
</table>

<a href="/shows/create" class="btn btn-success">Create Show</a>

</div>
</body>
</html>

