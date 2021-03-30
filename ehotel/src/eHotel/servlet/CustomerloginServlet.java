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

public class CustomerloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		
		PostgreSqlConn conn = new PostgreSqlConn();
//		[0]:name,[1]:pwd
		// String pwdFromDB = conn.getPasswordByUsername(username);
		Account account = conn.getAccountFromUsername(username);
		
		if (pwd.equals(account.getPassword())) {
			Customer cust = conn.getCustomerFromAccountID(account.getAccountID());
			
			ArrayList<Room> bookedRooms = conn.getBookedRoomsForCustomer(cust.getCustomerID());
			ArrayList<Room> allRooms = conn.getAllAvailRooms();
			
			req.setAttribute("CustName", cust.getFirstName());
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}