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
        <div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<h1 class="page-header"> Transaction Window</h1>
	    </div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<div class="list-group">
		    <c:forEach items="${accounts}" var="acc">
			<h3 class="list-group-item-heading">Account Number : <b>${acc.accountNumber}</b></h3>
			<h4 class="list-group-item-heading">Client : <b>${acc.client.username}</b></h4>
			<br>
			<button type="button" value="view" class="btn btn-success btn-sm" data-toggle="modal" data-otherAcc="${acc}" data-target="#fromModal">
			    <span class="glyphicon glyphicon-plus-sign"></span>  Credit From Account
			</button>
			<button type="button" value="view" class="btn btn-danger btn-sm" data-toggle="modal" data-otherAcc="${acc}" data-target="#toModal">
			    <span class="glyphicon glyphicon-plus-sign"></span>  Debit to Account
			</button>
			<br>
		    </c:forEach>
		</div>
	    </div>
	</div>

    </body>
</html>


<!-- modal dialog for transferring to other account from this account-->
<div class="modal fade" id="toModal" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
	<div class="modal-content">
	    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Transfer from ${account.accountNumber} to ${accounts.get(0).accountNumber}</h4>
	    </div>
	    <form accept-charset="UTF-8" role="form" method="POST" action="<c:url value="/transaction/credit"/>">
		<div class="modal-body">
		    <label>Enter Amount(Rs.)</label>
		    <input class="form-control" placeholder="Amount" name="balance" type="text" autofocus="true" autocomplete="true" value="">
		    <input class="form-control" name="account" type="hidden" value="${account.id}">
		    <input class="form-control" name="acc" type="hidden" value="${accounts.get(0).id}">
		</div>
		<div class="modal-footer">

		    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		    <button type="submit" class="btn btn-danger">Deposit</button>
		</div>
	    </form>
	</div>
    </div>
</div>

<!-- modal dialog for transferring from other account to this account-->
<div class="modal fade" id="fromModal" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
	<div class="modal-content">
	    <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Transfer from ${accounts.get(0).accountNumber} to ${account.accountNumber}</h4>
	    </div>
	    <form accept-charset="UTF-8" role="form" method="POST" action="<c:url value="/transaction/debit"/>">
		<div class="modal-body">
		    <label>Enter Amount(Rs.)</label>
		    <input class="form-control" placeholder="Amount" name="balance" type="text" autofocus="true" autocomplete="true" value="">
		    <label>Enter Account Pin</label>
		    <input class="form-control" placeholder="pin" name="pin" type="password" autofocus="true" autocomplete="true" value="">
		    <input class="form-control" name="account" type="hidden" value="${account.id}">
		    <input class="form-control" name="acc" type="hidden" value="${accounts.get(0).id}">

		</div>
		<div class="modal-footer">
		    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		    <button type="submit" class="btn btn-success">Withdraw</button>
		</div>
	    </form>
	</div>
    </div>
</div>
