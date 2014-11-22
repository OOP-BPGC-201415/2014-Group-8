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
	    <div class="col-md-5"></div>
	    <div class="col-md-2">
		<button type="button" value="view" class="btn btn-default btn-sm" data-toggle="modal" data-target="#adminLogin">Login As Admin</button>
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

<div class="modal fade" id="adminLogin" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
	<div class="modal-content">
	    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Enter Login ID and Password</h4>
	    </div>
	    <form accept-charset="UTF-8" role="form" method="POST" action="<c:url value="/admin/login"/>">
		<div class="modal-body">
		    <label>User ID</label>
		    <input class="form-control" placeholder="Username" name="username" type="text" autofocus="true" autocomplete="true" value="">
		    <label>Password</label>
		    <input class="form-control" placeholder="Password" name="password" type="password" autofocus="true" autocomplete="true" value="">
		</div>
		<div class="modal-footer">
		    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		    <button type="submit" class="btn btn-success">Login</button>
		</div>
	    </form>
	</div>
    </div>
</div>
