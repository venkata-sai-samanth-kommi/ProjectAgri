<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="commonheader.jsp" />
	<div class="container" id="registrationform">
		<h2>Farmer Registration Form</h2>
		<form action="SignUpServlet" method="post">
			<div class="form-group">
				<label for="name">Farmer Name :</label> <input type="text"
					class="form-control" id="name" placeholder="Enter Farmer's name"
					name="name" required />
			</div>
			<div class="form-group">
				<label for="mobile-number">Mobile Number :</label> <input
					type="text" class="form-control" id="mobile-number"
					placeholder="Enter Mobile Number" name="mobile-number">
			</div>
			<div class="form-group">
				<label for="acres">Number of Acres of Land :</label> <input
					type="text" class="form-control" id="acres"
					placeholder="Enter Number of Acres of Land" name="acres">
			</div>
			<div class="form-group">
				<label for="pincode">Pincode :</label> <input type="text"
					class="form-control" id="pincode" placeholder="Enter Your Pincode"
					name="pincode">
			</div>
			<div class="form-group">
				<label for="location">Location :</label>
				<!--we can add a list of available locations in future-->
				<input type="text" class="form-control" id="location"
					placeholder="Enter Location" name="location">
			</div>
			<button type="submit" class="btn btn-primary">Sign Up</button>
		</form>
	</div>
</body>
</html>