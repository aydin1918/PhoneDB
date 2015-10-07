package com.phone;

import java.sql.Connection;  
import java.sql.DriverManager;   
import java.sql.SQLException;  

public class ConnectOracle {
       private static Connection connection;
	public ConnectOracle(){
    	   
       }
     public static Connection getDBConnection() throws ClassNotFoundException, SQLException{  
       Class.forName("oracle.jdbc.driver.OracleDriver");
       connection = null;
	try {
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sysdba","SYSTEM","12345");
		return connection;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
       connection.close();
	return connection;
     }
}
