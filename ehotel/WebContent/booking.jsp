<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.*"%>
<%@page import="eHotel.connections.PostgreSqlConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
<script>
	function setSelectedRoom(roomId){
		var selectedRoom = document.getElementById('selectedRoom');
		selectedRoom.value = roomId;
		return true;
	}
</script>
</head>
<body>
	<%
		PostgreSqlConn conn = new PostgreSqlConn();
		
		int custId = (Integer) request.getAttribute("custId");
		Customer cust = conn.getCustomerFromID(custId);
		String custFirstName = cust.getFirstName();
		String custLastName = cust.getLastName();
	%>
	<h2>Welcome, <%=custFirstName%> <%=custLastName%>!</h2>
	
	<h3>You're booked rooms:</h3>
	<table>
		<tr>
			<th>Room Number</th>
			<th>Hotel</th>
			<th>Capacity</th>
			<th>Extendible</th>
			<th>Sea View</th>
			<th>Mountain View</th>
			<th>Price</th>
		</tr>
		<%
		Object bookedRooms = request.getAttribute("bookedRooms");
		ArrayList<Room> bRoomsList = null;
		if (bookedRooms instanceof ArrayList) {
			bRoomsList = (ArrayList<Room>) bookedRooms;
		}
		else {
			bRoomsList = new ArrayList<Room>();
		}
		for (Room room : bRoomsList) {
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
		</tr>
		<%
		}
		%>
	</table>
	
	<h3>Available rooms:</h3>
	<form method="post" action=roombook>
		<input type="hidden" id="custId" name="custId" value="<%=custId%>" />
		<input type="hidden" id="selectedRoom" name="selectedRoom" value="" />
		<table>
			<tr>
				<th>Room Number</th>
				<th>Hotel</th>
				<th>Capacity</th>
				<th>Extendible</th>
				<th>Sea View</th>
				<th>Mountain View</th>
				<th>Price</th>
				<th>Book</th>
			</tr>
			<%
			Object availRooms = request.getAttribute("allRooms");
			ArrayList<Room> availRoomsList = null;
			if (bookedRooms instanceof ArrayList) {
				availRoomsList = (ArrayList<Room>) availRooms;
			}
			else {
				availRoomsList = new ArrayList<Room>();
			}
			int count = 0;
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
					<Button type="submit" id="availRoom<%=count%>" onclick="setSelectedRoom('<%=room.getRoomID()%>');" value="<%=room.getRoomID()%>">Book</Button>
				</td>
			</tr>
			<%
				count++;
			}
			%>
		</table>
	</form>
</body>
</html>