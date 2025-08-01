<%@page import="com.infosys.jdbc_prepared_statements_crud.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.infosys.jdbc_prepared_statements_crud.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%
		List<User> users=new UserDao().getAllUserDao();
	
	
		HttpSession httpS=request.getSession();
		
		String email=(String)httpS.getAttribute("userSession");
		
		if(email != null){
			
	
	%>
	
	<h3>Welcome to Dispaly World !!</h3>
	
	<table border = "2">
	
	<tr>
	<th>UserId:</th>
	<th>UserName:</th>
	<th>UserEmail:</th>
	<th>UserGender:</th>
	<th>UserDob:</th>
	<th colspan="2">Action:</th>
	</tr>
	
	
	<% for(User user:users) { %>
	
	<tr>
	<td><%=user.getId()%></td>
	<td><%=user.getName()%></td>
	<td><%=user.getEmail()%></td>
	<td><%=user.getGender()%></td>
	<td><%= user.getDob()%></td>
	
	<td>
	<a href="delete?id=<%=user.getId()%>">DELETE</a>
	</td>
	
	<td>
	<a href="user-update.jsp?id=<%=user.getId()%>">EDIT</a>
	</td>
	
	</tr>
	
	
	<%} %>
	
	</table>
	
	<%} else{ %>
	<%  request.setAttribute("messsage", "please login then try");
		request.getRequestDispatcher("user-login.jsp").forward(request,response);
	 %>
	 <%}%>
	
	<a href="logout">LOGOUT</a>
	
	
</body>
</html>