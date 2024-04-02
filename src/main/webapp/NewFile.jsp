<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp Page</title>
<style >
img{
height:20%;
width:20%;
}
body{
text-align:center;
background:linear-gradient(to right,#2b40ff,#07121a);}
h1,h3{
color:white;
margin: 15px;}
input,button{
font-size:40px;
color:white;
border-radius:5%;
background-color: black;
border:2px solid yellow;}
img:hover{
-ms-transform:scale(1.1);
-webkit-transform:scale(1.1);
transform:scale(1.1);}
</style>
</head>
<body>
<img src="img\new pic.jpg">
<h1>Joke of the day</h1>
<h3>Joke=<%=request.getParameter("joke") %></h3>
<form action="MyServer">
<input name="num1" placeholder="FirstName"></input>
<input name="num2" placeholder="SecondName"></input>

<button name="bt1" value="1">+</button>
<button name="bt1" value="2">-</button>
<button name="bt1" value="3">X</button>
<button name="bt1" value="4">/</button>
</form>
<h1>Ans=<%=request.getParameter("ans")%></h1>
</body>
</html>