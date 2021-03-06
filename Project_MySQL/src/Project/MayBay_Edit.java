package Project;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public void insertPlane(String idPlane_field, String typePlane_field, String airline_field, int numOfChair_field) {
		String sql = "call insertPlane(?, ?, ?, ?)";
		GUI gui = null;
		try {
			gui = new GUI();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, idPlane_field);
			cStmt.setString(2, typePlane_field);
			cStmt.setString(3, airline_field);
			cStmt.setInt(4, numOfChair_field);
			
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_MB(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_MB(), "Insert Failed!");
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePlane(String idPlane) {
		String sql = "call deletePlane(?)";
		GUI gui = null;
		try {
			gui = new GUI();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, idPlane);
	
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_MB(), "Delete Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_MB(), "Delete Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyPlane(String newPlaneID, String planeID_field, String typePlane_field,
			String airline_field, int numOfChair_field){
		String sql = "call updatePlane(?, ?, ?, ?, ?)";
		GUI gui = null;
		try {
			gui = new GUI();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, newPlaneID);
			cStmt.setString(2, planeID_field);
			cStmt.setString(3, typePlane_field);
			cStmt.setString(4, airline_field);
			cStmt.setInt(5, numOfChair_field);

			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Update Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Update Failed!");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MayBay findIDPlane(String planeID_field) {
		MayBay m = new MayBay();
		String sql = "call findPlaneID(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, planeID_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				m.setMaMB(rs.getString("maMB"));
				m.setLoai(rs.getString("loai"));
				m.setHang(rs.getString("hang"));
				m.setSoGhe(rs.getInt("soGhe"));
			}

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
		return m;
	}
}
