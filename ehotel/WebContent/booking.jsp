<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
</head>
<body>

	<%
		String custFirstName = (String) request.getAttribute("custFirstName");
		String custLastName = (String) request.getAttribute("custLastName");
	%>
	<h2>Welcome, <%=custFirstName%> <%=custLastName%>!</h2>
	<form method="post" action="roombook">
			<h3>Here are the room(s) you booked</h3>
			<ul>
				<%
					Object obj1 = request.getAttribute("bookedRooms");
					ArrayList<Room> broomList = null;
					if (obj1 instanceof ArrayList) {
						broomList = (ArrayList<Room>) obj1;
					}
					if (broomList != null) {
						for (Room room : broomList) {
							String roominfo = room.getRoomID() + "---" + room.getHotelID();
				%>
							<li><%=roominfo%></li>
				<%
						}
					}
				%>
			</ul>
			
			<h3>Here are avaiable rooms</h3>
			<select name = "roomno">
				<%
					Object obj = request.getAttribute("allRooms");
					ArrayList<Room> roomList = null;
					if (obj instanceof ArrayList) {
						roomList = (ArrayList<Room>) obj;
					}
					if (roomList != null) {
						for (Room room : roomList) {
							String roominfo = room.getRoomID() + "---" + room.getHotelID();
				%>					
				<option><%=room.getRoomID()%></option>

				<%
					}
					}
				%>
			</select>
			<button type="submit" onclick="return confirm('book?');">book</button>
	</form>


</body>
</html>