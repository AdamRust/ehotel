package eHotel.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.*;

public class CreateBookRentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String custUsername = req.getParameter("custUsername");
		int roomId = Integer.parseInt(req.getParameter("roomId"));
		int numberOfOccupants = Integer.parseInt(req.getParameter("numOfOccupants"));
		String creditCardName = req.getParameter("creditCardName");
		String creditCardNumber = req.getParameter("creditCardNumber");
		String creditCardCvv = req.getParameter("creditCardCvv");
		LocalDate rentalDate = LocalDate.now();
		LocalDate bookingDate = LocalDate.now();
		String creditCardExpiryDateStr = req.getParameter("creditCardExpiryDate");
		String checkInDateStr = req.getParameter("checkInDate");
		String checkOutDateStr = req.getParameter("checkOutDate");
		LocalDate creditCardExpiryDate;
		LocalDate checkInDate;
		LocalDate checkOutDate;
		try {
			creditCardExpiryDate = LocalDate.parse(creditCardExpiryDateStr);
			checkInDate = LocalDate.parse(checkInDateStr);
			checkOutDate = LocalDate.parse(checkOutDateStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: Make this handle the exception more appropriately.
			creditCardExpiryDate = LocalDate.now();
			checkInDate = LocalDate.now();
			checkOutDate = LocalDate.now();
		}
		String empFirstName = req.getParameter("empFirstName");
		String empLastName = req.getParameter("empLastName");
		
		PostgreSqlConn conn = new PostgreSqlConn();
		Customer customer = conn.getCustomerFromUsername(custUsername);
		Room room = conn.getRoomFromID(roomId);
		Hotel hotel = conn.getHotelFromID(room.getHotelID());
		int bookingID = conn.createBooking(customer.getCustomerID(), roomId, bookingDate, checkInDate, checkOutDate, numberOfOccupants, hotel.getBrandID());
		int rentalID = conn.createRental(rentalDate, bookingID, creditCardName, creditCardNumber, creditCardCvv, creditCardExpiryDate);
		
		if (bookingID != -1) {
			
			ArrayList<Booking> bookings = conn.getAllBookings();
			ArrayList<Room> availRooms = conn.getAllAvailRooms();
			
			req.setAttribute("empFirstName", empFirstName);
			req.setAttribute("empLastName", empLastName);
			req.setAttribute("bookings", bookings);
			req.setAttribute("availRooms", availRooms);

			req.getRequestDispatcher("rental.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}
