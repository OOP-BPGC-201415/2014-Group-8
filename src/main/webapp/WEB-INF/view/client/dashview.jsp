<%-- 
    Document   : dashview
    Created on : 20 Nov, 2014, 10:29:22 AM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Dashboard</title>
    </head>
    <body>
        <div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-4">
		<h1 class="page-header">User Account of ${client.username}
		    <h2>Active accounts: ${client.accounts.size()}</h2>
		</h1>
	    </div>
	    <div class="col-md-2"></div>
	    <div class="col-md-4">
		<h1>Total Balance: Rs ${balance}/-</h1>
	    </div>
	</div>
	<br>
	<br>
	<br>
	<div class="row">
	    <div class="col-md-2"></div>
	    <div class="col-md-8">
		<h4>Transaction Accounts</h4>
		<table class="table table-striped table-bordered">
		    <tr>
			<th>Account Number</th>
			<th>Balance(Rs.)</th>
			<th>Debit Transactions</th>
			<th>Credit Transactions</th>
			<th>Add Balance</th>
			<th>Deactivate</th>
		    </tr>
		    <tbody>
			<c:forEach items="${client.accounts}" var="account">
			    <tr>
				<td><c:out value="${account.accountNumber}"/></td>
				<td><c:out value="${account.balance}"/></td>
				<td><c:out value="${account.toTransactions.size()}"/></td>
				<td><c:out value="${account.fromTransactions.size()}"/></td>
				<td>
				    <button type="button" value="view" class="btn btn-primary btn-sm" data-toggle="modal" data-id="${account.accountNumber}" data-target="#modal">
					<span class="glyphicon glyphicon-plus-sign"></span>  Add Balance
				    </button>
				</td>
				<td>
				    <button value="view" class="btn btn-primary btn-sm">
					<span class="glyphicon glyphicon-eye-open"></span>  Deactivate Account
				    </button>
				</td>
			    </tr>
			</c:forEach>
		    </tbody>
		</table>
	    </div>
	</div>
    </body>
</html>


<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="#myModalLabel" aria-hidden="true">
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
