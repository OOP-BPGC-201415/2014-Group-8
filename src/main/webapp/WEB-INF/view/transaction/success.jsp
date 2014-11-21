<%-- 
    Document   : success
    Created on : 21 Nov, 2014, 1:17:44 AM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction details</title>
    </head>
    <body>
        <h1>Transaction completed successfully</h1>
	<h2>Credit account : ${transaction.fromAccount.accountNumber}</h2>
	<h2>Debit account : ${transaction.toAccount.accountNumber}</h2>
	<h2>Amount : ${transaction.amount}</h2>
    </body>
</html>
