<%-- 
    Document   : details
    Created on : 19 Nov, 2014, 6:38:36 PM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Details</title>
    </head>
    <body>
	<div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<h1 class="page-header">Account Transactions</h1>
	    </div>
	</div>

	<br>
	<br>

	<div class="row">
	    <div class="col-md-4"></div>
	    <div class="col-md-4">
		<div class="panel panel-primary">
		    <div class="panel-heading">
			<h3 class="panel-title">Account Details</h3>
		    </div>
		    <div class="panel-body">
			<p>Account Number : ${account.accountNumber}</p>
			<p>Client Name : ${account.client.username}</p>
			<p>Current Balance : ${account.balance}</p>
		    </div>
		</div>
	    </div>
	</div>

	<br>
	<br>

	<!--	<div class="row">
		    <div class="col-md-4"></div>
		    <div class="col-md-4">
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/account/search"/>">
			    <div class="input-group">
				<input class="form-control" placeholder="Account Number" name="accountNumber" type="text" autofocus="true" autocomplete="true" value="${accountNumber}"/>
				<input class="form-control" name="accountId" type="hidden" value="${account.id}">
				<span class="input-group-btn">
				    <button class="btn btn-primary">
					<span class="fa fa-search fa-fw fa-lg"></span>
					Make Transaction
				    </button>
				</span>
			    </div>
			</form>
		    </div>
		</div>-->

	<br>
	<br>

	<br>
	<br>
	<br>

	<div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-5">
		<div class="panel panel-default">
		    <div class="panel-heading">
			<h3 class="panel-title">Credit From Account</h3>
		    </div>
		    <div class="panel-body">
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/account/search"/>">
			    <div class="input-group">
				<input class="form-control" placeholder="Account Number" name="accountNumber" type="text" autofocus="true" autocomplete="true" value="${accountNumber}"/>
				<br>
				<input class="form-control" name="accountId" type="hidden" value="${account.id}">
				<br>
				<input class="form-control" name="amount" type="text" placeholder="Amount">
				<br>
				<br>
				<input class="form-control" name="pin" type="password" placeholder="Secret Pin">
				<br>
				<br>
				<input class="btn btn-success btn-block" type="submit" value="Make Transaction">
			    </div>
			</form>
		    </div>
		</div>

		<br>
		<br>
		<br>

		<div class="panel panel-success">
		    <div class="panel-heading">
			<h3 class="panel-title">Debit Transactions</h3>
		    </div>
		    <div class="panel-body">
			<table class="table table-striped table-bordered">
			    <tr>
				<th>Account Number</th>
				<th>Amount</th>
				<th>Date</th>
			    </tr>
			    <tbody>
				<c:forEach items="${account.toTransactions}" var="transaction">
				    <tr>
					<td><c:out value="${transaction.fromAccount.accountNumber}"/></td>
					<td><c:out value="${transaction.amount}"/></td>
					<td><c:out value="${transaction.transactionDate}"/></td>
				    </tr>
				</c:forEach>
			    </tbody>
			</table>
		    </div>
		</div>
	    </div>
	    <div class="col-md-5">
		<div class="panel panel-default">
		    <div class="panel-heading">
			<h3 class="panel-title">Debit To Account</h3>
		    </div>
		    <div class="panel-body">
			<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/account/search"/>">
			    <div class="input-group">
				<input class="form-control" placeholder="Account Number" name="accountNumber" type="text" autofocus="true" autocomplete="true" value="${accountNumber}"/>
				<br>
				<input class="form-control" name="accountId" type="hidden" value="${account.id}">
				<br>
				<input class="form-control" name="amount" type="text" placeholder="Amount">
				<br>
				<br>
				<input class="btn btn-danger btn-block" type="submit" value="Make Transaction">
			    </div>
			</form>
		    </div>
		</div>

		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="panel panel-danger">
		    <div class="panel-heading">
			<h3 class="panel-title">Credit Transactions</h3>
		    </div>
		    <div class="panel-body">
			<table class="table table-striped table-bordered">
			    <tr>
				<th>Account Number</th>
				<th>Amount</th>
				<th>Date</th>
			    </tr>
			    <tbody>
				<c:forEach items="${account.fromTransactions}" var="transaction">
				    <tr>
					<td><c:out value="${transaction.toAccount.accountNumber}"/></td>
					<td><c:out value="${transaction.amount}"/></td>
					<td><c:out value="${transaction.transactionDate}"/></td>
				    </tr>
				</c:forEach>
			    </tbody>
			</table>
		    </div>
		</div>
	    </div>

	</div>
    </body>
</html>
