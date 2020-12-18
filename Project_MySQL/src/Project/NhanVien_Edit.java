package Project;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NhanVien_Edit {
	private static ArrayList<NhanVien> list;

	private Connection conn;
	public  ArrayList<NhanVien> getListEmp() throws SQLException {
		
		list = new ArrayList<>();
		String sql =  "Select * from NhanVien";
		try {
			conn = GUI.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("MaNV"));
				nv.setHoTen(rs.getString("hoTen"));
				nv.setLuong(rs.getInt("luong"));
				nv.setNgaySinh(rs.getDate("NgaySinh"));
				nv.setMaSB(rs.getString("maSB"));
				list.add(nv);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		conn.close();
		return list;
		
	}
	

	public void insertEmp(String maNV_field, String hoTen_field, int luong_field,
									String ngaySinh_field, String maSB_field) {
		String sql = "call insertEmp(?, ?, ?, ?, ?)";

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
			cStmt.setString(1, maNV_field);
			cStmt.setString(2, hoTen_field);
			cStmt.setInt(3, luong_field);
			cStmt.setString(4, ngaySinh_field);
			cStmt.setString(5, maSB_field);

			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Insert Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Insert Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteEmp(String maNV) {
		String sql = "call deleteEmp(?)";
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
			cStmt.setString(1, maNV);
	
			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Delete Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Delete Failed!");

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyEmp(String maNV_field, String newMaNV, String hoTen_field, int luong_field,
						String ngaySinh_field, String maSB_field){
		String sql = "call updateEmp(?, ?, ?, ?, ?, ?)";
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
			cStmt.setString(1, maNV_field);
			cStmt.setString(2, newMaNV);
			cStmt.setString(3, hoTen_field);
			cStmt.setInt(4, luong_field);
			cStmt.setString(5, ngaySinh_field);
			cStmt.setString(6, maSB_field);

			ResultSet rs = cStmt.executeQuery();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Update Succesfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(gui.getPanel_NV(), "Update Failed!");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NhanVien findIDEmp(String maNV_field) {
		NhanVien nv = new NhanVien();
		String sql = "call findIDEmp(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maNV_field);
			

			ResultSet rs = cStmt.executeQuery();
			while(rs.next()) {
				nv.setMaNV(rs.getString("MaNV"));
				nv.setHoTen(rs.getString("hoTen"));
				nv.setLuong(rs.getInt("luong"));
				nv.setNgaySinh(rs.getDate("ngaySinh"));
				nv.setMaSB(rs.getString("maSB"));
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
		return nv;
	}
	
}
