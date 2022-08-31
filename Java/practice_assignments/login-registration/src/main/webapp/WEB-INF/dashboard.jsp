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
<H1>HELLO:  ${user.userName} </H1>
<h3><a href="/logout">Logout</a></h3>
<a href="/books/add">Add a book</a>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="eachBook" items="${bookList }">
			<tr>
				<td>${eachBook.id }</td>
				<td><a href="/books/${eachBook.id }">${eachBook.bookTitle }</a></td>
				<td>${eachBook.author }</td>
				<td>${eachBook.user.userName }</td>
				<td><a href="/books/edit/${eachBook.id }">Edit</a></td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>
</body>
</html>