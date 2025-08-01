package com.infosys.jdbc_prepared_statements_crud.controller;

import java.sql.PreparedStatement;
import java.util.List;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

public class UserDisplayController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		List<User> users = dao.getAllUserDao();
		
		if(users.isEmpty()) {
			System.out.println("No such user");
		}
		else {
			for(User user : users) {
				System.out.println("Id: "+user.getId());
				System.out.println("Name: "+user.getName());
				System.out.println("Email: "+user.getEmail());
				System.out.println("Password: "+user.getPassword());
				System.out.println("Gender: "+user.getGender());
				System.out.println("DOB: "+user.getDob());
			}
		}
		
	
}
}
