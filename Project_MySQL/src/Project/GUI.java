package Project;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class GUI extends JFrame {

	private JPanel contentPane, panel_LichBay, panel_Ve, panel_QLLB, panel_MB, panel_SanBay, panel_NV;
	private JButton lichBay_btn, ve_btn, qllichBay_btn, sanBay_btn, nhanVien_btn, mayBay_btn;
	private static JButton exit_btn;
	private JTable table_LB, table_Ve, table_MB, table_QLLB, table_SB, table_NV;
	private JScrollPane scrollPane_LB, scrollPane_Ve, scrollPane_QLLB, scrollPane_MB, scrollPane_SB, scrollPane_NV;
	private DefaultTableModel model_LB, model_Ve, model_QLLB, model_MB, model_SB, model_NV;
	private JTextField maCBVe_field, maVe_field, tenHK_field, passport_field, gia_field, maCB_field, maMB_field,
						maSBdi_field, maSBden_field, ngayBay_field, idPlane_field, typeOfPlane_field, airline_field,
						 numOfChair_field, maSB_field, tenSB_field, quocGia_field, maNV_field, hoTen_field, luong_field,
						 ngaySinh_field, maSB_NV_field;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					exit_btn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							frame.dispose();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public GUI() throws IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		// Label Image
		final ImageIcon icon = new ImageIcon(GUI.class.getResource("/Project/image.png"));
        JLabel picLabel = new JLabel(icon);
        picLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        picLabel.setBounds(0, 0, 815, 120);
        picLabel.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                JLabel picLabel = (JLabel) e.getComponent();
                Dimension size = picLabel.getSize();
                Image resized = icon.getImage().getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
                picLabel.setIcon(new ImageIcon(resized));
            }
        });
		contentPane.setLayout(null);
		contentPane.add(picLabel);
		
		// panel function
		JPanel panel_function = new JPanel();
		panel_function.setBorder(null);
		panel_function.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		panel_function.setBounds(0, 120, 172, 499);
		contentPane.add(panel_function);
		panel_function.setLayout(null);
		
		// lich bay button
		lichBay_btn = new JButton("Lịch Bay");
		lichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		lichBay_btn.setBounds(19, 35, 125, 40);
		panel_function.add(lichBay_btn);
		lichBay_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(true);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(false);
				panel_MB.setVisible(false);
				panel_SanBay.setVisible(false);
				panel_NV.setVisible(false);
				
			}
		});
		
		// ve button
		ve_btn = new JButton("Vé");
		ve_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		ve_btn.setBounds(19, 96, 125, 40);
		panel_function.add(ve_btn);
		ve_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(true);
				panel_QLLB.setVisible(false);
				panel_MB.setVisible(false);
				panel_SanBay.setVisible(false);
				panel_NV.setVisible(false);
				
				int rowCount= model_Ve.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_Ve.removeRow(i);
				}
				
				try {
					Ve_Edit vEdit = new Ve_Edit();
					for(Ve v : vEdit.getListTickets()) {
						model_Ve.addRow(new Object[] {
							v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// quan li lich bay button
		qllichBay_btn = new JButton("Quản Lý Lịch Bay");
		qllichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		qllichBay_btn.setBounds(19, 159, 125, 40);
		panel_function.add(qllichBay_btn);
		qllichBay_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(true);
				panel_MB.setVisible(false);
				panel_SanBay.setVisible(false);
				panel_NV.setVisible(false);


			}
		});
		
		// san bay button
		sanBay_btn = new JButton("Sân Bay");
		sanBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		sanBay_btn.setBounds(19, 297, 125, 40);
		panel_function.add(sanBay_btn);
		sanBay_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(false);
				panel_MB.setVisible(false);
				panel_SanBay.setVisible(true);
				panel_NV.setVisible(false);
				
				int rowCount= model_SB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_SB.removeRow(i);
				}
				    
				try {
					SanBay_Edit sb_edit = new SanBay_Edit();
					for(SanBay s : sb_edit.getListAirports()) {
						model_SB.addRow(new Object[] {
								s.getMaSB(), s.getTenSB(), s.getQuocGia()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// exit button
		exit_btn = new JButton("Thoát");
		exit_btn.setForeground(Color.RED);
		exit_btn.setFont(new Font("Apple Color Emoji", Font.PLAIN, 22));
		exit_btn.setBounds(19, 426, 125, 40);
		panel_function.add(exit_btn);
		
		
		// nhan vien button
		nhanVien_btn = new JButton("Nhân Viên");
		nhanVien_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		nhanVien_btn.setBounds(19, 360, 125, 40);
		panel_function.add(nhanVien_btn);
		nhanVien_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(false);
				panel_MB.setVisible(false);
				panel_SanBay.setVisible(false);
				panel_NV.setVisible(true);
				
				int rowCount= model_NV.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_NV.removeRow(i);
				}
				    
				try {
					NhanVien_Edit nv_edit = new NhanVien_Edit();
					for(NhanVien nv : nv_edit.getListEmp()) {
						model_NV.addRow(new Object[] {
								nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// may bay button
		mayBay_btn = new JButton("Máy Bay");
		mayBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		mayBay_btn.setBounds(19, 227, 125, 40);
		panel_function.add(mayBay_btn);
		mayBay_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(false);
				panel_MB.setVisible(true);
				panel_SanBay.setVisible(false);
				panel_NV.setVisible(false);
				
				int rowCount= model_MB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_MB.removeRow(i);
				}
				    
				try {
					MayBay_Edit mb_edit = new MayBay_Edit();
					for(MayBay m : mb_edit.getListPlanes()) {
						model_MB.addRow(new Object[] {
							m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel_NV = new JPanel();
		panel_NV.setBounds(170, 120, 643, 497);
		contentPane.add(panel_NV);
		panel_NV.setLayout(null);
		panel_NV.setVisible(false);
		
		NhanVien_Edit nv_edit = new NhanVien_Edit();
		showNhanVien();
		showFieldNV(model_NV);
		scrollPane_NV = new JScrollPane(table_NV);
		scrollPane_NV.setBounds(0, 234, 645, 264);
		panel_NV.add(scrollPane_NV);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên");
		lblMaNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNV.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMaNV.setBounds(25, 16, 106, 25);
		panel_NV.add(lblMaNV);
		
		JLabel lblHoTen = new JLabel("Họ Tên");
		lblHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoTen.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblHoTen.setBounds(25, 63, 106, 25);
		panel_NV.add(lblHoTen);
		
		JLabel lblLuong = new JLabel("Lương");
		lblLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuong.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLuong.setBounds(25, 110, 106, 25);
		panel_NV.add(lblLuong);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgaySinh.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNgaySinh.setBounds(25, 155, 106, 25);
		panel_NV.add(lblNgaySinh);
		
		JLabel lblMaSB_1 = new JLabel("Mã Sân Bay");
		lblMaSB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaSB_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMaSB_1.setBounds(25, 201, 106, 25);
		panel_NV.add(lblMaSB_1);
		
		maNV_field = new JTextField();
		maNV_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maNV_field.setBounds(149, 13, 220, 32);
		panel_NV.add(maNV_field);
		maNV_field.setColumns(10);
		
		hoTen_field = new JTextField();
		hoTen_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		hoTen_field.setColumns(10);
		hoTen_field.setBounds(149, 60, 220, 32);
		panel_NV.add(hoTen_field);
		
		luong_field = new JTextField();
		luong_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		luong_field.setColumns(10);
		luong_field.setBounds(149, 107, 220, 32);
		panel_NV.add(luong_field);
		
		ngaySinh_field = new JTextField();
		ngaySinh_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ngaySinh_field.setColumns(10);
		ngaySinh_field.setBounds(149, 151, 220, 32);
		panel_NV.add(ngaySinh_field);
		
		maSB_NV_field = new JTextField();
		maSB_NV_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maSB_NV_field.setColumns(10);
		maSB_NV_field.setBounds(149, 198, 220, 32);
		panel_NV.add(maSB_NV_field);
		
		JButton resetNV_btn = new JButton("Reset");
		resetNV_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		resetNV_btn.setBounds(485, 196, 110, 35);
		panel_NV.add(resetNV_btn);
		resetNV_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maNV_field.setText("");
				hoTen_field.setText("");
				luong_field.setText("");
				ngaySinh_field.setText("");
				maSB_NV_field.setText("");
				
				int rowCount= model_NV.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_NV.removeRow(i);
				}
				    
				try {
					for(NhanVien nv : nv_edit.getListEmp()) {
						model_NV.addRow(new Object[] {
								nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton checkNV_btn = new JButton("Check");
		checkNV_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkNV_btn.setBounds(386, 11, 117, 33);
		panel_NV.add(checkNV_btn);
		checkNV_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idEmp = maNV_field.getText();
				NhanVien nv = new NhanVien();
				nv = nv_edit.findIDEmp(idEmp);
				
				int rowCount= model_NV.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_NV.removeRow(i);
				}
				  
				model_NV.addRow(new Object[] {
						nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
				});
			}
		});
		
		JButton insertNV_btn = new JButton("Thêm Nhân Viên");
		insertNV_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		insertNV_btn.setBounds(445, 55, 179, 35);
		panel_NV.add(insertNV_btn);
		insertNV_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idEmp = maNV_field.getText();
				String nameOfEmp = hoTen_field.getText();
				int salary = Integer.parseInt(luong_field.getText());
				String DOB = ngaySinh_field.getText();
				String idAirport = maSB_NV_field.getText();

				nv_edit.insertEmp(idEmp, nameOfEmp, salary, DOB, idAirport);
				int rowCount= model_NV.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_NV.removeRow(i);
				}
				    
				try {
					for(NhanVien nv : nv_edit.getListEmp()) {
						model_NV.addRow(new Object[] {
								nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton modifyNV_btn = new JButton("Sửa Nhân Viên");
		modifyNV_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		modifyNV_btn.setBounds(443, 101, 179, 35);
		panel_NV.add(modifyNV_btn);
		modifyNV_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_NV.getSelectedRow();
				String idEmp = model_NV.getValueAt(row, 0).toString();;
				String newIDEmp = maNV_field.getText();
				String nameOfEmp = hoTen_field.getText();
				int salary = Integer.parseInt(luong_field.getText());
				String DOB = ngaySinh_field.getText();
				String idAirport = maSB_NV_field.getText();
				
				nv_edit.modifyEmp(idEmp, newIDEmp, nameOfEmp, salary, DOB, idAirport);

				int rowCount= model_NV.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_NV.removeRow(i);
				}
				    
				try {
					for(NhanVien nv : nv_edit.getListEmp()) {
						model_NV.addRow(new Object[] {
								nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton deleteNV_btn = new JButton("Xoá Nhân Viên");
		deleteNV_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		deleteNV_btn.setBounds(445, 150, 179, 35);
		panel_NV.add(deleteNV_btn);
		deleteNV_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_NV.getSelectedRow();
				String maNV = (String) model_NV.getValueAt(row, 0);
		        model_NV.removeRow(row);
		        nv_edit.deleteEmp(maNV);
			}
		});
		
		
		

		
		// panel San Bay
		panel_SanBay = new JPanel();
		panel_SanBay.setBounds(170, 120, 643, 497);
		contentPane.add(panel_SanBay);
		panel_SanBay.setLayout(null);
		panel_SanBay.setVisible(false);
		
		
		JLabel lblMaSB = new JLabel("Mã Sân Bay");
		lblMaSB.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaSB.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMaSB.setBounds(13, 21, 120, 23);
		panel_SanBay.add(lblMaSB);
		
		JLabel lblTenSB = new JLabel("Tên Sân Bay");
		lblTenSB.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenSB.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblTenSB.setBounds(13, 77, 120, 23);
		panel_SanBay.add(lblTenSB);
		
		JLabel lblQuocGia = new JLabel("Quốc Gia");
		lblQuocGia.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuocGia.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblQuocGia.setBounds(13, 132, 120, 23);
		panel_SanBay.add(lblQuocGia);
		
		maSB_field = new JTextField();
		maSB_field.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		maSB_field.setBounds(141, 16, 197, 34);
		maSB_field.setColumns(10);
		panel_SanBay.add(maSB_field);
		
		tenSB_field = new JTextField();
		tenSB_field.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		tenSB_field.setColumns(10);
		tenSB_field.setBounds(141, 72, 197, 34);
		panel_SanBay.add(tenSB_field);
		
		quocGia_field = new JTextField();
		quocGia_field.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		quocGia_field.setColumns(10);
		quocGia_field.setBounds(141, 125, 197, 34);
		panel_SanBay.add(quocGia_field);
		
		SanBay_Edit sb_edit = new SanBay_Edit();
		showSanBay();
		showFieldSB(model_SB);
		scrollPane_SB = new JScrollPane(table_SB);
		scrollPane_SB.setBounds(0, 229, 644, 269);
		panel_SanBay.add(scrollPane_SB);
		
		JButton checkSB_btn = new JButton("Check");
		checkSB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkSB_btn.setBounds(358, 16, 117, 32);
		panel_SanBay.add(checkSB_btn);
		checkSB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idAirport = maSB_field.getText();
				SanBay s = new SanBay();
				s = sb_edit.findIDAirport(idAirport);
				
				int rowCount= model_SB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_SB.removeRow(i);
				}
				  
				model_SB.addRow(new Object[] {
						s.getMaSB(), s.getTenSB(), s.getQuocGia()
				});
			}
		});
		
		JButton insertSB_btn = new JButton("Thêm Sân Bay");
		insertSB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		insertSB_btn.setBounds(463, 53, 160, 35);
		panel_SanBay.add(insertSB_btn);
		insertSB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idAirport = maSB_field.getText();
				String nameOfAirport = tenSB_field.getText();
				String country = quocGia_field.getText();

				sb_edit.insertAirport(idAirport, nameOfAirport, country);
				int rowCount= model_SB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_SB.removeRow(i);
				}
				    
				try {
					for(SanBay s : sb_edit.getListAirports()) {
						model_SB.addRow(new Object[] {
								s.getMaSB(), s.getTenSB(), s.getQuocGia()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton modifySB_btn = new JButton("Sửa Sân Bay");
		modifySB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifySB_btn.setBounds(463, 101, 160, 35);
		panel_SanBay.add(modifySB_btn);
		modifySB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_SB.getSelectedRow();
				String idAirport = model_SB.getValueAt(row, 0).toString();;
				String newIDAirport = maSB_field.getText();
				String nameOfAirport = tenSB_field.getText();
				String country = quocGia_field.getText();
				sb_edit.modifyAirport(idAirport, newIDAirport, nameOfAirport, country);

				int rowCount= model_SB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_SB.removeRow(i);
				}
				    
				try {
					for(SanBay s : sb_edit.getListAirports()) {
						model_SB.addRow(new Object[] {
								s.getMaSB(), s.getTenSB(), s.getQuocGia()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton deleteSB_btn = new JButton("Xoá Sân Bay");
		deleteSB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		deleteSB_btn.setBounds(463, 148, 160, 35);
		panel_SanBay.add(deleteSB_btn);
		deleteSB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_SB.getSelectedRow();
				String maSB = (String) model_SB.getValueAt(row, 0);
		        model_SB.removeRow(row);
		        sb_edit.deleteAirport(maSB);
			}
		});

		
		JButton resetSB_btn = new JButton("Reset");
		resetSB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		resetSB_btn.setBounds(481, 195, 117, 29);
		panel_SanBay.add(resetSB_btn);
		resetSB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maSB_field.setText("");
				tenSB_field.setText("");
				quocGia_field.setText("");
				
				int rowCount= model_SB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_SB.removeRow(i);
				}
				    
				try {
					for(SanBay s : sb_edit.getListAirports()) {
						model_SB.addRow(new Object[] {
								s.getMaSB(), s.getTenSB(), s.getQuocGia()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		// panel may bay
		panel_MB = 	new JPanel();
		panel_MB.setBounds(170, 120, 644, 498);
		contentPane.add(panel_MB);
		panel_MB.setLayout(null);
		panel_MB.setVisible(false);
		
		
		JLabel lblMaMB = new JLabel("Mã Máy Bay");
		lblMaMB.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaMB.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMaMB.setBounds(16, 11, 103, 24);
		panel_MB.add(lblMaMB);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoai.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblLoai.setBounds(20, 58, 87, 24);
		panel_MB.add(lblLoai);
		
		JLabel lblHang = new JLabel("Hãng");
		lblHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblHang.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblHang.setBounds(19, 105, 87, 24);
		panel_MB.add(lblHang);
		
		JLabel lblSoGhe = new JLabel("Số Ghế");
		lblSoGhe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoGhe.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSoGhe.setBounds(20, 150, 87, 24);
		panel_MB.add(lblSoGhe);
		
		idPlane_field = new JTextField();
		idPlane_field.setBounds(137, 6, 187, 33);
		idPlane_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		idPlane_field.setColumns(10);
		panel_MB.add(idPlane_field);

		
		typeOfPlane_field = new JTextField();
		typeOfPlane_field.setColumns(10);
		typeOfPlane_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		typeOfPlane_field.setBounds(137, 54, 187, 33);
		panel_MB.add(typeOfPlane_field);
		
		airline_field = new JTextField();
		airline_field.setColumns(10);
		airline_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		airline_field.setBounds(137, 101, 187, 33);
		panel_MB.add(airline_field);
		
		numOfChair_field = new JTextField();
		numOfChair_field.setColumns(10);
		numOfChair_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		numOfChair_field.setBounds(137, 149, 187, 33);
		panel_MB.add(numOfChair_field);
		
		MayBay_Edit mb_edit = new MayBay_Edit();
		showMayBay();
		showFieldMB(model_MB);
		scrollPane_MB = new JScrollPane(table_MB);
		scrollPane_MB.setBounds(0, 232, 645, 267);
		panel_MB.add(scrollPane_MB);

		
		// check button Ma May Bay
		JButton checkMaMB_btn = new JButton("Check");
		checkMaMB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkMaMB_btn.setBounds(336, 9, 117, 29);
		panel_MB.add(checkMaMB_btn);
		checkMaMB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idPlane = idPlane_field.getText();
				MayBay m = new MayBay();
				m = mb_edit.findIDPlane(idPlane);
				
				int rowCount= model_MB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_MB.removeRow(i);
				}
				  
				model_MB.addRow(new Object[] {
					m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
				});
			}
		});
		
		// button them may bay
		JButton insertPlane_btn = new JButton("Thêm Máy Bay");
		insertPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		insertPlane_btn.setBounds(432, 51, 199, 35);
		panel_MB.add(insertPlane_btn);
		insertPlane_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String idPlane = idPlane_field.getText();
				String typeOfPlane = typeOfPlane_field.getText();
				String airline = airline_field.getText();
				int numOfChair = Integer.parseInt(numOfChair_field.getText());

				mb_edit.insertPlane(idPlane, typeOfPlane, airline, numOfChair);
				int rowCount= model_MB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_MB.removeRow(i);
				}
				    
				try {
					for(MayBay m : mb_edit.getListPlanes()) {
						model_MB.addRow(new Object[] {
							m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// button sua may bay
		JButton modifyPlane_btn = new JButton("Sửa Máy Bay");
		modifyPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifyPlane_btn.setBounds(429, 96, 199, 35);
		panel_MB.add(modifyPlane_btn);
		modifyPlane_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_MB.getSelectedRow();
				String idPlane = model_MB.getValueAt(row, 0).toString();;
				String newIDPlane = idPlane_field.getText();
				String typeOfPlane = typeOfPlane_field.getText();
				String airline = airline_field.getText();
				int numOfChair = Integer.parseInt(numOfChair_field.getText());
				mb_edit.modifyPlane(newIDPlane, idPlane, typeOfPlane, airline, numOfChair);

				int rowCount= model_MB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_MB.removeRow(i);
				}
				    
				try {
					for(MayBay m : mb_edit.getListPlanes()) {
						model_MB.addRow(new Object[] {
							m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// button xoa may bay
		JButton deletePlane_btn = new JButton("Xoá Máy Bay");
		deletePlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		deletePlane_btn.setBounds(429, 138, 199, 35);
		panel_MB.add(deletePlane_btn);
		deletePlane_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_MB.getSelectedRow();
				String maMB = (String) model_MB.getValueAt(row, 0);
		        model_MB.removeRow(row);
		        mb_edit.deletePlane(maMB);
			}
		});
		
		// button reset may bay
		JButton resetPlane_btn = new JButton("RESET");
		resetPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		resetPlane_btn.setBounds(470, 183, 118, 31);
		panel_MB.add(resetPlane_btn);
		resetPlane_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idPlane_field.setText("");
				typeOfPlane_field.setText("");
				airline_field.setText("");
				numOfChair_field.setText("");
				int rowCount= model_MB.getRowCount();
			    for(int i = rowCount - 1; i >= 0; i--) {
			           model_MB.removeRow(i);
			    }
			    
			    try {
					for(MayBay m : mb_edit.getListPlanes()) {
						model_MB.addRow(new Object[] {
							m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		
		// panel quan li lich bay
		panel_QLLB = new JPanel();
		panel_QLLB.setBounds(170, 120, 644, 498);
		contentPane.add(panel_QLLB);
		panel_QLLB.setLayout(null);
		
		JLabel lbl_MACB = new JLabel("Mã Chuyến Bay");
		lbl_MACB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MACB.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_MACB.setBounds(10, 10, 120, 19);
		panel_QLLB.add(lbl_MACB);
		
		maCB_field = new JTextField();
		maCB_field.setColumns(10);
		maCB_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maCB_field.setBounds(141, 3, 192, 36);
		panel_QLLB.add(maCB_field);
		
		JLabel lbl_MAMB = new JLabel("Mã Máy Bay");
		lbl_MAMB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MAMB.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_MAMB.setBounds(11, 51, 120, 19);
		panel_QLLB.add(lbl_MAMB);
		
		JLabel lbl_MASBdi = new JLabel("Mã Sân Bay Đi");
		lbl_MASBdi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MASBdi.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_MASBdi.setBounds(10, 92, 120, 19);
		panel_QLLB.add(lbl_MASBdi);
		
		JLabel lbl_MASBden = new JLabel("Mã Sân Bay Đến");
		lbl_MASBden.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MASBden.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_MASBden.setBounds(11, 135, 125, 19);
		panel_QLLB.add(lbl_MASBden);
		
		JLabel lbl_NgayBay = new JLabel("Ngày Bay");
		lbl_NgayBay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NgayBay.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_NgayBay.setBounds(9, 181, 120, 19);
		panel_QLLB.add(lbl_NgayBay);
		
		maMB_field = new JTextField();
		maMB_field.setColumns(10);
		maMB_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maMB_field.setBounds(141, 42, 192, 36);
		panel_QLLB.add(maMB_field);
		
		maSBdi_field = new JTextField();
		maSBdi_field.setColumns(10);
		maSBdi_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maSBdi_field.setBounds(141, 83, 192, 36);
		panel_QLLB.add(maSBdi_field);
		
		maSBden_field = new JTextField();
		maSBden_field.setColumns(10);
		maSBden_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maSBden_field.setBounds(141, 128, 192, 36);
		panel_QLLB.add(maSBden_field);
		
		ngayBay_field = new JTextField();
		ngayBay_field.setColumns(10);
		ngayBay_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ngayBay_field.setBounds(141, 172, 192, 36);
		panel_QLLB.add(ngayBay_field);
		
		ChuyenBay_Edit cb_edit = new ChuyenBay_Edit();
		showLichBay();
		showFieldChuyenBay(model_QLLB);
		scrollPane_QLLB = new JScrollPane(table_QLLB);
		scrollPane_QLLB.setBounds(0, 230, 645, 269);
		panel_QLLB.add(scrollPane_QLLB);

		
		JButton checkMaCB_btn = new JButton("Check");
		checkMaCB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkMaCB_btn.setBounds(349, 10, 117, 29);
		panel_QLLB.add(checkMaCB_btn);
		checkMaCB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maCB = maCB_field.getText();
				ChuyenBay c = new ChuyenBay();
				c = cb_edit.findFlightID(maCB);
				
				int rowCount= model_QLLB.getRowCount();
			    for(int i = rowCount - 1; i >= 0; i--) {
			           model_QLLB.removeRow(i);
			    }

				if (c.getMaSBdi() == null) {
					c.setMaSBdi("");
				}
				
				if (c.getMaSBden() == null) {
					c.setMaSBden("");
				}
				
				model_QLLB.addRow(new Object[] {
					c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay().toString()
					});
				}

		});
		

		
		// xoa chuyen bay
		JButton deleteFlights_btn = new JButton("Xoá Chuyến Bay");
		deleteFlights_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		deleteFlights_btn.setBounds(430, 137, 199, 35);
		panel_QLLB.add(deleteFlights_btn);
		
		deleteFlights_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_QLLB.getSelectedRow();
				String maCB = (String) model_QLLB.getValueAt(row, 0);
		        model_QLLB.removeRow(row);
		        cb_edit.deleteFlights(maCB);
			}
		});
		
		JButton reset_QLLB_btn = new JButton("Reset");
		reset_QLLB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		reset_QLLB_btn.setBounds(467, 182, 117, 29);
		panel_QLLB.add(reset_QLLB_btn);
		reset_QLLB_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maCB_field.setText("");
				maMB_field.setText("");
				maSBdi_field.setText("");
				maSBden_field.setText("");
				ngayBay_field.setText("");
				int rowCount= model_QLLB.getRowCount();
			    for(int i = rowCount - 1; i >= 0; i--) {
			           model_QLLB.removeRow(i);
			    }
			    
				try {
					for(ChuyenBay c : cb_edit.getListFlights()) {
						if (c.getMaSBdi() == null) {
							c.setMaSBdi("");
						}
						if (c.getMaSBden() == null) {
							c.setMaSBden("");
						}
						model_QLLB.addRow(new Object[] {
								c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton insertFlights_btn = new JButton("Thêm Chuyến Bay");
		insertFlights_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		insertFlights_btn.setBounds(430, 50, 199, 35);
		panel_QLLB.add(insertFlights_btn);
		insertFlights_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCB = maCB_field.getText();
				String maMB = maMB_field.getText();
				String maSBdi = maSBdi_field.getText();
				String maSBden = maSBden_field.getText();
				String ngayBay = ngayBay_field.getText();
				cb_edit.insertFlight(maCB, maMB, maSBdi, maSBden, ngayBay);
				int rowCount= model_QLLB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
				    model_QLLB.removeRow(i);
				}
				    
				try {
					for(ChuyenBay c : cb_edit.getListFlights()) {
						if (c.getMaSBdi() == null) {
							c.setMaSBdi("");
						}
						if (c.getMaSBden() == null) {
							c.setMaSBden("");
						}
						model_QLLB.addRow(new Object[] {
							c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
				
		JButton modifyFlights_btn = new JButton("Sửa Chuyến Bay");
		modifyFlights_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifyFlights_btn.setBounds(430, 93, 199, 35);
		panel_QLLB.add(modifyFlights_btn);
		modifyFlights_btn.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_QLLB.getSelectedRow();
				String maCB = model_QLLB.getValueAt(row, 0).toString();
				String newMaCB = maCB_field.getText();
				String maMB = maMB_field.getText();
				String maSBdi = maSBdi_field.getText();
				String maSBden = maSBden_field.getText();
				String ngayBay = ngayBay_field.getText();
				cb_edit.modifyFlight(maCB, newMaCB, maMB, maSBdi, maSBden, ngayBay.toString());

				int rowCount= model_QLLB.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
				    model_QLLB.removeRow(i);
				}
						    
				try {
					for(ChuyenBay c : cb_edit.getListFlights()) {
						if (c.getMaSBdi() == null) {
							c.setMaSBdi("");
						}
						if (c.getMaSBden() == null) {
							c.setMaSBden("");
						}
						model_QLLB.addRow(new Object[] {
							c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
						});
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
				
		JLabel lblExample = new JLabel("VD: YYYY/MM/DD");
		lblExample.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblExample.setHorizontalAlignment(SwingConstants.CENTER);
		lblExample.setBounds(330, 174, 124, 33);
		panel_QLLB.add(lblExample);
		panel_QLLB.setVisible(false);

		
		
		// panel Ve
		panel_Ve = new JPanel();
		panel_Ve.setBounds(170, 120, 644, 498);
		contentPane.add(panel_Ve);
		panel_Ve.setLayout(null);
		panel_Ve.setVisible(false);
		
		JLabel lbl_CB = new JLabel("Chuyến Bay");
		lbl_CB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CB.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_CB.setBounds(6, 12, 100, 19);
		panel_Ve.add(lbl_CB);
		

		
		JLabel lblMV = new JLabel("Mã Vé");
		lblMV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMV.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMV.setBounds(6, 63, 100, 19);
		panel_Ve.add(lblMV);
		
		JLabel lblTenHK = new JLabel("Tên Hành Khách");
		lblTenHK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenHK.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTenHK.setBounds(6, 111, 129, 21);
		panel_Ve.add(lblTenHK);
		
		JLabel lblPassport = new JLabel("Passport");
		lblPassport.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassport.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassport.setBounds(6, 156, 100, 19);
		panel_Ve.add(lblPassport);
		
		JLabel lblGia = new JLabel("Giá");
		lblGia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGia.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGia.setBounds(6, 206, 100, 19);
		panel_Ve.add(lblGia);
		
		maCBVe_field = new JTextField();
		maCBVe_field.setBounds(144, 4, 192, 36);
		maCBVe_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_Ve.add(maCBVe_field);
		maCBVe_field.setColumns(10);
		
		maVe_field = new JTextField();
		maVe_field.setColumns(10);
		maVe_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		maVe_field.setBounds(145, 53, 192, 36);
		panel_Ve.add(maVe_field);
		
		tenHK_field = new JTextField();
		tenHK_field.setColumns(10);
		tenHK_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		tenHK_field.setBounds(145, 103, 253, 36);
		panel_Ve.add(tenHK_field);
		
		passport_field = new JTextField();
		passport_field.setColumns(10);
		passport_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		passport_field.setBounds(146, 150, 192, 36);
		panel_Ve.add(passport_field);
		
		gia_field = new JTextField();
		gia_field.setColumns(10);
		gia_field.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		gia_field.setBounds(145, 197, 192, 36);
		panel_Ve.add(gia_field);
		
		Ve_Edit vEdit = new Ve_Edit();
		showVe();
		showFieldVe(model_Ve);

		
		scrollPane_Ve = new JScrollPane(table_Ve);
		scrollPane_Ve.setBounds(1, 235, 644, 263);
		panel_Ve.add(scrollPane_Ve);
		
		JButton insertTicket_btn = new JButton("Thêm Vé");
		insertTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		insertTicket_btn.setBounds(509, 59, 117, 29);
		panel_Ve.add(insertTicket_btn);
		insertTicket_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maVe = maVe_field.getText();
				String maCB = maCBVe_field.getText();
				String tenHK = tenHK_field.getText();
				String passport = passport_field.getText();
				int giaVe = Integer.parseInt(gia_field.getText());
				vEdit.insertTicket(maVe, maCB, tenHK, passport, giaVe);
				int rowCount= model_Ve.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_Ve.removeRow(i);
				}
				
				try {
					for(Ve v : vEdit.getListTickets()) {
						model_Ve.addRow(new Object[] {
							v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton modifyTicket_btn = new JButton("Sửa Vé");
		modifyTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifyTicket_btn.setBounds(509, 109, 117, 29);
		panel_Ve.add(modifyTicket_btn);
		modifyTicket_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maVe = maVe_field.getText().toString();
				String maCB = maCBVe_field.getText();
				String tenHK = tenHK_field.getText();
				String passport = passport_field.getText();
				int giaVe = Integer.parseInt(gia_field.getText());
				vEdit.modifyTicket(maVe, maCB, tenHK, passport, giaVe);

				int rowCount= model_Ve.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_Ve.removeRow(i);
				}
				
				try {
					for(Ve v : vEdit.getListTickets()) {
						model_Ve.addRow(new Object[] {
							v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton deleteTicket_btn = new JButton("Xoá Vé");
		deleteTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		deleteTicket_btn.setBounds(510, 158, 117, 29);
		panel_Ve.add(deleteTicket_btn);
		deleteTicket_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_Ve.getSelectedRow();
				String maVe = (String) model_Ve.getValueAt(row, 0);
		        model_Ve.removeRow(row);
		        vEdit.deleteTicket(maVe);
			}
		});
		
		JButton resetVe_btn = new JButton("Reset");
		resetVe_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		resetVe_btn.setBounds(509, 206, 117, 29);
		panel_Ve.add(resetVe_btn);
		resetVe_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maVe_field.setText("");
				maCBVe_field.setText("");
				tenHK_field.setText("");
				passport_field.setText("");
				gia_field.setText("");
				
				int rowCount= model_Ve.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model_Ve.removeRow(i);
				}
				
				try {
					for(Ve v : vEdit.getListTickets()) {
						model_Ve.addRow(new Object[] {
							v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton checkMaVe_btn = new JButton("Check");
		checkMaVe_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkMaVe_btn.setBounds(347, 56, 117, 29);
		panel_Ve.add(checkMaVe_btn);
		checkMaVe_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maVe = maVe_field.getText();
				Ve v = new Ve();
				v = vEdit.findTicketID(maVe);
				
				int rowCount= model_Ve.getRowCount();
			    for(int i = rowCount - 1; i >= 0; i--) {
			           model_Ve.removeRow(i);
			    }

				model_Ve.addRow(new Object[] {
						v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
				});
			}
		});
		
		JButton checkCB_btn = new JButton("Check");
		checkCB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkCB_btn.setBounds(347, 9, 117, 29);
		panel_Ve.add(checkCB_btn);
		checkCB_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maCB = maCBVe_field.getText();
				Ve v = new Ve();
				v = vEdit.findFlightID(maCB);
				
				int rowCount= model_Ve.getRowCount();
			    for(int i = rowCount - 1; i >= 0; i--) {
			           model_Ve.removeRow(i);
			    }

				model_Ve.addRow(new Object[] {
						v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
				});
			}
		});
		
				
		JLabel lblUSD = new JLabel("USD");
		lblUSD.setHorizontalAlignment(SwingConstants.CENTER);
		lblUSD.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblUSD.setBounds(335, 206, 77, 19);
		panel_Ve.add(lblUSD);
	
		
		// panel Lich Bay
		panel_LichBay = new JPanel();
		panel_LichBay.setBounds(170, 120, 644, 498);
		contentPane.add(panel_LichBay);
		panel_LichBay.setLayout(null);


		String col_CB[] = {"Mã Chuyến Bay","Mã Máy Bay","MãSB Đi", "MãSB Đến", "Ngày Bay"};  
//		ChuyenBay_Edit cb_edit = new ChuyenBay_Edit();
		model_LB = new DefaultTableModel(null, col_CB);
		
		table_LB = new JTable(model_LB);
		table_LB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
		table_LB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_LB.setSurrendersFocusOnKeystroke(true);
		for(ChuyenBay c : cb_edit.getListFlights()) {
			if(c.getMaSBdi() == null) {
				c.setMaSBdi("");
			}
			
			if(c.getMaSBden() == null) {
				c.setMaSBden("");
			}
			
			model_LB.addRow(new Object[] {
					c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
			});
		}

		scrollPane_LB = new JScrollPane(table_LB);
		scrollPane_LB.setBounds(0, 79, 644, 420);
		panel_LichBay.add(scrollPane_LB);
		
		
		JLabel lblLchBay = new JLabel("Lịch Bay");
		lblLchBay.setForeground(Color.RED);
		lblLchBay.setFont(new Font("Arial", Font.BOLD, 50));
		lblLchBay.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchBay.setBounds(78, 6, 493, 55);
		panel_LichBay.add(lblLchBay);
	}
	
	public JTable getTable_QLLB() {
		return table_QLLB;
	}

	public void setTable_QLLB(JTable table_QLLB) {
		this.table_QLLB = table_QLLB;
	}

	public JTextField getMaCB_field() {
		return maCB_field;
	}

	public void setMaCB_field(JTextField maCB_field) {
		this.maCB_field = maCB_field;
	}

	public DefaultTableModel getModel_QLLB() {
		return model_QLLB;
	}

	public void setModel_QLLB(DefaultTableModel model_QLLB) {
		this.model_QLLB = model_QLLB;
	}

	public JTextField getMaMB_field() {
		return maMB_field;
	}

	public void setMaMB_field(JTextField maMB_field) {
		this.maMB_field = maMB_field;
	}

	public JTextField getMaSBdi_field() {
		return maSBdi_field;
	}

	public void setMaSBdi_field(JTextField maSBdi_field) {
		this.maSBdi_field = maSBdi_field;
	}

	public JTextField getMaSBden_field() {
		return maSBden_field;
	}

	public void setMaSBden_field(JTextField maSBden_field) {
		this.maSBden_field = maSBden_field;
	}

	public JTextField getNgayBay_field() {
		return ngayBay_field;
	}

	public void setNgayBay_field(JTextField ngayBay_field) {
		this.ngayBay_field = ngayBay_field;
	}

	public JPanel getPanel_QLLB() {
		return panel_QLLB;
	}

	public void setPanel_QLLB(JPanel panel_QLLB) {
		this.panel_QLLB = panel_QLLB;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String connStr = "jdbc:mysql://127.0.0.1/QLBVMB?user=root&password=bqt110500";
			conn = DriverManager.getConnection(connStr);
//			System.out.println("Ket noi thanh cong");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ket noi khong thanh cong");
		}
		return conn;
	}
	
	
	public void showLichBay() throws SQLException {
		ChuyenBay_Edit cb_edit = new ChuyenBay_Edit();
		String col_QLLB[] = {"Mã Chuyến Bay","Mã Máy Bay","MãSB Đi", "MãSB Đến", "Ngày Bay"};  
		model_QLLB = new DefaultTableModel(null, col_QLLB);
		table_QLLB = new JTable(model_QLLB);
		table_QLLB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
		table_QLLB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_QLLB.setSurrendersFocusOnKeystroke(true);
		// table quan li lich bay
		for(ChuyenBay c : cb_edit.getListFlights()) {
			if(c.getMaSBdi() == null) {
				c.setMaSBdi("");
			}
			if(c.getMaSBden() == null) {
				c.setMaSBden("");
			}
			model_QLLB.addRow(new Object[] {
					c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
			});

		}
	}
	
	public void showFieldChuyenBay(DefaultTableModel model) {
//		DefaultTableModel model = (DefaultTableModel) table_QLLB.getModel();
		table_QLLB.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_QLLB.getSelectedRow();
				String valueMaCB = model.getValueAt(row, 0).toString();
				String valueMaMB = model.getValueAt(row, 1).toString();
				String valueMaSBdi = model.getValueAt(row, 2).toString();
				if(valueMaSBdi == "") {
					valueMaSBdi = "None";
					maSBdi_field.setForeground(Color.RED);
				}
				else{
					maSBdi_field.setForeground(Color.BLACK);
				}
				String valueMaSBden = model.getValueAt(row, 3).toString();
				if(valueMaSBden == "") {
					valueMaSBden = "None";
					maSBden_field.setForeground(Color.RED);
				}
				else{
					maSBden_field.setForeground(Color.BLACK);
				}
				String valueNgayBay = model.getValueAt(row, 4).toString();

				maCB_field.setText(valueMaCB);
				maMB_field.setText(valueMaMB);
				maSBdi_field.setText(valueMaSBdi);
				maSBden_field.setText(valueMaSBden);
				ngayBay_field.setText(valueNgayBay);
			}
		});
	}

	public JPanel getPanel_Ve() {
		return panel_Ve;
	}

	public void setPanel_Ve(JPanel panel_Ve) {
		this.panel_Ve = panel_Ve;
	}
	
	public void showVe() throws SQLException {
		Ve_Edit ve_edit = new Ve_Edit();
		String col_Ve[] = {"Mã Vé","Mã Chuyến Bay","Tên Hành Khách", "Passport", "Giá Vé"};  
		model_Ve = new DefaultTableModel(null, col_Ve);
		table_Ve = new JTable(model_Ve);
		table_Ve.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
		table_Ve.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_Ve.setSurrendersFocusOnKeystroke(true);
		
		// table quan li lich bay
		for(Ve v : ve_edit.getListTickets()) {
			model_Ve.addRow(new Object[] {
					v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
			});
		}
	}
	
	public void showFieldVe(DefaultTableModel model) {
		table_Ve.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_Ve.getSelectedRow();
				String valueMaVe = model.getValueAt(row, 0).toString();
				String valueMaCB = model.getValueAt(row, 1).toString();
				String valueTenHK = model.getValueAt(row, 2).toString();
				String valuePassport = model.getValueAt(row, 3).toString();
				String valueGiaVe = model.getValueAt(row, 4).toString();

				maCBVe_field.setText(valueMaCB);
				maVe_field.setText(valueMaVe);
				tenHK_field.setText(valueTenHK);
				passport_field.setText(valuePassport);
				gia_field.setText(valueGiaVe);
			}
		});
	}

	public JPanel getPanel_MB() {
		return panel_MB;
	}

	public void setPanel_MB(JPanel panel_MB) {
		this.panel_MB = panel_MB;
	}
	
	public void showMayBay() throws SQLException {
		MayBay_Edit mb_edit = new MayBay_Edit();
		String col_MB[] = {"Mã Máy Bay", "Loại", "Hãng", "Số Ghế"};  
		model_MB = new DefaultTableModel(null, col_MB);
		table_MB = new JTable(model_MB);
		table_MB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		table_MB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_MB.setSurrendersFocusOnKeystroke(true);
		
		// table quan li lich bay
		for(MayBay m : mb_edit.getListPlanes()) {
			model_MB.addRow(new Object[] {
					m.getMaMB(), m.getLoai(), m.getHang(), m.getSoGhe()
			});
		}
	}
	
	public void showFieldMB(DefaultTableModel model) {
		table_MB.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_MB.getSelectedRow();
				String valueMaMB = model.getValueAt(row, 0).toString();
				String valueLoai = model.getValueAt(row, 1).toString();
				String valueHang = model.getValueAt(row, 2).toString();
				String valueSoGhe = model.getValueAt(row, 3).toString();


				idPlane_field.setText(valueMaMB);
				typeOfPlane_field.setText(valueLoai);
				airline_field.setText(valueHang);
				numOfChair_field.setText(valueSoGhe);
			}
		});
	}

	public JPanel getPanel_SanBay() {
		return panel_SanBay;
	}

	public void setPanel_SanBay(JPanel panel_SanBay) {
		this.panel_SanBay = panel_SanBay;
	}
	
	public void showSanBay() throws SQLException {
		SanBay_Edit sb_edit = new SanBay_Edit();
		String col_SB[] = {"Mã Sân Bay", "Tên Sân Bay", "Quốc Gia"};  
		model_SB = new DefaultTableModel(null, col_SB);
		table_SB = new JTable(model_SB);
		table_SB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		table_SB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_SB.setSurrendersFocusOnKeystroke(true);
		
		// table quan li lich bay
		for(SanBay s : sb_edit.getListAirports()) {
			model_SB.addRow(new Object[] {
					s.getMaSB(), s.getTenSB(), s.getQuocGia()
			});
		}
	}
	
	public void showFieldSB(DefaultTableModel model) {
		table_SB.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_SB.getSelectedRow();
				String valueMaSB = model.getValueAt(row, 0).toString();
				String valueTenSB = model.getValueAt(row, 1).toString();
				String valueQuocGia = model.getValueAt(row, 2).toString();


				maSB_field.setText(valueMaSB);
				tenSB_field.setText(valueTenSB);
				quocGia_field.setText(valueQuocGia);
			}
		});
	}

	public JPanel getPanel_NV() {
		return panel_NV;
	}

	public void setPanel_NV(JPanel panel_NV) {
		this.panel_NV = panel_NV;
	}
	
	public void showNhanVien() throws SQLException {
		NhanVien_Edit nv_edit = new NhanVien_Edit();
		String col_NV[] = {"Mã Nhân Viên", "Họ Tên", "Lương", "Ngày Sinh", "Mã Sân Bay"};  
		model_NV = new DefaultTableModel(null, col_NV);
		table_NV = new JTable(model_NV);
		table_NV.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		table_NV.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_NV.setSurrendersFocusOnKeystroke(true);
		
		// table quan li lich bay
		for(NhanVien nv : nv_edit.getListEmp()) {
			model_NV.addRow(new Object[] {
					nv.getMaNV(), nv.getHoTen(), nv.getLuong(), nv.getNgaySinh(), nv.getMaSB()
			});
		}
	}
	
	public void showFieldNV(DefaultTableModel model) {
		table_NV.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_NV.getSelectedRow();
				String valueMaNV = model.getValueAt(row, 0).toString();
				String valueTenNV = model.getValueAt(row, 1).toString();
				String valueLuong = model.getValueAt(row, 2).toString();
				String valueNgaySinh = model.getValueAt(row, 3).toString();
				String valueMaSB = model.getValueAt(row, 4).toString();


				maNV_field.setText(valueMaNV);
				hoTen_field.setText(valueTenNV);
				luong_field.setText(valueLuong);
				ngaySinh_field.setText(valueNgaySinh);
				maSB_NV_field.setText(valueMaSB);
			}
		});
	}
}

















