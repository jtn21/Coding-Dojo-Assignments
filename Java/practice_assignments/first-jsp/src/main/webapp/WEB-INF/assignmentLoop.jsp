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
	<h1>Assignment loop</h1>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Difficulty</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachAssignment" items="${assignmentList }">
				<tr>
					<td> ${eachAssignment.getTitle() }</td>
					<td> ${eachAssignment.difficulty }</td>
				</tr>
			
			
			</c:forEach>
		
		
		
		</tbody>
	</table>
</body>
</html>