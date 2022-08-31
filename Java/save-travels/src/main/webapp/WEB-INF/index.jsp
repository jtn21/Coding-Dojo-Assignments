<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expenses</title>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1>Save Travels</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th colspan="2"> Actions </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachExpense" items="${expenseList }">
					<tr>
						<td><a href="/expenses/${eachExpense.id}"> ${eachExpense.expenseName }</a></td>
						<td>${eachExpense.vendor }</td>
						<td>${eachExpense.amount }</td>
						<td><a href="/expenses/edit/${eachExpense.id }">Edit</a></td>
						<td>
							<form action="/expenses/${eachExpense.id }" method="post">
								<input type="hidden" name="_method" value="delete" />
							<button type="submit">Delete</button>
							</form>
							
					</tr>
				</c:forEach>

			</tbody>
		</table>


		<form:form action="/expenses" method="post" modelAttribute="expense" class="form">
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


	</div>

</body>
</html>