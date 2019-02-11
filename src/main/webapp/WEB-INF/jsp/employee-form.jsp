<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>

<head>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

	<title>Save Employee</title>
</head>

<body>

	<div class="container">
	
		<h2 class="text-center font-weight-light">EMPLOYEES</h2>
		<hr>
		<p class="h4 mb-3">Save Employee</p>
		
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
		
		<form:hidden path="id" />
		
		<table>
				<tbody>
					<tr>
						<td>
							<form:input path="firstName" placeholder="First Name" />
							<form:errors path="firstName"  class="text-danger" />
						</td>
					</tr>
				
					<tr>
						<td>
							<form:input path="lastName" placeholder="Last Name" />
							<form:errors path="lastName" class="text-danger" />
						</td>
					</tr>
					
					<tr>
						<td>
							<form:input path="email" placeholder="Email" />
							<form:errors path="email" class="text-danger" />
						</td>
					</tr>
					
					<tr>
						<td>
							<form:input path="phoneNumber" placeholder="Phone Number" />
							<form:errors path="phoneNumber" class="text-danger" />
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="submit" value="Save" class="btn btn-success"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<hr>
		<a href="/employee/list" class="btn btn-outline-dark">Back to Employees List</a>
	</div>

</body>

</html>