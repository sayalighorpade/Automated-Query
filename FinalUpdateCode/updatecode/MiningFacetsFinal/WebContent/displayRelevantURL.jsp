<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.*"%>
<%@page import="java.sql.Connection"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Automatically Mining Facets for Queries from Their Search Results</title>
<meta name="keywords" content="press blog theme, free css template, blogger, templatemo" />
<meta name="description" content="Press Theme - Free Blog Template for everyone" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link href="css/svwp_style.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>

<!-- Optional plugins  -->
<script src="js/jquery.timers.js" type="text/javascript"></script>


</head>
<body>

<nav id="primary_nav_wrap">
<div id="templatemo_header_wrapper">
	<div id="templatemo_header">
    
    	<div id="site_title">
            <h1><a href="" target="_parent">Automatically Mining Facets for Queries from Their Search Results</a></h1>
      	</div> <!-- end of site_title -->
         
        <div id="templatemo_menu">
       
           <ul>
   <li ><a href="HomePage.jsp">Home</a></li>
			<li><a href="Search.jsp"><span>Search</span></a></li>
			<li><a href="RankingPage.jsp"><span>Ranking</span></a></li>
			
			<li><a href="#">Analysis</a>
    <ul>      
			<li><a href="Showgraph.jsp"><span>Calculation Time</span></a></li>
			<li><a href="Showindex.jsp"><span>RankingGraph</span></a></li>
			
    </ul>
  </li>
  
  <li><a href="#"><%=session.getAttribute("username")%></a>
    <ul>
      
			<li class="btn success"><a href="ChangePassword.jsp"><span>ChangePassword</span></a></li>
			<li><a href="logout">Logout</a></li>
			
    </ul>
  </li>
  
</ul>
				
        </div> <!-- end of templatemo_menu -->
      
    </div>
</div> <!-- end of templatemo_header -->
</nav>  
<div id="templatemo_middle_wrapper">
	<div id="templatemo_middle" align="center">
    	<center>
        <div id="templatemo_content" align="center" style="width: 100%">
        
            
            
         
            <div class="content_box_wrapper" align="center">
            	<div class="content_box">
                
                	<div class="post_section" align="center">
            
                       <h3 style="right: auto;"><a href="">Welcome to UserName:- <%=session.getAttribute("username")%></a></h3>
        
                   <form  action="LoginPage" method="post">
					 <h2>Search Results</h2>
					 <ceneter>
              <table align="center" style="width: 100%; margin-right: 55px">
              
                     <%
          Connection conn=Dbconn.conn();
					String searchword=(String)session.getAttribute("Query");
         
          Statement st3=conn.createStatement();
          
        
        	   
          
        	   ResultSet rs2 =st3.executeQuery("SELECT * from facetmaster where searchword like '%"+searchword+"%' order by clusterno desc");
        	   while(rs2.next())
        	   {
        		   %>
        		   <tr> 
        		     <td> 
        	  	<%-- <a style="font-size: 18px;" href="<%=rs2.getString("url") %>"> <%=rs2.getString("title") %></a> <br/> 
        	  --%>
        	  	<a style="font-style: italic; color:blue; font-size: 18px;" href="<%=rs2.getString("url") %>"> <%=rs2.getString("url") %></a> <br/> 
        	        	  <%
        	   }
          
          
          
          %>  
          </td>
          </tr>
          
              </table>  	
						
</ceneter>
            </form>    
                        
                    </div>
                
                </div> <!-- end of content_box -->
            </div> <!-- end of content_box_wrapper -->
        
        </div> <!-- end of templatemo_content -->
        </center>    
		
        
        <div class="cleaner"></div>    
    </div> <!-- end of templatemo_content -->
    
    <div id="templatemo_footer">
    
       
        
        <div class="col_w210">
             
 
        </div>
        
        <div class="col_w210">
            
        </div>
        
        <div class="col_w210 col_last">
           
        </div>
        
        
        <div class="cleaner"></div>
    </div> <!-- end of footer -->
    
    <div id="templatemo_copyright">
           </div>
    
</div> <!-- end of templatemo_content_wrapper -->

<div ></div></body>
</html>




