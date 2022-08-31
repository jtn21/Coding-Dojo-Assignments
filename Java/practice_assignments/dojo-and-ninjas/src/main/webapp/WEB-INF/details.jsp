<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${eachNinja.firstName }" /></td>
					<td><c:out value="${eachNinja.lastName }" /></td>
					<td><c:out value="${eachNinja.age }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">Go Back</a>
</body>
</html>