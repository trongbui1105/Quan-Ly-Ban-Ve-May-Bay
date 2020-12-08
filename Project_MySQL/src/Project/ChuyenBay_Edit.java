package Project;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


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
	
	public void insertFlight(String maCB_field, String maMB_field, String maSBdi_field, String maSBden_field, String ngayBay_field){
		String sql = "call insertAirplane(?, ?, ?, ?, ?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maCB_field);
			cStmt.setString(2, maMB_field);
			cStmt.setString(3, maSBdi_field);
			cStmt.setString(4, maSBden_field);
			cStmt.setString(5, ngayBay_field);

			ResultSet rs = cStmt.executeQuery();
//			GUI gui = new GUI();
//			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
	
}










