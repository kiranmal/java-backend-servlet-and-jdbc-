package com.infosys.jdbc_prepared_statements_crud.servlet_Controller;

import java.io.IOException;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/delete"})
public class DeleteUserByIdController extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int id=Integer.parseInt(req.getParameter("id"));
	
	System.out.println("delete class doget method = "+id);
	
	boolean del= (new UserDao()).delete(id);
	if(del) {
		req.getRequestDispatcher("user-display.jsp").forward(req, resp);
	}
}

}
