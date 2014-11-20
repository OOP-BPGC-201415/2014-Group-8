<%-- 
    Document   : admin
    Created on : 14 Nov, 2014, 10:43:00 PM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello .. Logged in as admin!!</h1>
	<p>There are currently ${totalClients} users</p>
	<table class="table table-striped table-bordered">
	    <tr>
		<th>User Name</th>
		<th>User Accounts</th>
		<th>Add accounts</th>
	    </tr>
	    <tbody>
		<c:forEach items="${clients}" var="client">
		    <tr>
			<td><c:out value="${client.username}"/></td>
			<td><c:out value="${client.accounts.size()}"/></td>
			<td>
			    <form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/client/${client.id}/account"/>">
				<button type="submit" value="Add Account" class="btn btn-primary btn-lg">
				    <span class="glyphicon glyphicon-plus"></span>  Add Account
				</button>
			    </form>
			</td>
		    </tr>
		</c:forEach>
	    </tbody>
	</table>

	<div class="row">
	    <div class="col-md-2"></div>
	    <div class="col-md-6">
		<div class="list-group">
		    <c:forEach items="${clients}" var="client">
			<h3 class="list-group-item-heading">User : <b>${client.username}</b></h3>
			<h4 class="list-group-item-heading">Total Accounts : <b>${client.accounts.size()}</b></h4>
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/client/${client.id}/dashboard"/>">
			    <button type="submit" value="Add Account" class="btn btn-primary btn-xs">
				<span class="glyphicon glyphicon-eye-close"></span> View Details
			    </button>
			</form>
			<br>
		    </c:forEach>
		</div>
	    </div>
	</div>

	<div class="modal fade" id="accountmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
		<div class="modal-content">
		    <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">Modal New</h4>
		    </div>
		    <div class="modal-body">
		    </div>
		    <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		    </div>
		</div>
	    </div>
	</div>
    </body>
</html>
