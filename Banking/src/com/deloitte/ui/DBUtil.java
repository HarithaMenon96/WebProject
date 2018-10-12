package com.deloitte.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deloitte.util.BankingException;
import com.deloitte.util.BankingMessages;

public class DBUtil {
	private static Connection conn;

	public static Connection getConnection() throws BankingException {
		
			try {
				if(conn==null || conn.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "deloitte_java", "del123");
			}
			}catch (ClassNotFoundException e) {
				//e.printStackTrace();
				throw new BankingException(BankingMessages.DB_DRIVER_MISSING);
			} catch (SQLException e) {
				//e.printStackTrace();
				throw new BankingException(BankingMessages.DB_ERROR);
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
