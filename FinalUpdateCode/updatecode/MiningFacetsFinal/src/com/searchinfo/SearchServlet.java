package com.searchinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.print("Search Word:="+request.getParameter("u"));
		
//newmasterclass masterclass=new newmasterclass();
//		newmasterclass.master(request.getParameter("u"));
//		
//		RequestDispatcher rd=request.getRequestDispatcher("/displayRelevantURL.jsp");
//		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session=request.getSession(false);
		PrintWriter out= response.getWriter();
		newmasterclass.dataurl.clear();
		newmasterclass.finaldata.clear();
		newmasterclass.datalist.clear();
		//TestGoogleSea1.finalurllist.clear();
		newmasterclass.toplist.clear();
		newmasterclass.topindex.clear();
		TestGoogleSea1.URLans.clear();
		
		String uname=(String)Session.getAttribute("username");
		newmasterclass.cslist.clear();
		String word=request.getParameter("txtUsername");
		Session.setAttribute("Query", request.getParameter("txtUsername"));
		String no=newmasterclass.master(word.toString(),uname);
		if(no.equals("0"))
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Already Search Word ');");  
			out.println("</script>");  
			Session.setAttribute("Query1", request.getParameter("txtUsername"));
			RequestDispatcher rd=request.getRequestDispatcher("/displayhistory.jsp");
			rd.include(request, response);
		}
		else
		{
		RequestDispatcher rd=request.getRequestDispatcher("/displayRelevantURL.jsp");
		rd.include(request, response);
		}
		
		
	}

}
