package com.infosys.jdbc_prepared_statements_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.infosys.jdbc_prepared_statements_crud.connection.UserConnection;
import com.infosys.jdbc_prepared_statements_crud.dto.User;

public class UserDao {
	
	
	Connection connection=UserConnection.getUserConnection();
	public User SaveUserDao(User user) {
		String insertQuery = "insert into user(id,name,email,password,gender,dob) values(?,?,?,?,?,?)";
		try {
			
		if(connection != null) {
		PreparedStatement ps= connection.prepareStatement(insertQuery);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getGender());
		ps.setObject(6, user.getDob());
		
		return ps.executeUpdate() > 0 ? user : null;
		}
		else {
			return null;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<User> getAllUserDao(){
	
		String selectUserQuery="select * from user";
	try {
		
//	Connection connection = UserConnection.getUserConnection();
	
	
	PreparedStatement ps=this.connection.prepareStatement(selectUserQuery);
	
	ResultSet result = ps.executeQuery();
	
	List<User> users= new ArrayList();
	
	while(result.next()) {
		User user = new User();
		user.setId(result.getInt("id"));
		user.setName(result.getString("name"));
		user.setEmail(result.getString("email"));
		user.setGender(result.getString("gender"));
		user.setDob(result.getDate("dob").toLocalDate());
		
		users.add(user);
	}
	
	
	return users;
	
	}catch(SQLException e) {
		
		e.printStackTrace();
		return null;
	}
	
	}
	

	//Homework
	
	public User getUserByIdDao(int id) {
		
	User user = null;
	String userByIdQuery = "select * from user where id = ?";
	
	try {
	
	
	
	PreparedStatement ps=connection.prepareStatement(userByIdQuery);
	
	ps.setInt(1, id);
	
	ResultSet result=ps.executeQuery();
		
	if(result.next()) {
		user = new User();
		user.setId(result.getInt("id"));
		user.setName(result.getString("name"));
		user.setEmail(result.getString("email"));
		user.setPassword(result.getString("password"));
		user.setGender(result.getString("gender"));
		user.setDob(result.getDate("dob").toLocalDate());
		return user;
	}
	else {
		System.out.println("No such id exists in db");
		return null;
	}
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
	
	public User getUserByEmailDao(String email) {
		User user = null;
		try {
		String userByEmail="select email,password from user where email=?";
		
		PreparedStatement ps=connection.prepareStatement(userByEmail);
		
		ps.setString(1, email);
		
		ResultSet result=ps.executeQuery();
		if(result.next()) {
			 user = new User();
			 user.setEmail(result.getString("email"));
			 user.setPassword(result.getString("password"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean delete (int userId) {
		
		try {
		
		String deleteQuery="delete from user where id=?";
		PreparedStatement ps = connection.prepareStatement(deleteQuery);
		
		ps.setInt(1, userId);
		
		return ps.executeUpdate() != 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
//	String msg= user2 != null ? "saved" : "not saved";

	public User updateUserDao(User user) {
		String insertQuery = "update user set name=?,email=?,password=?,gender=?,dob=? where id=?";
		try {
			
		if(this.connection != null) {
		
		PreparedStatement ps=this.connection.prepareStatement(insertQuery);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getGender());
		ps.setObject(5, user.getDob());
		ps.setInt(6,user.getId());
		
		return ps.executeUpdate()>0 ? user : null;
		}else {
			System.out.println("No connection found here please watch carefully");
			return null;
		}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
