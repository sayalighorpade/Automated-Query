package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("txtName"), 
				address = request.getParameter("txtaddress"), 
				gender = request.getParameter("rdoGender"),
				emailid = request.getParameter("txtEmail"),
				mobileno = request.getParameter("txtContact"),
				password = request.getParameter("pwd");

		try {
			Connection con;
			PreparedStatement pt;
			con = Dbconn.conn();

			String qury = "select * from register where emailid='" + emailid
					+ "'";

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(qury);
			String uname;

			if (rs.next()) {
				uname = rs.getString("name");
				if (uname.toLowerCase().contains(name.toLowerCase())) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('User Name  Already Exists');");
					out.println("</script>");
					RequestDispatcher rd = request
							.getRequestDispatcher("/RegisterPage.jsp");
					rd.include(request, response);
				}
				
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Email Id Already Exists');");
					out.println("</script>");
					RequestDispatcher rd = request
							.getRequestDispatcher("/RegisterPage.jsp");
					rd.include(request, response);
				
				
			} else {

				String query = "INSERT INTO register (name,contactno,gender,emailid,city,password) values (?,?,?,?,?,?)";
				pt = con.prepareStatement(query);
				pt.setString(1, name);
				pt.setString(2, mobileno);
				pt.setString(3, gender);
				pt.setString(4, emailid);
				pt.setString(5, address);

				pt.setString(6, password);
				pt.executeUpdate();

				HttpSession session = request.getSession(true);
				session.setAttribute("username", name);
				session.setAttribute("emailid", emailid);

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Register Successfully');");
				out.println("</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/HomePage.jsp");
				rd.include(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
