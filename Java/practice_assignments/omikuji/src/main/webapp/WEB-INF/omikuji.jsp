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
	<h1>Send on Omikuji!</h1>
	<form action="/omikuji/process" method="post">
		<div>
			Pick a number:
			<input type="number" name="number"/>	
		</div>
		<div>
			Enter the name of any city:
			<input type="text" name="city"/>
		</div>
		<div>
			Enter the name of any real person:
			<input type="text" name="person"/>
		</div>
		<div>
			Enter professional endeavor or hobby:
			<input type="text" name="hobby"/>
		</div>
		<div>
			Enter any type of living thing:
			<input type="text" name="livingThing"/>
		</div>
		<div>
			Say something nice to someone:
			
		</div>
			<textarea name="comments"> </textarea>
		<button type="submit">Send</button>
	
	</form>

</body>
</html>