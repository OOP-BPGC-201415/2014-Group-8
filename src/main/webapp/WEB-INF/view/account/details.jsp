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
			<input class="form-control" name="accountId" type="hidden" value="${account.id}">
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
    </body>
</html>
