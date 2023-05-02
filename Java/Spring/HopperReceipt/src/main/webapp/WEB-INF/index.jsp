<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Receipt</title>
</head>
<body>
	<h1>Customer Name : <c:out value="${name}" /></h1>
	<h2>item name : <c:out value= "${itemName}" /></h2>
	<h2>price: $ <c:out value="${price}" /></h2>
	<h2>description:  <c:out value="${description}" /></h2>
	<h2>Vendor:  <c:out value="${vendor}" /></h2>
</body>
</html>