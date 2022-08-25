package com.revature.models;

public class DatabaseInfo {
	public DatabaseInfo(String databaseURL, String databaseName, String username, String password) {
		super();
		this.databaseURL = databaseURL;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
	}
	public String databaseURL;
	public String databaseName;
	public String username;
	public String password;
}
