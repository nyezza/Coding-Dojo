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
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
<!--    <div class ="container" style="display:flex; justify-content: space-around;">  -->
<div class ="container m-3 row" > 
		<h1 style="color:pink">Book Club</h1>
      <div class="col-8">
       <h2>Registration </h2>
    <form:form method="POST" action="/register" modelAttribute="newUser">

       <div class="mb-3">
               <form:label path="userName" class="form-label" >Name</form:label>
               <form:input class="form-control" path="userName" />
               <form:errors path="userName"  class="text-danger" />
            </div>
                           <div class="mb-3">
               <form:label class="form-label" path="email">Email:</form:label>
               <form:input class="form-control" path="email" />
               <form:errors path="email" class="text-danger" />
            </div>
          <div class="mb-3">
               <form:label path="password" class="form-label" >Password</form:label>
               <form:password class="form-control" path="password" />
               <form:errors path="password" class="text-danger" />
            </div>
           <div class="mb-3">
               <form:label path="confirm" class="form-label" >Confirm PW</form:label>
               <form:password class="form-control" path="confirm" />
               <form:errors path="confirm"  class="text-danger"/>
            </div>

           <div class="mb-3">
                <input type="submit" value="Register" class="btn btn-primary"/>
            </div>
        
    </form:form>
   </div>
   
   <div class="col-4">
       <h1>Login </h1>
    <form:form method="POST" action="/login" modelAttribute="newLogin">
        <div class="mb-3">
                <form:label class="form-label" path="email">Email</form:label>
                <form:input class="form-control" path="email" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="mb-3">
             <form:label class="form-label" path="password">Password</form:label>
                <form:password class="form-control" path="password" />
                <form:errors path="password" class="text-danger" />
            </div>
            
                <input type="submit" value="Login" class="btn btn-primary"/>

    </form:form>
    </div>
  

   </div>
</body>
</html>