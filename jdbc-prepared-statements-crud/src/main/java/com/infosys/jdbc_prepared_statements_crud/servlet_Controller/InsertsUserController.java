package com.infosys.jdbc_prepared_statements_crud.servlet_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertsUserController extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		
		System.out.println("do--get() method executor");
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		String username = req.getParameter("username");
		String email = req.getParameter("useremail");
		String password = req.getParameter("userpassword");
		String gender = req.getParameter("usergender");
		LocalDate dob = LocalDate.parse(req.getParameter("userdob"));
		
		User user=new User(userid,username,email,password,gender,dob);
		
		User user2=(new UserDao()).SaveUserDao(user);
		
		
		PrintWriter printWriter=resp.getWriter();
		
		
		if(user2 != null) {
			printWriter.write("<html><body><h4 style='color:green;'>Account created</h4></body></html>");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("user-login.jsp");
			
			dispatcher.include(req,resp);
		}else {
			printWriter.write("<html><body><h1 style='color:pink;'>Account is already Created</h1></body></html>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("user-registration.jsp");
			
			dispatcher.include(req,resp);
		}
		
		System.out.println(user);
	}

}




