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
import eHotel.entities.*;

public class CustomerRegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		PostgreSqlConn conn = new PostgreSqlConn();
		
		// Customer info
		String custFirstName = req.getParameter("custFirstName");
		String custMidInit = req.getParameter("custMidInit");
		String custLastName = req.getParameter("custLastName");
		String custSin = req.getParameter("custSin");
		Date currDate = new Date(); // Get current date
		java.sql.Date custRegDate = new java.sql.Date(currDate.getTime()); // Set registration date to current date
		// Account info
		String custAcc_Username = req.getParameter("custAcc_Username");
		String custAcc_Pwd = req.getParameter("custAcc_Pwd");
		int custAcc_Role = 3; // Customer role = 3
		//Address info
		String custAddr_StreetName = req.getParameter("custAddr_Street");
		String custAddr_StreetNum = req.getParameter("custAddr_StreetNum");
		String custAddr_UnitNum = req.getParameter("custAddr_UnitNum");
		String custAddr_PostalCode = req.getParameter("custAddr_PostalCode");
		String custAddr_City = req.getParameter("custAddr_City");
		String custAddr_State = req.getParameter("custAddr_State");
		String custAddr_Country = req.getParameter("custAddr_Country");
		
		try {
			int newCustID = conn.createNewCustomer(custFirstName, custMidInit, custLastName, custSin, custRegDate, 
					custAcc_Username, custAcc_Pwd, custAcc_Role, custAddr_StreetName, custAddr_StreetNum, custAddr_UnitNum,
					custAddr_PostalCode, custAddr_City, custAddr_State, custAddr_Country);
			
			ArrayList<Room> bookedRooms = conn.getBookedRoomsForCustomer(newCustID);
			
			ArrayList<Room> allRooms = conn.getAllAvailRooms();
			
			req.setAttribute("custId", newCustID);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resp.sendRedirect("register_failure.jsp");
		}
		
		return;
	}
	

}
