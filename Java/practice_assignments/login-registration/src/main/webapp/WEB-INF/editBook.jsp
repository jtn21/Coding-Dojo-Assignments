<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<h1>Edit book</h1>
	<a href="/books">Back</a>
	<form:form method="post" action="/books/edit/${book.id }"
		modelAttribute="book">
		<input type="hidden" name="_method" value="put" />
		<div>
			<form:label path="bookTitle"> Book Title </form:label>
			<form:input type="text" path="bookTitle" />
			<form:errors path="bookTitle" />
		</div>
		<div>
			<form:label path="author"> Author </form:label>
			<form:input type="text" path="author" />
			<form:errors path="author" />
		</div>
		<div>
			<form:label path="thoughts"> My Thoughts </form:label>
			<form:input type="text" path="thoughts" />
			<form:errors path="thoughts" />
		</div>
		<form:hidden path="user" value="${book.user.id }" />
		<button type="submit">Submit</button>
	</form:form>
	<form action="/books/${book.id }" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Delete</button>
	</form>


</body>
</html>


