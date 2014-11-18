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
        <h1>Hello dashboard</h1>
	<p>currently viewing ${client.username} user</p>
    </body>
</html>
