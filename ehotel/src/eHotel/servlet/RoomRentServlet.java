package eHotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.*;

public class RoomRentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int bookingId = Integer.parseInt(req.getParameter("selectedBooking"));
		int empId = Integer.parseInt(req.getParameter("empId"));
		String empLastName = req.getParameter("empLastName");
		
		PostgreSqlConn conn = new PostgreSqlConn();
		
		Booking booking = conn.getBookingFromID(bookingId);
		
		if (bookingId != -1) {
			req.setAttribute("bookingId", bookingId);
			req.setAttribute("roomId", booking.getRoomID());
			req.setAttribute("empId", empId);
			req.getRequestDispatcher("create_rental.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}
