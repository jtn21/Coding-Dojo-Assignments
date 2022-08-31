<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book</title>
</head>
<body>
	<h1>Add a book</h1>
	<a href="/books">Back</a>
	<form:form method="post" action="/books/add" modelAttribute="book">
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
		<form:hidden path="user" value="${userId }" />
		<button type="submit">Submit</button>

	</form:form>

</body>
</html>