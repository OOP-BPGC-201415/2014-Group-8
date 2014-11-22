<%-- 
    Document   : approval
    Created on : 15 Nov, 2014, 7:12:31 PM
    Author     : amit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approval</title>
    </head>
    <body>
	<div class="row">
	    <div class="col-md-3"></div>
	    <div class="col-md-8">
		<h1 class="page-header">${username} submitted for approval</h1>
	    </div>
	</div>

	<br>
	<br>
	<br>

	<div class="row">
	    <div class="col-md-5"></div>
	    <div class="col-md-1">
		<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/login"/>">
		    <br>
		    <button type="submit" value="view" class="btn btn-primary btn-sm">Login Page</button>
		</form>
	    </div>
	</div>
    </body>
</html>
