<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.*"%>
<%@page import="eHotel.connections.PostgreSqlConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rental Page</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ch-cn">
</head>
<script>
	function setSelectedBooking(bookingId){
		var selectedBooking = document.getElementById("selectedBooking");
		selectedBooking.value = bookingId;
		return true;
	}
	
	function setSelectedAvailRoom(roomId){
		var selectedRoom = document.getElementById("selectedAvailRoom");
		selectedRoom.value = roomId;
		return true;
	}
</script>
<body>
	<%
		PostgreSqlConn conn = new PostgreSqlConn();
		
		int empId = (Integer) request.getAttribute("empId");
		Employee emp = conn.getEmployeeFromID(empId);
		String empFirstName = emp.getFirstName();
		String empLastName = emp.getLastName();
	%>
	<h2>Welcome, <%=empFirstName%> <%=empLastName%>!</h2>
	
	<h3>Bookings:</h3>
	<form method="post" action=roomRent>
		<input type="hidden" id="selectedBooking" name="selectedBooking" value="" />
		<input type="hidden" id="empId" name="empId" value="<%=empId%>" />
		<table>
			<tr>
				<th>Booking ID</th>
				<th>Customer ID</th>
				<th>Room ID</th>
				<th>Booking Date</th>
				<th>Check-In Date</th>
				<th>Check-Out Date</th>
				<th>Number of Occupants</th>
				<th>Brand ID</th>
				<th>Rent</th>
			</tr>
			<%
			Object bookingsObj = request.getAttribute("bookings");
			ArrayList<Booking> bookings = null;
			if (bookingsObj instanceof ArrayList) {
				bookings = (ArrayList<Booking>) bookingsObj;
			}
			else {
				bookings = new ArrayList<Booking>();
			}
			int count = 0;
			for (Booking booking : bookings) {
			%>
			<tr>
				<td>
					<%=booking.getBookingID()%>
				</td>
				<td>
					<%=booking.getCustomerID()%>
				</td>
				<td>
					<%=booking.getRoomID()%>
				</td>
				<td>
					<%=booking.getBookingDate()%>
				</td>
				<td>
					<%=booking.getCheckInDate()%>
				</td>
				<td>
					<%=booking.getCheckOutDate()%>
				</td>
				<td>
					<%=booking.getNumberOfOccupants()%>
				</td>
				<td>
					<%=booking.getBrandId()%>
				</td>
				<td>
					<Button type="submit" id="booking<%=count%>" onclick="setSelectedBooking('<%=booking.getBookingID()%>');" value="<%=booking.getBookingID()%>">Rent</Button>
				</td>
			</tr>
			<%
				count++;
			}
			%>
		</table>
	</form>
		
	
	<h3>Available Rooms:</h3>
	<form method="post" action=roomBookRent>
		<input type="hidden" id="selectedAvailRoom" name="selectedAvailRoom" value="" />
		<input type="hidden" id="empId" name="empId" value="<%=empId%>" />
		<table>
			<tr>
				<th>Room Number</th>
				<th>Hotel</th>
				<th>Capacity</th>
				<th>Extendible</th>
				<th>Sea View</th>
				<th>Mountain View</th>
				<th>Price</th>
				<th>Book & Rent</th>
			</tr>
			<%
			Object availRooms = request.getAttribute("availRooms");
			ArrayList<Room> availRoomsList = null;
			if (availRooms instanceof ArrayList) {
				availRoomsList = (ArrayList<Room>) availRooms;
			}
			else {
				availRoomsList = new ArrayList<Room>();
			}
			int count2 = 0;
			for (Room room : availRoomsList) {
			%>
			<tr>
				<td>
					<%=room.getRoomName()%>
				</td>
				<td>
					<%=room.getHotelID()%>
				</td>
				<td>
					<%=room.getCapacity()%>
				</td>
				<td>
					<%=room.getIsExtendible()%>
				</td>
				<td>
					<%=room.getIsSeaView()%>
				</td>
				<td>
					<%=room.getIsMountainView()%>
				</td>
				<td>
					<%=room.getPrice()%>
				</td>
				<td>
					<Button type="submit" id="availRoom<%=count2%>" onclick="setSelectedAvailRoom('<%=room.getRoomID()%>');" value="<%=room.getRoomID()%>">Book & Rent</Button>
				</td>
			</tr>
			<%
				count2++;
			}
			%>
		</table>
	</form>
</body>
</html>
