<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h4>User Update Form</h4>
	<form action="userUpdate" method="get">
	<label>USERID:</label>
	<input type="text" name="userid" value="123"><br>
	
	
	<label>USERNAME:</label>
	<input type="text" name="username" value="abc"><br>
	
	<label>USEREMAIL:</label><br>
	<input type="email"  name="useremail"><br>
	<label>USERPASSWORD:</label><br>
	<input type="password" name="userpassword"><br>
	<label>USERDOB:</label><br>
	<input type="date" name="userdob"><br>
	<label>USERGENDER:</label><br>
	<input type="radio" name="usergender" value="MALE">MALE
	<input type="radio" name="usergender" value="FEMALE">FEMALE<br>
	<input type="submit" value="register">
	</form>
</body>
</html>