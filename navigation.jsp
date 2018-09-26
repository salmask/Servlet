<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails</title></head>
  <% 
String taskdet=request.getParameter("task"); 
  session.setAttribute("sname",taskdet); 
%> 
<form action="View" method="post">
<table align="center">
<tr><td>User Name</td><td><input type="text" name="user1"></input></td></tr>
<tr><td>Password</td><td><input type="password" name="ps1"></input></td></tr>
<tr><td><input type="submit" ></td></tr>
</table>
 </form>


<body>

</body>
</html>