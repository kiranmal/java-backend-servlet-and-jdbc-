package com.infosys.jdbc_prepared_statements_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
 


public class UserConnection {
	
	public static Connection getUserConnection() {
		 
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-e5";
			String username="root";
			String password="root@123";
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
		
	}

}
