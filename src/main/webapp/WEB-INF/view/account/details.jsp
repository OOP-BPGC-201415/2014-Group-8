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
        <h1>Account Details For ${account.accountNumber}</h1>

	<div class="row">
	    <div class="col-md-6">
		<form accept-charset="UTF-8" role="form" method="GET" action="<c:url value="/account/search"/>">
		    <div class="input-group">
			<input class="form-control" placeholder="Account Number" name="accountNumber" type="text" autofocus="true" autocomplete="true" value="${accountNumber}"/>
			<span class="input-group-btn">
			    <button class="btn btn-primary">
				<span class="fa fa-search fa-fw fa-lg"></span>
				Search
			    </button>
			</span>
		    </div>
		</form>
	    </div>
	</div>

	<br>
	
<!--	<div class="row">
	    <div class="col-md-8">
		<div class="list-group">
		    <c:forEach items="${accounts}" var="account">
		    <a class="list-group-item" href="/account/${account.id}/transaction">
			<h4 class="list-group-item-heading">${account.accountNumber}</h4>
			<p class="list-group-item-text">${account.client.username}</p>
		    </a>
		    </c:forEach>
		</div>
	    </div>
	</div>-->
    </body>
</html>
