<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userregistration" method="get">
	<label>User Id:</label>
	<input type= "text" placeholder ="enter user id" name="userid"><br>
	<label>User Name:</label>
	<input type= "text" placeholder ="enter name" name="username"><br>
	<label>User Email:</label>
	<input type= "text" placeholder ="enter email" name="useremail"><br>
	<label>User Password:</label>
	<input type= "text" placeholder ="enter password" name="userpassword"><br>
	<label>User DOB:</label>
	<input type= "date"  name="userdob"><br>
	<label>User Gender:</label>
	<input type= "radio" name="usergender" value="female">FeMale
	<input type= "radio" name="usergender" value="male">Male
	<br>
	<input type="submit" value="registration">
	</form>
	
</body>
</html>  

