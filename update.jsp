<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.PrintWriter"
     %>
     <%@page import="com.mysql.jdbc.Connection"
     %>
     <%@page import="java.sql.DriverManager"
     %>
     <%@page import="com.mysql.jdbc.PreparedStatement"
     %>
     <%@page import="java.sql.Statement"
     %>
     <%@ page import="java.sql.ResultSet" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update data</title></head>
<%

HttpSession ses=request.getSession();
String name=(String)session.getAttribute("user");
String name1=(String)session.getAttribute("pwd");
PrintWriter p=response.getWriter();
response.setContentType("text/html");  
String url="jdbc:mysql://10.11.1.113:3306";
String dbName="/testdb";
String driver="com.mysql.jdbc.Driver";
Class.forName(driver).newInstance();

Connection conn = (Connection) DriverManager.getConnection(url+dbName,"root", "root");
				String query="select * from registertable where uname=? and password1=?";
	PreparedStatement st=(PreparedStatement)conn.prepareStatement(query);
	
    st.setString(1, name);
    st.setString(2,name1);
    ResultSet r=(ResultSet) st.executeQuery();   

    if(r.next()) {
   			   
    p.print("<body><table align='center'><tr>First Name :"+r.getString(1));
    
    p.print("<br><br>Last Name :"+r.getString(2));
    
    p.println("<br><br>User Name :"+r.getString(3));
    p.println("<br><br>Gender :"+r.getString(4));
    p.println("<br><br>UID Number :"+r.getString(5));
    p.println("<br><br>Email ID :"+r.getString(6));
    p.println("<br><br>Mobile Number :"+r.getString(7));
    p.println("<br><br>Adress :"+r.getString(8));
    }

 %>
<form action="change" method="post">
<table align="center">

<tr><td>Changed email id: </td><td><input type="text" name="cemailid"></td></tr>
<tr><td>Changed mobile number:</td><td> <input type="text" name="cmobno"></td></tr>

<tr><td>Changed address: </td><td><textarea rows="5" cols="5" name="caddress"></textarea></td></tr>

<tr><td>Changed password: </td><td><input type="password" name="cpassword1"></td></tr>
<tr><td><input type="submit"></td></tr>
</table>
</form>

<body>

</body>
</html>