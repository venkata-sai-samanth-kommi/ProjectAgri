<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="farmerIndex.jsp"/>
<h2 align="center">Account Creation Successfull Please Login!</h2>
<br>
<br>
<h2 align="center">**Remember your account number for future reference.</h2>
<br>
<br>
<h1 align="center">Account number <%=request.getAttribute("ac") %></h1>
</body>
</html>