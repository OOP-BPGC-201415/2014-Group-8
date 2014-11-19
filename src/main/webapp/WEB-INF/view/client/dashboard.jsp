<%-- 
    Document   : dashboard
    Created on : 18 Nov, 2014, 4:27:42 PM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </body>
</html>
