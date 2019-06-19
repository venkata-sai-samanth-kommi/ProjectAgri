<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Project Index</title>
</head>
<body>
	<jsp:include page="commonheader.jsp" />
	<div class="container">
		<h2>Farmer Login Form</h2>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="fid">Farmer ID :</label> <input type="text"
					class="form-control" id="fid" placeholder="Enter Farmer's ID"
					name="fid" required />
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>