package com.zerocchi.connection;

import java.sql.*;  
import static com.zerocchi.connection.Provider.*;  
	  
public class ConnectionProvider {  
	private static Connection con=null;  
	  
	public static Connection getCon(){  
		if (con != null)
			return con;
	else{
		try{  
			Class.forName(DRIVER);  
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
		}catch(Exception e){}  
		}
		return con;
	}  
}  