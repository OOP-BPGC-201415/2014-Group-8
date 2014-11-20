<%-- 
    Document   : transaction
    Created on : 20 Nov, 2014, 7:48:17 PM
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
        <h1>Use account ${account.accountNumber} for transfers</h1>

	<div class="row">
	    <div class="col-md-2"></div>
	    <div class="col-md-6">
		<div class="list-group">
		    <c:forEach items="${accounts}" var="acc">
			<h3 class="list-group-item-heading">Account Number : <b>${acc.accountNumber}</b></h3>
			<h4 class="list-group-item-heading">Client : <b>${acc.client.username}</b></h4>
			<button type="button" value="view" class="btn btn-primary btn-sm" data-toggle="modal" data-id="${account.accountNumber}" data-target="#toModal">
			    <span class="glyphicon glyphicon-plus-sign"></span>  Credit From Account
			</button>
			<button type="button" value="view" class="btn btn-primary btn-sm" data-toggle="modal" data-id="${account.accountNumber}" data-target="#fromModal">
			    <span class="glyphicon glyphicon-plus-sign"></span>  Debit to Account
			</button>
<!--			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/client/${client.id}/dashboard"/>">
			    <button type="submit" value="Add Account" class="btn btn-primary btn-xs">
				<span class="glyphicon glyphicon-eye-close"></span> View Details
			    </button>
			</form>-->
			<br>
		    </c:forEach>
		</div>
	    </div>
	</div>

    </body>
</html>


<div class="modal fade" id="toModal" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
	<div class="modal-content">
	    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Enter Amount to add to ${account.accountNumber}</h4>
	    </div>
	    <div class="modal-body">
		<label>Enter Amount(Rs.)</label>
		<form>
		    <input class="form-control" placeholder="Amount" name="balance" type="text" autofocus="true" autocomplete="true" value="">
		</form>
	    </div>
	    <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		<button type="button" class="btn btn-primary">Save changes</button>
	    </div>
	</div>
    </div>
</div>

<div class="modal fade" id="fromModal" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
	<div class="modal-content">
	    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Enter Amount to add to ${account.accountNumber}</h4>
	    </div>
	    <div class="modal-body">
		<label>Enter Amount(Rs.)</label>
		<form>
		    <input class="form-control" placeholder="Amount" name="balance" type="text" autofocus="true" autocomplete="true" value="">
		</form>
	    </div>
	    <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		<button type="button" class="btn btn-primary">Save changes</button>
	    </div>
	</div>
    </div>
</div>
