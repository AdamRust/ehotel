package eHotel.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;

public class CreateBookingServlet  extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		int custId = Integer.parseInt(req.getParameter("custId"));
		int roomId = Integer.parseInt(req.getParameter("roomId"));
		int numOfOccupants = Integer.parseInt(req.getParameter("numOfOccupants"));
		LocalDate bookingDate = LocalDate.now();
		String checkInDateStr = req.getParameter("checkInDate");
		String checkOutDateStr = req.getParameter("checkOutDate");
		LocalDate checkInDate;
		LocalDate checkOutDate;
		try {
			checkInDate = LocalDate.parse(checkInDateStr);
			checkOutDate = LocalDate.parse(checkOutDateStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: Make this handle the exception more appropriately.
			checkInDate = LocalDate.now();
			checkOutDate = LocalDate.now();
		}
		
		
		PostgreSqlConn conn = new PostgreSqlConn();
		
		int bookingID = conn.createBooking(custId, roomId, bookingDate, checkInDate, checkOutDate, numOfOccupants);
		
		if (bookingID != -1) {
			
			ArrayList<Room> bookedRooms = conn.getBookedRoomsForCustomer(custId);
			
			ArrayList<Room> allRooms = conn.getAllAvailRooms();
			
			req.setAttribute("custId", custId);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}
