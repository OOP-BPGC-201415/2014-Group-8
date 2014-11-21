<%-- 
    Document   : signup
    Created on : 15 Nov, 2014, 6:54:14 PM
    Author     : amit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body>
        <div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<h1 class="page-header">Signup for Ewallet Account
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
		<form accept-charset="UTF-8" name="client" role="form" method="POST" action="<c:url value="/approval"/>">
		    <fieldset>
			<div class="form-group">
			    <label>Username</label>
			    <input class="form-control" placeholder="Username" name="username" type="text" autofocus="true" autocomplete="true" value="${client.username}">
			</div>
			<div class="form-group">
			    <label>Password</label>
			    <input class="form-control" placeholder="Password" name="password" type="password" value="${client.password}">
			</div>

			<div class="form-group">
			    <label class="col-lg-3 control-label">Client Type</label>
			    <div class="col-lg-10">
				<div class="radio">
				    <label>
					<input name="type" id="client" value="${client.type}" checked="" type="radio">
					Client
				    </label>
				</div>
				<div class="radio">
				    <label>
					<input name="type" id="merchant" value="${client.type}" type="radio">
					Merchant
				    </label>
				</div>
			    </div>
			</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Signup">
		    </fieldset>
		</form>
	    </div>
	</div>
    </body>
</html>
