package Project;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SanBay_Edit {

	private static ArrayList<SanBay> list;

	private Connection conn;
	public  ArrayList<SanBay> getListAirports() throws SQLException {
		list = new ArrayList<>();
		String sql =  "Select * from SanBay";
		try {
			conn = GUI.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SanBay sb = new SanBay();
				sb.setMaSB(rs.getString("MaSB"));
				sb.setTenSB(rs.getString("TenSB"));
				sb.setQuocGia(rs.getString("quocGia"));
				list.add(sb);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.close();
		return list;
	}
	
	public void insertAirport(String idAirport_field, String nameOfAirport_field, String country_field) {
		String sql = "call insertAirport(?, ?, ?)";
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
			cStmt.setString(1, idAirport_field);
			cStmt.setString(2, nameOfAirport_field);
			cStmt.setString(3, country_field);
			
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Insert Failed!");
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyAirport(String idAirport_field, String newIDAirport, String nameOfAirport_field, String country_field){
		String sql = "call updateAirport(?, ?, ?, ?)";
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
			cStmt.setString(1, idAirport_field);
			cStmt.setString(2, newIDAirport);
			cStmt.setString(3, nameOfAirport_field);
			cStmt.setString(4, country_field);

			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Update Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Update Failed!");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAirport(String idAirport) {
		String sql = "call deleteAirport(?)";
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
			cStmt.setString(1, idAirport);
	
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Delete Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_SanBay(), "Delete Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SanBay findIDAirport(String idAirport_field) {
		SanBay s = new SanBay();
		String sql = "call findIDAirport(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, idAirport_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				s.setMaSB(rs.getString("maSB"));
				s.setTenSB(rs.getString("tenSB"));
				s.setQuocGia(rs.getString("quocGia"));
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
		return s;
	}
	
}
