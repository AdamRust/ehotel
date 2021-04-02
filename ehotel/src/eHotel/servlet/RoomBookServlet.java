package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
import eHotel.entities.Employee;

public class RoomBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		int custID = Integer.parseInt(req.getParameter("custID"));
		int roomID = Integer.parseInt(req.getParameter("roomID"));
		// String hotelID = req.getParameter("hotelID");
		int numOfOccupants = Integer.parseInt(req.getParameter("numOfOccupants"));
		Date currDate = new Date();
		java.sql.Date bookingDate = new java.sql.Date(currDate.getTime());
		java.sql.Date checkInDate = new java.sql.Date(Date.parse(req.getParameter("checkInDate")));
		java.sql.Date checkOutDate = new java.sql.Date(Date.parse(req.getParameter("checkOutDate")));
		
		PostgreSqlConn conn = new PostgreSqlConn();
		
		// String userSSN = conn.bookRoom(custName, roomID);
		int bookingID = conn.createBooking(custID, roomID, bookingDate, checkInDate, checkOutDate, numOfOccupants);
		
//		[0]:name,[1]:pwd
//		String[] pwdfromdb = con.getuserinforbycustSSN(userSSN);
//		
//		
//		
		if (bookingID != -1) {			
			
			ArrayList<Room> bookedRooms = conn.getBookedRoomsForCustomer(custID);
			
			ArrayList<Room> allRooms = conn.getAllAvailRooms();
			
			
			req.setAttribute("custID", custID);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}