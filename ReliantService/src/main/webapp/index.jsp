
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Information</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success" style="width:40%">
			<div class="panel-heading">
				<h3 class="panel-title">Customer Details</h3>
			</div>
			<div class="panel-body" >
				<form action="registration" method="post">

					<div class="form-group">
						<div class="control-label">
							<label>First Name</label>
						</div>
						<div>

							<input cssClass="form-control" type="text" name="firstname" placeholder="First Name"
								required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label">
							<label>Last Name</label>
						</div>
						<div>
							<input cssClass="form-control" type="text" name="lastname"
								placeholder="Last Name" required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label">
							<label>Email</label>
						</div>
						<div>
							<input cssClass="form-control" type="email" name="email"
								placeholder="Email" required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label">
							<label>Telephone</label>
						</div>
						<div>
							<input cssClass="form-control" type="number" name="telephone"
								placeholder="Telephone" required />
						</div>
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Username</label>
						</div>
						<div>
							<input cssClass="form-control" type="text" name="username"
								placeholder="Username" required />
						</div>
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Password</label>
						</div>
						<div>
							<input cssClass="form-control" type="password" name="password"
								placeholder="Password" required />
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
							<div style="margin-left:30%">
								<button type="submit" name="register" value="register"
									id="saveCustomer" class="btn btn-primary">Register </button>
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>