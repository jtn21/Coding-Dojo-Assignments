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
<h1>Home.jsp</h1>
<h1> <c:out value="${name}" /></h1>
<h1>Two plus two is: </h1>
<h2><c:out value="${2+2}"/></h2>
</body>
</html>