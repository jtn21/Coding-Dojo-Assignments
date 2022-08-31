<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">

</head>
<body>
	<h1> JSTL DEMO</h1>
	<h1> Displaying Variables</h1>
	<p> <c:out value="${ jspName }"/> </p>
	<p> ${jspAge } </p>
	
	<h1> If-statement</h1>
	
	<c:if test="${jspIsHungry}">
		<p> ${jspName } is hungry </p>
	</c:if>

	<h1> If-else statement</h1>
	<c:choose>
		<c:when test="${jspAge <21 }">
			<p> He is underage </p>
		</c:when>
		<c:otherwise>
			<p> He is over 21</p>
		</c:otherwise>
	</c:choose>
	
	<h1> for each</h1>
	<ul>
	<c:forEach var="eachUser" items="${jspUsers }">
	 	<li> <c:out value="${eachUser }"/> </li>
	</c:forEach>

	</ul>
	
	<h1> Styling test</h1>
	<p class="styleTest"> testing styling</p>
	<p style="color: red">testing red</p>
	
	 
</body>
</html>