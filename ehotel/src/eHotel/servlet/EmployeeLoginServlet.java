package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Account;
import eHotel.entities.Employee;

public class EmployeeLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String username = req.getParameter("empAcc_Username");
		String pwd = req.getParameter("empAcc_Pwd");
		
		PostgreSqlConn conn = new PostgreSqlConn();
		Account account = conn.getAccountFromUsername(username);
		
		if (pwd.equals(account.getPassword())) {		
			Employee emp = conn.getEmployeeFromUsername(username);
			System.out.println("success");
			req.setAttribute("empFirstName", emp.getFirstName());
			req.setAttribute("empLastName", emp.getLastName());
			req.getRequestDispatcher("login_success.jsp").forward(req, resp);
			// resp.sendRedirect("login_success.jsp?empFirstName="+username+"empLastName="+empLastName);
			return;			
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}