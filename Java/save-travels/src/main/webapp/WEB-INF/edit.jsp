<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>
	<h1>Edit Expenses</h1>
	<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense" class="form">
	<input type="hidden" name="_method" value="put"/>
			<div>
				<form:label path="expenseName">Expense Name </form:label>
				<form:input type="text" path="expenseName" class="form-control" />
				<form:errors path="expenseName" />
			</div>
			<div>
				<form:label path="vendor"> Vendor </form:label>
				<form:input type="text" path="vendor" class="form-control"/>
				<form:errors path="vendor" />
			</div>
			<div>
				<form:label path="amount"> Amount </form:label>
				<form:input type="text" path="amount" class="form-control"/>
				<form:errors path="amount" />
			</div>
			<div>
				<form:label path="description"> Description </form:label>
				<form:input type="text" path="description" class="form-control"/>
				<form:errors path="description" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

</body>
</html>