package com.infosys.jdbc_prepared_statements_crud.servlet_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet({"/userLogin"})

public class LoginUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//session->start
		HttpSession httpS = req.getSession();
		//end
		String email=req.getParameter("useremail");
		String password=req.getParameter("userpassword");
		
		User user=new UserDao().getUserByEmailDao(email);
		
		PrintWriter printWriter=resp.getWriter();
		
	if(user != null) {
		if(password.equals(user.getPassword())) {
			
			//session->start
			httpS.setAttribute("userSession",email);
			
//			List<User> users = new UserDao().getAllUserDao();
			
			req.getRequestDispatcher("user-display.jsp").forward(req, resp);
		}else {
			printWriter.write("<html><body><h4 style='color:red;'>password mismatch</h4></body></html>");
			
			
			req.getRequestDispatcher("user-login.jsp").include(req, resp);
			
		}
		}else {
			printWriter.write("<html><body><h4>email donot exists</h4></body></html>");
			
			req.getRequestDispatcher("user-login.jsp").include(req, resp);
		}
		
	}
}
