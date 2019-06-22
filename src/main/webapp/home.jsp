<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color:white">Ag Project</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">CROPS<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="home.jsp">Create Crop</a></li>
						<li><a href="home.jsp">Crop Details</a></li>
					</ul></li>
				<li><a href="home.jsp"><span></span>ACTIVITIES</a></li>
				<li><a href="InputEntry"><span></span>INPUT ENTRY</a></li>
				<li><a href="InputHistory"><span></span>INPUT HISTORY</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" style="color:white"><span
						class="glyphicon glyphicon-user"></span><%=((String)session.getAttribute("uname")).toUpperCase()%></a></li>
				<li><a href="LogoutServlet"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</div>
	</nav>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>

</html>