package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/myjava?serverTimezone=Asia/Seoul";
	private final static String USER = "myjava";
	private final static String PASS = "12345";

	private static Connection conn = null;
	
	private DBHelper() {}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL,USER,PASS);
				System.out.println("getConnection");
			} catch (ClassNotFoundException e) {
				System.out.println("DRIVER 를 찾을 수 없음 "+e.getMessage());
			} catch (SQLException e) {
				System.out.println("DB 정보 오류 "+e.getMessage());
			}
		}
		return conn;
	}
	
	public static void close(AutoCloseable... closer) {
		try {
			for(AutoCloseable c : closer) {
				if(c != null) c.close();
			}
		} catch (Exception e) {}
	}
}
