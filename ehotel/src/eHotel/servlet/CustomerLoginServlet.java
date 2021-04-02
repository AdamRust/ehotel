package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.*;

public class CustomerLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String username = req.getParameter("custAcc_Username");
		String pwd = req.getParameter("custAcc_Pwd");
		System.out.println("IN SERVLET");
		PostgreSqlConn conn = new PostgreSqlConn();
//		[0]:name,[1]:pwd
		// String pwdFromDB = conn.getPasswordByUsername(username);
		Account account = conn.getAccountFromUsername(username);
		System.out.println("IN SERVLET 2");
		if (pwd.equals(account.getPassword())) {
			Customer cust = conn.getCustomerFromUsername(username);
			
			ArrayList<Room> bookedRooms = conn.getBookedRoomsForCustomer(cust.getCustomerID());
			ArrayList<Room> allRooms = conn.getAllAvailRooms();
			
			req.setAttribute("custFirstName", cust.getFirstName());
			req.setAttribute("custLastName", cust.getLastName());
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);
			
			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}