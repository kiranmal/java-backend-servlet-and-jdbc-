package com.infosys.jdbc_prepared_statements_crud.controller;

import java.time.LocalDate;

import com.infosys.jdbc_prepared_statements_crud.dao.UserDao;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

public class InsertUserController {
	
	//no use of service for now via 
	public static void main(String[] args) {
		
		
	UserDao dao=new UserDao();
	
	User user=new User();
	
	user.setId(1);
	user.setName("Mohan");
	user.setEmail("mohan@gmail.com");
	user.setPassword("mohan@123");
	user.setGender("Male");
	user.setDob(LocalDate.parse("1999-2-2"));
	User user2=dao.SaveUserDao(user);
	
	String msg= user2 != null ? "saved" : "not saved";
	
	System.out.println(msg);
	
	
	
	
	}

}
