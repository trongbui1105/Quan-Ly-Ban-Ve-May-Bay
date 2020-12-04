package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ChuyenBay_Edit {
	private static ArrayList<ChuyenBay> list;

	private Connection conn;
	public  ArrayList<ChuyenBay> getListFlights() throws SQLException {
		
		list = new ArrayList<>();
		String sql =  "Select * from ChuyenBay";
		try {
			conn = GUI.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ChuyenBay c = new ChuyenBay();
				c.setMaCB(rs.getString("MaCB"));
				c.setMaMB(rs.getString("MaMB"));
				c.setMaSBdi(rs.getString("MaSBdi"));
				c.setMaSBden(rs.getString("MaSBden"));
				c.setNgayBay(rs.getDate("NgayBay"));
				list.add(c);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.close();
		return list;
		
	}
	
	public static ArrayList<ChuyenBay> getList() {
		return list;
	}
	
	public void setList(ArrayList<ChuyenBay> list) {
		this.list = list;
	}
	
	
}










