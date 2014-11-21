<%-- 
    Document   : loginPage
    Created on : 14 Nov, 2014, 10:31:17 PM
    Author     : amit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Login Page</title>
    </head>
    <body>
        <div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<h1 class="page-header">Login To Ewallet Account
		</h1>
	    </div>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<form accept-charset="UTF-8" role="form" method="POST" action="<c:url value="/client/dashboard"/>">
		    <fieldset>
			<div class="form-group">
			    <label>Username</label>
			    <input class="form-control" placeholder="Username" name="username" type="text" autofocus="true" autocomplete="true" value="${username}">
			</div>
			<div class="form-group">
			    <label>Password</label>
			    <input class="form-control" placeholder="Password" name="password" type="password" value="${password}">
			</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
		    </fieldset>
		</form>
	    </div>
	</div>
    </body>
</html>
