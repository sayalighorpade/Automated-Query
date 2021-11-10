package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailid,pwd,Username;
		PrintWriter out=response.getWriter();
		emailid=request.getParameter("txtEmail");
        pwd=request.getParameter("txtpass");
		try 
		{
			Connection con;
			con=Dbconn.conn();
			String qury="select * from register where emailid='"+emailid+"' and password='"+pwd+"'";
			 Statement stm=con.createStatement();
	           ResultSet rs=stm.executeQuery(qury);
			
			if(rs.next())
			{
				Username=rs.getString(1);
				HttpSession session=request.getSession(true);
				session.setAttribute("username",Username);
				session.setAttribute("emailid", emailid);
				
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Login Successfully');");  
				out.println("</script>");    
				RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
				rd.include(request, response);
		}
			else {
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Login Fail Try Again');");  
				out.println("</script>");    
				request.getRequestDispatcher("/LoginPage.jsp").include(request, response);
				//msg="Login Fail Try Again";
				
			}	           
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
