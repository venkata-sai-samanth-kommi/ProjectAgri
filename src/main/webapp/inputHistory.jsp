<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>inputs taken</title>
</head>
<body onload="InputHistory">
<jsp:include page="home.jsp"/>
<%String result[][] = (String[][])request.getAttribute("result"); %>
<div class="container">
  <h2>Input Details</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>SNO</th>
        <th>NAME OF INPUT</th>
        <th>QUANTITY</th>
        <th>PRICE PER PIECE</th>
        <th>TOTAL</th>
      </tr>
    </thead>
    <tbody>
 	<%for(int i=0;i<result.length;i++){ %>
 	<tr>
 	<td><%=i %></td>
 	<td><%=result[i][0]%></td>
 	<td><%=result[i][1]%></td>
 	<td><%=result[i][2]%></td>
 	<td><%=result[i][3]%></td>
 	</tr>
 	<%} %>
    </tbody>
  </table>
</div>
</body>
</html>