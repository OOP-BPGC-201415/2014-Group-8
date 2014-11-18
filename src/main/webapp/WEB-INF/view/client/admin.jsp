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
		<th>Add account</th>
	    </tr>
	    <tbody>
		<c:forEach items="${clients}" var="client">
		    <tr>
			<td><c:out value="${client.username}"/></td>
			<td><c:out value="${client.accounts.size()}"/></td>
			<td>
			    <a href="#myModal">
				<span class="glyphicon glyphicon-plus"></span>
			    </a>
			</td>
		    </tr>
		</c:forEach>
	    </tbody>
	</table>

    </body>
</html>
