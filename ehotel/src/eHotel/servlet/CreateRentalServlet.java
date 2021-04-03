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

public class CreateRentalServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		int bookingId = Integer.parseInt(req.getParameter("bookingId"));
		int empId = Integer.parseInt(req.getParameter("empId"));
		String creditCardName = req.getParameter("creditCardName");
		String creditCardNumber = req.getParameter("creditCardNumber");
		String creditCardCvv = req.getParameter("creditCardCvv");
		LocalDate rentalDate = LocalDate.now();
		String creditCardExpiryDateStr = req.getParameter("creditCardExpiryDate");
		LocalDate creditCardExpiryDate;
		try {
			creditCardExpiryDate = LocalDate.parse(creditCardExpiryDateStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: Make this handle the exception more appropriately.
			creditCardExpiryDate = LocalDate.now();
		}
		
		PostgreSqlConn conn = new PostgreSqlConn();
		
		int rentalID = conn.createRental(rentalDate, bookingId, creditCardName, creditCardNumber, creditCardCvv, creditCardExpiryDate);
		
		if (rentalID != -1) {
			
			ArrayList<Booking> bookings = conn.getAllBookings();
			ArrayList<Room> availRooms = conn.getAllAvailRooms();
			
			req.setAttribute("empId", empId);
			req.setAttribute("bookings", bookings);
			req.setAttribute("availRooms", availRooms);

			req.getRequestDispatcher("rental.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}
