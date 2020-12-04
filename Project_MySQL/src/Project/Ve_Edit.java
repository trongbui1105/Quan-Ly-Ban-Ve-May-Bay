package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ve_Edit {
	
	private static ArrayList<Ve> list;

	private Connection conn;
	public  ArrayList<Ve> getListTickets() throws SQLException {
		
		list = new ArrayList<>();
		String sql =  "Select * from Ve";
		try {
			conn = GUI.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Ve v = new Ve();
				v.setMaVe(rs.getString("MaVe"));
				v.setMaCB(rs.getString("MaCB"));
				v.setTenHK(rs.getString("TenHanhKhach"));
				v.setPassport(rs.getString("Passport"));
				v.setGiaVe(rs.getInt("GiaVe"));
				list.add(v);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.close();
		return list;
		
	}
	
}
