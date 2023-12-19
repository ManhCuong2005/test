package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class JDBC {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			// Đăng kí MySQL Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// Các thông số 
			String url = "jdbc:mysql://localhost:3306/QuanLyNhaHang";
			String user = "root";
			String password = "";
			
			// Tạo kết nối 
			c = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c; 
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void prinInfo(Connection c) {
		try {
			if (c != null) {
				java.sql.DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
