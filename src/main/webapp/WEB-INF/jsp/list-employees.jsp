<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<title>List of all employees</title>
</head>

<body>

	<h3 class="text-center font-weight-light">EMPLOYEES</h3>
	
	<div class="text-center">
		<i>REST services is available at *root*/magic/employees</i>
	</div>
	
	<hr>

	<div class="container">

		<a href="showFormForAddEmployee"
			class="btn btn-outline-success">Hire new</a> 
		
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempEmployee" items="${employees}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/employee/showFormForUpdateEmployee">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
				
					<tr>
						<td>${tempEmployee.id}</td>
						<td>${tempEmployee.firstName}</td>
						<td>${tempEmployee.lastName}</td>
						<td>${tempEmployee.email}</td>
						<td>${tempEmployee.phoneNumber}</td>
						
						<td>
						<!-- display the update link -->
						<a href="${updateLink}"
						   class="btn btn-info">Edit</a>
						|
						<a href="${deleteLink}"
						   class="btn btn-danger"
						   onclick="if (!(confirm('Are you sure you want to fire this employee?'))) return false">Fire</a>
						</td>
					</tr>
					
				</c:forEach>
			</tbody>

		</table>
	</div>
	
	<div class="text-center">
		<c:if test="${sessionScope.firedCount > 0}">
			<h4 class="font-weight-light">You fired ${sessionScope.firedCount} employee(s) today!</h4>
		</c:if>
	</div>
</body>

</html>