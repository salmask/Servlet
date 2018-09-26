<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select task</title>
</head>
<body>
<h1 align="center">SELECT THE TASK YOU WANT TO PERFORM</h1>
<form action="navigation.jsp" method="post">
<table align="center">
<tr><td>View Data</td><td><input type="radio" name="task" value="see"></td></tr>
<tr><td> Delete Data  </td><td><input type="radio" name="task" value="delete"></td></tr>
 <tr><td>Update Data</td><td>  <input type="radio" name="task" value="update"></td></tr>
   
 <tr><td><input type="submit"></td></tr>
 </table>
 </form>
 
</body>
</html>