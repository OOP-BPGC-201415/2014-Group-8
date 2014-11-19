<%-- 
    Document   : dashboard
    Created on : 18 Nov, 2014, 4:27:42 PM
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
	    <div class="col-md-1"></div>
	    <div class="col-md-4">
		<h1>Welcome ${client.username}</h1>
		<h2>Active accounts: ${client.accounts.size()}</h2>
	    </div>
	    <div class="col-md-2"></div>
	    <div class="col-md-4">
		<h1>Total Balance: Rs ${balance}/-</h1>
	    </div>
	</div>

	<div class="row">
	    <div class="col-md-2"></div>
	    <div class="col-md-8">
		<table class="table table-striped table-bordered">
		    <tr>
			<th>Account Number</th>
			<th>Balance(Rs.)</th>
			<th>Debit Transactions</th>
			<th>Credit Transactions</th>
			<th>View Details</th>
		    </tr>
		    <tbody>
			<c:forEach items="${client.accounts}" var="account">
			    <tr>
				<td><c:out value="${account.accountNumber}"/></td>
				<td><c:out value="${account.balance}"/></td>
				<td><c:out value="${account.toTransactions.size()}"/></td>
				<td><c:out value="${account.fromTransactions.size()}"/></td>
				<td>
				    <form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/account/${account.id}"/>">
					<button type="submit" value="view" class="btn btn-primary btn-sm">
					    <span class="glyphicon glyphicon-eye-open"></span>  View Account
					</button>
				    </form>
				</td>
			    </tr>
			</c:forEach>
		    </tbody>
		</table>
	    </div>
	</div>
    </body>
</html>
