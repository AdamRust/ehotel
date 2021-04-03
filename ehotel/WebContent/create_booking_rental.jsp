<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.*"%>
<%@page import="eHotel.connections.PostgreSqlConn"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking and Rental Page</title>
<script>
	function validate(){
		var check_in_date = document.getElementById("checkInDate");
		var check_out_date = document.getElementById("checkOutDate");
		var numOfOccupants = document.getElementById("numOfOccupants");
		if(check_in_date.value == ""){
			alert("Check In Date is required.");
			return false;
		} else if(check_out_date.value ==""){
			alert("Check Out Date is required.");
			return false;
		} else if(numOfOccupants.value ==""){
			alert("Number of Occupants is required.");
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
		String empFirstName = (String) request.getAttribute("empFirstName");
		String empLastName = (String) request.getAttribute("empLastName");
		Room room = conn.getRoomFromID(roomId);
	%>
	<h2>Booking room <%=room.getRoomName()%> for $<%=room.getPrice()%>!</h2>
	
	<form method="post" action=createBookingRental>
		<input type="hidden" id="roomId" name="roomId" value="<%=roomId%>" />
		<input type="hidden" id="empFirstName" name="empFirstName" value="<%=empFirstName%>" />
		<input type="hidden" id="empLastName" name="empLastName" value="<%=empLastName%>" />
		<section>
			<p>
				<label for="custUsername">
					<span>Customer Username: </span>
				</label>
				<input type="text" id="custUsername" name="custUsername">
			</p>
			<p>
				<label for="numOfOccupants">
					<span>Number of Occupants: </span>
				</label>
				<input type="text" id="numOfOccupants" name="numOfOccupants">
			</p>
			<p>
				<label for="checkInDate">
					<span>Check-In Date: </span>
				</label>
				<input type="date" id="checkInDate" name="checkInDate" value="2021-04-01" min="2021-01-01" max="2022-01-01">
				
			</p>
			<p>
				<label for="checkOutDate">
					<span>Check-Out Date: </span>
				</label>
				<input type="date" id="checkOutDate" name="checkOutDate" value="2021-04-01" min="2021-01-01" max="2022-01-01">
			</p>
		</section>
		<section>
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