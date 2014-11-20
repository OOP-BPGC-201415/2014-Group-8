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
				    <button value="view" class="btn btn-primary btn-sm">
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
