<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.*"%>
<%@page import="eHotel.connections.PostgreSqlConn"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rental Page</title>
<script>
	function validate(){
		var creditCardName = document.getElementById("creditCardName");
		var creditCardNumber = document.getElementById("creditCardNumber");
		var creditCardCvv = document.getElementById("creditCardCvv");
		var creditCardExpiryDate = document.getElementById("creditCardExpiryDate");
		if(creditCardName.value == ""){
			alert("Name is required.");
			return false;
		} else if(creditCardNumber.value ==""){
			alert("Card Number is required.");
			return false;
		} else if(creditCardCvv.value ==""){
			alert("CVV is required.");
			return false;
		}else if(creditCardExpiryDate.value ==""){
			alert("Expiry Date is required.");
			return false;
		} else
			return true;
	}
</script>
</head>
<body>
	<%
		PostgreSqlConn conn = new PostgreSqlConn();
		int roomId = (Integer) request.getAttribute("roomId");
		int bookingId = (Integer) request.getAttribute("bookingId");
		int empId = (Integer) request.getAttribute("empId");
		Room room = conn.getRoomFromID(roomId);
	%>
	<h2>Booking room <%=room.getRoomName()%> for $<%=room.getPrice()%>!</h2>
	
	<form method="post" action=createRental>
		<section>
			<input type="hidden" id="bookingId" name="bookingId" value="<%=bookingId%>" />
			<input type="hidden" id="empId" name="empId" value="<%=empId%>" />
			<p>
				<label for="creditCardName">
					<span>Name on Card: </span>
				</label>
				<input type="text" id="creditCardName" name="creditCardName">
			</p>
			<p>
				<label for="creditCardNumber">
					<span>Credit Card Number: </span>
				</label>
				<input type="text" id="creditCardNumber" name="creditCardNumber">
			</p>
			<p>
				<label for="creditCardCvv">
					<span>CVV: </span>
				</label>
				<input type="text" id="creditCardCvv" name="creditCardCvv">
			</p>
			<p>
				<label for="creditCardExpiryDate">
					<span>Expiry Date: </span>
				</label>
				<input type="date" id="creditCardExpiryDate" name="creditCardExpiryDate" value="2021-04-01" min="2021-01-01" max="2022-01-01">
			</p>
		</section>
		<section>
			<p>
				<button type="submit" value="submit" onclick="return validate();">Submit</button>
				<button type="reset" value="reset">Reset</button>
			</p>
		</section>
	</form>
</body>