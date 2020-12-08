package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MayBay_Edit {
	
	private static ArrayList<MayBay> list;

	private Connection conn;
	public  ArrayList<MayBay> getListPlanes() throws SQLException {
		
		list = new ArrayList<>();
		String sql =  "Select * from MayBay";
		try {
			conn = GUI.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MayBay mb = new MayBay();
				mb.setMaMB(rs.getString("MaMB"));
				mb.setLoai(rs.getString("loai"));
				mb.setHang(rs.getString("hang"));
				mb.setSoGhe(rs.getInt("soGhe"));
				list.add(mb);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.close();
		return list;
	}
}
