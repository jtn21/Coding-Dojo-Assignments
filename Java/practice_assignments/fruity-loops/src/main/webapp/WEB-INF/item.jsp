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
	<h1>Fruit Store</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachItem" items="${fruits }">
				<tr>
					<td> ${eachItem.name }</td>
					<td> ${eachItem.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>