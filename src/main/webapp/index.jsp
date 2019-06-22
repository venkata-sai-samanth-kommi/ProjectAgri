
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>admin login</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>projectagri</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color:white">Ag Project&nbsp;&nbsp;|&nbsp;&nbsp;Admin</a>
			</div>
		</div>
	</nav>
	<div class="container" >
		<form action="AdminLogin" method="post">
			<div class="form-group">
				<label for="fid">Admin ID :</label> <input type="text"
					class="form-control" id="aid" placeholder="Enter Admins's ID"
					name="aid" required />
			</div>
			<div class="form-group">
				<label for="fid">Password :</label> <input type="password"
					class="form-control" id="password" placeholder="Enter Password"
					name="password" required />
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	
</body>
</html>