<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Details</h1>
<h3>Expense: <c:out value="${oneExpense.expenseName }"/></h3>
<h3>Vendor: <c:out value="${oneExpense.vendor }"/></h3>
<h3>Amount: <c:out value="${oneExpense.amount }"/></h3>
<h3>Description: <c:out value="${oneExpense.description }"/></h3>
<h4><a href="/expenses">Go back</a></h4>
</body>
</html>