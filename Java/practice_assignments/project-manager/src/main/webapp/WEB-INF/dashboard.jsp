<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h1>HELLO THERE ${user.firstName} </h1>
<h3><a href="/logout">Logout</a></h3>
<h3><a href="/projects/add">Add a new project</a></h3>


<table>
	<thead>
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="eachProject" items="${projectList }">
			<tr>
				<td><a href="/projects/${eachProject.id }">${eachProject.title }</a></td>
				<td> <c:out value="${eachProject.user.firstName}"/> </td>
				<td> <c:out value="${eachProject.dueDate}"/> </td>
				<td><a href="/projects/edit/${eachProject.id }">Edit</a></td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>





</body>
</html>