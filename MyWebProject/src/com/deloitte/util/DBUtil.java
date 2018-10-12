package com.deloitte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.deloitte.util.BankingException;
//import com.deloitte.util.BankingMessages;

public class DBUtil {
	private static Connection conn;

	public static Connection getConnection()  {
		
			try {
				if(conn==null || conn.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "deloitte_java", "del123");
			}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		
		return conn;
	}
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

