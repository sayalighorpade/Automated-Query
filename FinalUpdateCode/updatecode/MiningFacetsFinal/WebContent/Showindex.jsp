<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML>
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

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>

<script type="text/javascript" src="jsnew/jquery-1.9.1.min.js"></script>
 <script src="jsnew/highcharts.js"></script>
<script>
    <%        
    Connection con=Dbconn.conn();
    ArrayList arr1=new ArrayList();
     ArrayList arr2=new ArrayList();
      ArrayList arr3=new ArrayList();
      int filelength=0;
      String searchword=(String)session.getAttribute("Query");
 Statement st;
 ResultSet rs;
 String sql="select * from countcluster where searchword='"+searchword+"' order by clustercount desc ";
 st=con.createStatement();
 rs=st.executeQuery(sql);
 int vcstime=0,tfidftime=0;
 String vcs=null ,tfidf=null; 
 while(rs.next())
 {
	 
	  arr1.add("Url_"+rs.getString(2));  
     arr2.add(rs.getInt(3)); 
   
 		
 }
 
String  arr11=arr1.toString().replace("[", "").replace("]", "")
    .replace(", ", "','");//x
 String  arr22=arr2.toString().replace("[", "").replace("]", "")
    .replace(", ", ",");//y
    %>
    
    
    $(function () {
        $('#containerg').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Calculation Cluster'
            },
            subtitle: {
               
            },
            xAxis: {
            	 title: {
                     text: 'Url Link Number Name'
                 },
            	categories: ['<%=arr11%>']
                
            },
            yAxis: {
            	 title: {
                     text: 'Cluster Count Number'
                 },
                              
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: '<b>{point.y:1f}no</b>'
            },
            series: [{
            	name: 'Time(S)',
                data: [<%=arr22%>],
                dataLabels: {
                    enabled: false,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    format: '{point.y:.1f}', // one decimal
                    y: 10, // 10 pixels down from the top
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            }]
        });
    });
</script>
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
    	
        <div id="templatemo_content" align="center" style="width: 100%">
        
            
            
         
            <div class="content_box_wrapper" align="center">
            	<div class="content_box">
                
                	<div class="post_section" align="center">
            
                       <h3 style="right: auto;"><a href="">Welcome to UserName:- <%=session.getAttribute("username")%></a></h3>
        
                   <div id="containerg" style="min-width: 900px; height: 500px; max-width: 350px; margin: 0 auto"></div>

				</div>  
                        
                    </div>
                
                </div> <!-- end of content_box -->
            </div> <!-- end of content_box_wrapper -->
        
        </div> <!-- end of templatemo_content -->
       
        
        <div class="cleaner"></div>    
   
    
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

<div align=center></div></body>
</html>



