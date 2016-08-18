
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
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Customer Details</h3>
			</div>
			<div class="panel-body">
				<form action="registration" method="post">

					<div class="form-group">
						<div class="control-label col-xs-3">
							<label>First Name</label>
						</div>
						<div class="col-xs-6">

							<input cssClass="form-control" type="text" name="firstname" placeholder="First Name"
								required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<label>Last Name</label>
						</div>
						<div class="col-xs-6">
							<input cssClass="form-control" type="text" name="lastname"
								placeholder="Last Name" required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<label>Email</label>
						</div>
						<div class="col-xs-6">
							<input cssClass="form-control" type="email" name="email"
								placeholder="Email" required />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<label>Telephone</label>
						</div>
						<div class="col-xs-6">
							<input cssClass="form-control" type="number" name="telephone"
								placeholder="Telephone" required />
						</div>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<button type="submit" name="register" value="register"
									id="saveCustomer" class="btn btn-primary">Register </button>
							</div>
							<div class="col-xs-4"></div>
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

	<script type="text/javascript">
		function submitCustomerForm() {

			// getting the employee form values
			var firstname = $('#firstname').val().trim();
			var age = $('#age').val();
			var salary = $('#salary').val();
			if (firstname.length > 12 && firstname.length < 8) {
				alert('Please enter valid name');
				$('#name').focus();
				return false;
			}

			if (age <= 0) {
				alert('Please enter proper age');
				$('#age').focus();
				return false;
			}

			if (salary <= 0) {
				alert('Please enter proper salary');
				$('#salary').focus();
				return false;
			}
			return true;
		};
	</script>

</body>
</html>