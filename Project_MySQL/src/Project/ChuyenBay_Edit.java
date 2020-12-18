package Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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
	
	public void insertFlight(String maCB_field, String maMB_field, String maSBdi_field,
									String maSBden_field, String ngayBay_field) {
		String sql = "call insertFlight(?, ?, ?, ?, ?)";

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
			cStmt.setString(1, maCB_field);
			cStmt.setString(2, maMB_field);
			cStmt.setString(3, maSBdi_field);
			cStmt.setString(4, maSBden_field);
			cStmt.setString(5, ngayBay_field);

			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Insert Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFlights(String maCB) {
		String sql = "call deleteFlight(?)";
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
			cStmt.setString(1, maCB);
	
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Delete Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Delete Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void modifyFlight(String maCB_field, String newMaCB, String maMB_field, String maSBdi_field,
			String maSBden_field, String ngayBay_field){
		String sql = "call updateFlight(?, ?, ?, ?, ?, ?)";
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
			cStmt.setString(1, maCB_field);
			cStmt.setString(2, newMaCB);
			cStmt.setString(3, maMB_field);
			cStmt.setString(4, maSBdi_field);
			cStmt.setString(5, maSBden_field);
			cStmt.setString(6, ngayBay_field);

			ResultSet rs = cStmt.executeQuery();
//			GUI gui = new GUI();
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
	
	public ChuyenBay findFlightID(String maCB_field) {
		ChuyenBay c = new ChuyenBay();
		String sql = "call findFlightID(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maCB_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				c.setMaCB(rs.getString("MaCB"));
				c.setMaMB(rs.getString("MaMB"));
				c.setMaSBdi(rs.getString("MaSBdi"));
				c.setMaSBden(rs.getString("MaSBden"));
				c.setNgayBay(rs.getDate("NgayBay"));
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
		return c;
	}
}










