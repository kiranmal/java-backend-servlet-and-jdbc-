<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Login Page</h1>
	
	<form action="userLogin" method="get">
	<label>UserEmail: </label><br>
	<input type="email" placeholder="enter your email please" name="useremail"><br>
	
	<label>UserPassword: </label>
	<input type="password" placeholder="enter your password please" name="userpassword"><br>
	
	<input type="submit" value="Login">
	</form>

</body>
</html>