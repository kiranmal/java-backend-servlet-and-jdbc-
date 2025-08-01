package com.infosys.jdbc_prepared_statements_crud.servlet_Controller;

import java.io.IOException;
import java.time.LocalDate;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/userUpdate"})
public class UserUpdateController extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("username");
		String email= req.getParameter("useremail");
		String password= req.getParameter("userpassword");
		String gender= req.getParameter("usergender");
		LocalDate dob= LocalDate.parse(req.getParameter("userdob"));
		
		User user = new User(userid,name,email,password,gender,dob);
		
		User user1 =(new UserDao()).updateUserDao(user);
		
		if(user1 != null) {
			resp.sendRedirect("user-display.jsp");
		}
	}
}
