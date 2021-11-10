<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<style type="text/css">

li.sub ul {
display:none;
position: absolute; left: 100%; top:0;}

li.sub:hover ul{
display: block;}
</style>
</head>
<body>
<h1>Simple Pure CSS Drop Down Menu</h1>
<nav id="primary_nav_wrap">

<ul>
  <li class="current-menu-item"><a href="#">Home</a></li>
  <li class="current-menu-item"><a href="#">Search</a></li>
  <li class="current-menu-item"><a href="#">Ranking</a></li>
  <li class="current-menu-item"><a href="#">Calculation Time</a></li>
  <li class="current-menu-item"><a href="#">RankingGraph</a></li>
  
  <li><a href="#">Jitu</a>
    <ul>
      <li><a href="#">Sub Menu 1</a></li>
      <li><a href="#">Sub Menu 2</a></li>
      <li><a href="#">Sub Menu 3</a></li>
        <li><a href="#">Sub Menu 5</a></li>
    </ul>
  </li>
  
</ul>
</nav>
</body>
</html>