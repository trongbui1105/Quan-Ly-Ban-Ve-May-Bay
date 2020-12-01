package Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class main {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String connStr = "jdbc:mysql://127.0.0.1/QLBVMB?user=root&password=bqt110500";
			Connection conn = DriverManager.getConnection(connStr);
			System.out.println("Ket noi thanh cong");
		}
		catch (Exception e) {
			System.out.println("Ket noi khong thanh cong");
		}
		
	}

}
