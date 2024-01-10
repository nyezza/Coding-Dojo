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
    <title>edit Show</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
   <h1>edit a show 🎬</h1>
   <%-- <p>User ID: ${userID}</p> --%>
   <a href="/">◀ back</a>
   <hr />
 <form:form action="/shows/${show.id}" method="put" modelAttribute="show">
 	
<%--  	<form:hidden path=""/> --%>
         <form:errors path="*" class="text-danger"/>     
    <p>
        <form:label path="title">Title</form:label>
<%--         <form:errors path="title"/> --%>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="network">Network</form:label>
<%--         <form:errors path="network"/> --%>
        <form:textarea path="network"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
<%--         <form:errors path="description"/>      --%>
        <form:input path="description"/>
    </p>    
    
    <br />
    <input type="submit" value="Submit" class="btn btn-success"/>
    <a href="/shows" class="btn btn-warning">Cancel</a>
</form:form>  
<br>
<form action="/shows/${show.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete" class="btn btn-danger">
	</form>  
</div>
</body>
</html>