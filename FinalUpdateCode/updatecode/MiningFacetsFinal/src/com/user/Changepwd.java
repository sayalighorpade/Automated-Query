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
 * Servlet implementation class Changepwd
 */
@WebServlet("/Changepwd")
public class Changepwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepwd() {
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
HttpSession session=request.getSession(false);
		
		PrintWriter out=response.getWriter();
		String Username=(String)session.getAttribute("username");
		String emailid=(String)session.getAttribute("emailid");
		
		System.out.println("User Name:="+Username);
		
		String oldpwd=request.getParameter("oldpwd");
		System.out.println("Current Password:="+oldpwd);
		String newpwd=request.getParameter("newpwd");
		System.out.println("New Password:="+newpwd);
		String Confirmpwd=request.getParameter("conpwd");
		System.out.println("Confirm New Password:="+Confirmpwd);
		
		try {
       	 
	        if(newpwd.equals(Confirmpwd))
	        {
        	Connection con = Dbconn.conn(); // connection to the database
        	Statement st=con.createStatement();
        	// queries the database
        	
        	String qry="select * from register where name='"+Username+"' and emailid='"+emailid+"'";
			ResultSet rs=st.executeQuery(qry);
			
			if(rs.next())
			{
				String Passdb=rs.getString("Password");
				System.out.println("Passdb"+Passdb);

				if(oldpwd.equals(Passdb))
				{
					String sql="update register set password='"+newpwd+"' where name='"+Username+"' and emailid='"+emailid+"'";
					int j=st.executeUpdate(sql);
					if(j!=0)
					{
						
						System.out.println("OK ");
						out.println("<script> alert('Password Changed Successfully');</script>"); 
						session.setAttribute("Email",emailid);
						RequestDispatcher rd=request.getRequestDispatcher("/HomePage.jsp");
						rd.include(request, response);
					}
					
				}
			else
				{
				out.println("<script> alert('Old Password is not Correct');</script>");
				request.getRequestDispatcher("/ChangePassword.jsp").include(request, response);
				}
				
				}
				
			else 
			{
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Connection Problem');");  
				out.println("</script>");    
				request.getRequestDispatcher("/ChangePassword.jsp").include(request, response);
			}
		
				
	        }//if New Password and confirm New Password 
	        else
	        {
	        	out.println("<script> alert(' New Password and confirm New Password not matched');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/ChangePassword.jsp");
				rd.include(request, response);

	        }
		}
		catch(Exception ex)
		{
			System.out.print(" "+ex);
		}
	}

}
