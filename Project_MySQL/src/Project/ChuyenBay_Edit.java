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

import javax.swing.JOptionPane;
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
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maCB_field);
			cStmt.setString(2, maMB_field);
			cStmt.setString(3, maSBdi_field);
			cStmt.setString(4, maSBden_field);
			cStmt.setString(5, ngayBay_field);

			ResultSet rs = cStmt.executeQuery();
			GUI gui = new GUI();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Insert Succesfully!");
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
	
	public void deleteFlights(String maCB) {
		String sql = "call deleteFlight(?)";
		try {
			conn = GUI.getConnection();
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, maCB);
	
			ResultSet rs = cStmt.executeQuery();
			GUI gui = new GUI();
			JOptionPane.showMessageDialog(gui.getPanel_QLLB(), "Delete Succesfully!");
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
	
	public void showField() throws IOException, SQLException {
			GUI gui = new GUI();
			gui.getTable_QLLB().addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int row = gui.getTable_QLLB().getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) gui.getTable_QLLB().getModel();
//					DefaultTableModel model = gui.getModel_QLLB();
					String valueMaCB = model.getValueAt(row, 0).toString();
					String valueMaMB = model.getValueAt(row, 1).toString();
					String valueMaSBdi = model.getValueAt(row, 2).toString();
					String valueMaSBden = model.getValueAt(row, 3).toString();
					String valueNgayBay = model.getValueAt(row, 4).toString();

					gui.getMaCB_field().setText(valueMaCB);
					gui.getMaMB_field().setText(valueMaMB);
					gui.getMaSBdi_field().setText(valueMaSBdi);
					gui.getMaSBden_field().setText(valueMaSBden);
					gui.getNgayBay_field().setText(valueNgayBay);
				}
		
		
			});

	}
}










