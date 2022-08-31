<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<h1>Book Details</h1>
	<h2>Title: ${book.bookTitle }</h2>
	<h2>Author: ${book.author }</h2>
	<h2>Thoughts: ${book.thoughts }</h2>
	<a href="/books/edit/${book.id }">Edit</a>
	<a href="/books">Back</a>
</body>
</html>