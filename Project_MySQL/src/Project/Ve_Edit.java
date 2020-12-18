package Project;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public void insertTicket(String maVe_field, String maCB_field, String tenHK_field,
			String passport_field, int giaVe_field) {
		String sql = "call insertTicket(?, ?, ?, ?, ?)";
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
			cStmt.setString(1, maVe_field);
			cStmt.setString(2, maCB_field);
			cStmt.setString(3, tenHK_field);
			cStmt.setString(4, passport_field);
			cStmt.setInt(5, giaVe_field);
			
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_Ve(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_Ve(), "Insert Failed!");
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteTicket(String maVe) {
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
			cStmt.setString(1, maVe);
	
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
	
	public void modifyTicket(String maVe_field, String maCB_field, String tenHK_field,
			String passport_field, int giaVe_field){
		String sql = "call updateTicket(?, ?, ?, ?, ?)";
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
			cStmt.setString(1, maVe_field);
			cStmt.setString(2, maCB_field);
			cStmt.setString(3, tenHK_field);
			cStmt.setString(4, passport_field);
			cStmt.setInt(5, giaVe_field);

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
	
	public Ve findTicketID(String maVe_field) {
		Ve v = new Ve();
		String sql = "call findTicKetID(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maVe_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				v.setMaVe(rs.getString("MaVe"));
				v.setMaCB(rs.getString("MaCB"));
				v.setTenHK(rs.getString("TenHanhKhach"));
				v.setPassport(rs.getString("Passport"));
				v.setGiaVe(rs.getInt("GiaVe"));
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
		return v;
	}
	
	public Ve findFlightID(String maCB_field) {
		Ve v = new Ve();
		String sql = "call findFlightIDfromVe(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maCB_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				v.setMaVe(rs.getString("MaVe"));
				v.setMaCB(rs.getString("MaCB"));
				v.setTenHK(rs.getString("TenHanhKhach"));
				v.setPassport(rs.getString("Passport"));
				v.setGiaVe(rs.getInt("GiaVe"));
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
		return v;
	}
}
