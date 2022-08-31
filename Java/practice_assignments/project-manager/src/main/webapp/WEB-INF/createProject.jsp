<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Project</title>
</head>
<body>
	<h1>Add a book</h1>
	<form:form method="post" action="/projects/add" modelAttribute="project">
		<div>
			<form:label path="title"> Project Title </form:label>
			<form:input type="text" path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="description">Description </form:label>
			<form:textarea path="description" rows="3"  cols="30" />
			<form:errors path="description" />
		</div>
		<div>
			<form:label path="dueDate"> Date </form:label>
			<form:input type="date" path="dueDate" />
			<form:errors path="dueDate" />
		</div>
		<form:hidden path="user" value="${userId }" />
		<button type="submit">Submit</button>

	</form:form>
	<a href="/projects">Back</a>
</body>
</html>