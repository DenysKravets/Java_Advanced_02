package ua.lviv.lgs;

import java.sql.*;

public class ConnectionUtils {
	
	private String url;
	private String user;
	private String password;
	
	ConnectionUtils(String url, String user, String password){
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	
}
