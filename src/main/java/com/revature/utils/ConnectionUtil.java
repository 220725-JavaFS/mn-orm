package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.models.*;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection(DatabaseInfo info){
		if(info == null) {
			return null;
		}
		try {
			if(connection!=null && !connection.isClosed()) {
				return connection;
			}else {
							
				try {
					Class.forName("org.postgresql.Driver");
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				String url = "jdbc:postgresql://" + info.databaseURL + ":5432/" + info.databaseName;
				String username = info.username;
				String password = info.password;
				
				try {
					connection = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					return null;
				}
				
				return connection;
				
			}
		} catch (SQLException e) {
			return null;
		}
	}
	


}
