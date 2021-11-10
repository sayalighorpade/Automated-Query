<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Automatically Mining Facets for Queries from Their Search Results</title>
<meta name="keywords" content="press blog theme, free css template, blogger, templatemo" />
<meta name="description" content="Press Theme - Free Blog Template for everyone" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link href="css/svwp_style.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript">
function checkPwd()
{
 var pwd1=document.f1.pwd.value;
 if(pwd1.length<=3){
 t5.innerHTML="Week";
 t5.style.color="red";
 document.f1.pwd.focus();
 }
 else if(pwd1.length<=6)
{
	 t5.innerHTML="Good";
	 t5.style.color="darkorange";
	 //document.f1.pwd.focus();
}
 else if(pwd1.length<=8)
 {
 	 t5.innerHTML="Strong";
 	 t5.style.color="green";
 	 //document.f1.pwd.focus();
 }
 else if(pwd1.length<=10)
 {
 	 t5.innerHTML="Very Strong";
 	 t5.style.color="darkgreen";
 	 //document.f1.pwd.focus();
 }
}

</script>
</head>
<body>

	
	<div id="templatemo_header_wrapper">
	<div id="templatemo_header">
    
    	<div id="site_title">
            <h1><a href="" target="_parent">Automatically Mining Facets for Queries from Their Search Results</a></h1>
      	</div> <!-- end of site_title -->
        
        <div id="templatemo_menu">
            <ul>
                <li class="current_page_item"><a href="RegisterPage.jsp">Register Page</a></li>
			<li><a href="LoginPage.jsp">Login Page</a></li>
			</ul>    	
        </div> <!-- end of templatemo_menu -->
    
    </div>
</div> <!-- end of templatemo_header -->

	<div id="templatemo_middle_wrapper">
	<div id="templatemo_middle" align="center">
    	<center>
        <div id="templatemo_content" align="center" style="width: 100%">
        
            
            
         
            <div class="content_box_wrapper" align="center">
            	<div class="content_box">
                
                	<div class="post_section" align="center">
        
				
				<form name="f1" id="f1" action="RegisterPage" method="post">

			<table  style="font-family: monotype corsiva;font-size: 25px;font-weight: bold;height:250px; width:100%" cellspacing="5" cellpadding="5"   >
			
				<tr>
				
					<td>Name:</td>
					<td>
					<input type="text" pattern="[a-zA-z\\s]*"  required name="txtName" style="height: 30px;width: 240px" data-validation-required-message="Please enter your name." maxlength="6" />
					</td>
					
				</tr>
				<tr>
				
					<td>Mobile No:</td>
					<td>
<input type="text" maxlength="10" pattern="[7-9]{1}[0-9]{9}" name="txtContact" style="height: 30px;width: 240px" required title="Not a valid Phone Number" />
					</td>
					
				</tr>
				<tr>
				
					<td>Gender:</td>

					<td align=left style="font-size: 20px;"><input type="radio"
						name="rdoGender" required value="Male" id="male" />Male <input
						type="radio" required name="rdoGender" value="FeMale" id="female" />Female</td>
										</tr>
				
				<tr>
				
		
					<td>Email:</td>
					<td><input type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
						name="txtEmail" style="height: 30px;width: 240px" required />
					</td>
					
				</tr>
				<tr>
				
					<td>City:</td>
				
					<td >
					<input type="text" required name="txtaddress" style="height: 30px;width: 240px;" maxlength="6" />
					
					</td>
					
				</tr>
				
				<tr>
				
					<td>Password:</td>
					
					<td >
					
					<input type="password" name="pwd" id="pwd" onblur="checkPwd()" class="style5" style="height: 30px;width: 240px;" required maxlength="10" />
		
					<label id="t5"></label>
					</td>
					
				</tr>
				<tr>

					<td colspan="3" align="center"><input 
						type="submit"  name="action" value="Register" style="font-family: monotype corsiva;font-size: 20px;font-weight: bold" />
					
					</td>
					
				</tr>

			</table>
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

<div align=center></div></body>
</html>



