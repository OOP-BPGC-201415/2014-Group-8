<%-- 
    Document   : failure
    Created on : 22 Nov, 2014, 4:06:53 PM
    Author     : amit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Transaction failed !! Check if you have sufficient balance in your account</h1>
	<h2>Credit account : ${transaction.fromAccount.accountNumber}</h2>
	<h2>Debit account : ${transaction.toAccount.accountNumber}</h2>
	<h2>Amount : ${transaction.amount}</h2>
	<h2>Credit Account Balance : ${transaction.fromAccount.balance}</h2>
    </body>
</html>
