<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>
	<jsp:include page="home.jsp" />
	<div class="container" id="registrationform">
		<h2>Input Entry Form</h2>
		<form action="EnterInputHistory" method="post">
			<div class="form-group">
				<label for="name">Name Of Input :</label> <input type="text"
					class="form-control" id="nameofinput"
					placeholder="Enter Input Name1" name="nameofinput" required />
			</div>
			<div class="form-group">
				<label for="price">Price :</label> <input type="text"
					 class="form-control" id="price"
					placeholder="Enter Price" name="price">
			</div>
			<div class="form-group">
				<label for="quantity">Quantity :</label> <input type="text"
					 class="form-control" id="quantity"
					placeholder="Enter Quantity" name="quantity">
			</div>
			<div class="form-group">
				<label for="Total">Total :</label>
				<input type="text" class="form-control" id="total" name="total"
				readonly/>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
	<script>
	$("#price,#quantity").on(
		focus : function() {
		$('#total').val($('#price').val() * $('#quantity').val());
		},
		keyup : function() {
		$('#total').val($('#price').val() * $('#quantity').val());
		}
		);
</script>
</body>
</html>
