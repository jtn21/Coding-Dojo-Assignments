<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Project Details</h1>
		<a href="/projects">Home</a>
		<a href="/projects/edit/${project.id }">Edit</a>
		<h3> Project: <c:out value="${project.title }"/> </h3>
		<h3> Description: <c:out value="${project.description }"/> </h3>
		<h3> Teamlead: <c:out value="${project.user.firstName }"/> </h3>
		<h3> Due Date: <fmt:formatDate type="date"  value="${project.dueDate }"/> </h3>
	</div>

</body>
</html>