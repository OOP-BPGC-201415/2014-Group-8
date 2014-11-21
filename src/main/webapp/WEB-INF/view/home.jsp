<%-- 
    Document   : home
    Created on : 14 Nov, 2014, 2:13:32 PM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EWallet Home</title>
    </head>
    <body>
        <div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-4">
		<h1 class="page-header">Welcome To BITS Ewallet
		    <h2>Virtual Banking System</h2>
		</h1>
	    </div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<div class="row">
		    <div class="col-md-4">
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/login"/>">
			    <button type="submit" class="btn btn-success btn-lg">Already Have Account</button>
			</form>
		    </div>
		    <div class="col-md-4"></div>
		    <div class="col-md-4">
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/signup"/>">
			    <button type="submit" class="btn btn-primary btn-lg">Create New Account</button>
			</form>
		    </div>
		</div>
	    </div>
	</div>
    </body>
</html>
