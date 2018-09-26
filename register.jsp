<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body bgcolor="skyblue">
<h1 align="CENTER">REGISTER HERE</h1>
<form  action="RegisterNow" method="post">

<table align="center">
<tr><td>first name:</td><td> <input type="text" name="fname"></td></tr>
<tr><td>last name: </td><td><input type="text" name="lname"></td></tr>


<tr><td>username: </td><td><input type="text" name="uname"></td></tr>

<tr><td>gender</td><td>female<input type="radio" name="gen" value ="female"></td>
<td>male<input type="radio" name="gen" value="male"></td></tr>
<tr><td>UID </td><td><input type="text" name="uid"><tr><td>
<tr><td>email id: </td><td><input type="text" name="emailid"></td></tr>
<tr><td>mobile number:</td><td> <input type="text" name="mobno"></td></tr>

<tr><td>address: </td><td><textarea rows="5" cols="5" name="address"></textarea></td></tr>

<tr><td>password: </td><td><input type="password" name="password1"></td></tr>
<tr><td>Reenter the password:</td><td> <input type="password" name="password2"></td></tr>


<tr><td><input type="submit"></td></tr>

</table>
</form>


</body>
</html>