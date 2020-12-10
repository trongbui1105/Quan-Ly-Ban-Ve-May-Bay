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

	private JPanel contentPane, panel_LichBay, panel_Ve, panel_QLLB, panel_MB;
	private JButton lichBay_btn, ve_btn, qllichBay_btn, sanBay_btn, exit_btn, nhanVien_btn, mayBay_btn;
	private JTable table_LB, table_Ve, table_QLLB, table_MB;
	private JScrollPane scrollPane_LB, scrollPane_Ve, scrollPane_QLLB, scrollPane_MB;
	private DefaultTableModel model_LB, model_Ve, model_QLLB, model_MB;
	private JTextField CB_Field;
	private JTextField maVe_field;
	private JTextField tenHK_field;
	private JTextField passport_field;
	private JTextField gia_field;
	private JLabel lbl_MACB;
	private JTextField maCB_field;
	private JTextField maMB_field;
	private JTextField maSBdi_field;
	private JTextField maSBden_field;
	private JTextField ngayBay_field;
	private JTextField idPlane_field;
	private JTextField type_field;
	private JTextField airLine_field;
	private JTextField numOfChair_field;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					
					frame.setVisible(true);
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
			}
		});
		
		// san bay button
		sanBay_btn = new JButton("Sân Bay");
		sanBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		sanBay_btn.setBounds(19, 297, 125, 40);
		panel_function.add(sanBay_btn);
		
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
			}
		});
		
		// panel quan li lich bay
		panel_QLLB = new JPanel();
		panel_QLLB.setBounds(170, 120, 644, 498);
		contentPane.add(panel_QLLB);
		panel_QLLB.setLayout(null);
		
		lbl_MACB = new JLabel("Mã Chuyến Bay");
		lbl_MACB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MACB.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_MACB.setBounds(10, 10, 120, 19);
		panel_QLLB.add(lbl_MACB);
		
		maCB_field = new JTextField();
		maCB_field.setColumns(10);
		maCB_field.setBounds(141, 3, 192, 36);
		panel_QLLB.add(maCB_field);
		
		JLabel lbl_MAMB = new JLabel("Mã Máy Bay");
		lbl_MAMB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MAMB.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_MAMB.setBounds(11, 51, 120, 19);
		panel_QLLB.add(lbl_MAMB);
		
		JLabel lbl_MASBdi = new JLabel("Mã Sân Bay Đi");
		lbl_MASBdi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MASBdi.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_MASBdi.setBounds(10, 92, 120, 19);
		panel_QLLB.add(lbl_MASBdi);
		
		JLabel lbl_MASBden = new JLabel("Mã Sân Bay Đến");
		lbl_MASBden.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MASBden.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_MASBden.setBounds(11, 135, 120, 19);
		panel_QLLB.add(lbl_MASBden);
		
		JLabel lbl_NgayBay = new JLabel("Ngày Bay");
		lbl_NgayBay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NgayBay.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbl_NgayBay.setBounds(9, 181, 120, 19);
		panel_QLLB.add(lbl_NgayBay);
		
		maMB_field = new JTextField();
		maMB_field.setColumns(10);
		maMB_field.setBounds(141, 42, 192, 36);
		panel_QLLB.add(maMB_field);
		
		maSBdi_field = new JTextField();
		maSBdi_field.setColumns(10);
		maSBdi_field.setBounds(141, 83, 192, 36);
		panel_QLLB.add(maSBdi_field);
		
		maSBden_field = new JTextField();
		maSBden_field.setColumns(10);
		maSBden_field.setBounds(141, 128, 192, 36);
		panel_QLLB.add(maSBden_field);
		
		ngayBay_field = new JTextField();
		ngayBay_field.setColumns(10);
		ngayBay_field.setBounds(141, 172, 192, 36);
		panel_QLLB.add(ngayBay_field);
		
		// check ma chuyen bay button
		JButton checkMaCB_btn = new JButton("Check");
		checkMaCB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkMaCB_btn.setBounds(349, 10, 117, 29);
		panel_QLLB.add(checkMaCB_btn);
		
		ChuyenBay_Edit cb_edit = new ChuyenBay_Edit();
		String col_QLLB[] = {"Mã Chuyến Bay","Mã Máy Bay","MãSB Đi", "MãSB Đến", "Ngày Bay"};  
		model_QLLB = new DefaultTableModel(null, col_QLLB);
		table_QLLB = new JTable(model_QLLB);
		table_QLLB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table_QLLB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_QLLB.setSurrendersFocusOnKeystroke(true);
		
		// table quan li lich bay
		for(ChuyenBay c : cb_edit.getListFlights()) {
			model_QLLB.addRow(new Object[] {
					c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
			});
		}
		
		scrollPane_QLLB = new JScrollPane(table_QLLB);
		scrollPane_QLLB.setBounds(0, 230, 645, 269);
		panel_QLLB.add(scrollPane_QLLB);
		

//		cb_edit.showField();
		showFieldChuyenBay();
		
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
				
//				try {
//					DefaultTableModel model_QLLB_1 = new DefaultTableModel();
//					for(ChuyenBay c : cb_edit.getListFlights()) {
//						model_QLLB_1.addRow(new Object[] {
//								c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
//						});
//					}
//					table_QLLB = new JTable(model_QLLB_1);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		
		
		JButton insertFlights_btn = new JButton("Thêm Chuyến Bay");
		insertFlights_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCB = maCB_field.getText();
				String maMB = maMB_field.getText();
				String maSBdi = maSBdi_field.getText();
				String maSBden = maSBden_field.getText();
				String ngayBay = ngayBay_field.getText();
				cb_edit.insertFlight(maCB, maMB, maSBdi, maSBden, ngayBay);
				try {
					for(ChuyenBay c : cb_edit.getListFlights()) {
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
		insertFlights_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		insertFlights_btn.setBounds(430, 50, 199, 35);
		panel_QLLB.add(insertFlights_btn);
		
		JButton modifyFlights_btn = new JButton("Sửa Chuyến Bay");
		modifyFlights_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifyFlights_btn.setBounds(430, 93, 199, 35);
		panel_QLLB.add(modifyFlights_btn);
		
		JLabel lblExample = new JLabel("VD: YYYY/MM/DD");
		lblExample.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblExample.setHorizontalAlignment(SwingConstants.CENTER);
		lblExample.setBounds(330, 174, 124, 33);
		panel_QLLB.add(lblExample);
		panel_QLLB.setVisible(false);
		
		// panel may bay
		panel_MB = new JPanel();
		panel_MB.setBounds(170, 120, 644, 498);
		contentPane.add(panel_MB);
		panel_MB.setLayout(null);
		panel_MB.setVisible(false);
		
		
		JLabel lblMaMB = new JLabel("Mã Máy Bay");
		lblMaMB.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaMB.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMaMB.setBounds(16, 11, 103, 24);
		panel_MB.add(lblMaMB);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoai.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLoai.setBounds(20, 58, 87, 24);
		panel_MB.add(lblLoai);
		
		JLabel lblHang = new JLabel("Hãng");
		lblHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblHang.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHang.setBounds(19, 105, 87, 24);
		panel_MB.add(lblHang);
		
		JLabel lblSoGhe = new JLabel("Số Ghế");
		lblSoGhe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoGhe.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSoGhe.setBounds(20, 150, 87, 24);
		panel_MB.add(lblSoGhe);
		
		idPlane_field = new JTextField();
		idPlane_field.setBounds(137, 6, 187, 33);
		panel_MB.add(idPlane_field);
		idPlane_field.setColumns(10);
		
		type_field = new JTextField();
		type_field.setColumns(10);
		type_field.setBounds(137, 54, 187, 33);
		panel_MB.add(type_field);
		
		airLine_field = new JTextField();
		airLine_field.setColumns(10);
		airLine_field.setBounds(137, 101, 187, 33);
		panel_MB.add(airLine_field);
		
		numOfChair_field = new JTextField();
		numOfChair_field.setColumns(10);
		numOfChair_field.setBounds(137, 149, 187, 33);
		panel_MB.add(numOfChair_field);
		
		// check button Ma May Bay
		JButton checkMaMB_btn = new JButton("Check");
		checkMaMB_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkMaMB_btn.setBounds(336, 9, 117, 29);
		panel_MB.add(checkMaMB_btn);
		
		// button them may bay
		JButton addPlane_btn = new JButton("Thêm Máy Bay");
		addPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		addPlane_btn.setBounds(432, 51, 199, 35);
		panel_MB.add(addPlane_btn);
		
		// button sua may bay
		JButton modifyPlane_btn = new JButton("Sửa Máy Bay");
		modifyPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		modifyPlane_btn.setBounds(429, 96, 199, 35);
		panel_MB.add(modifyPlane_btn);
		
		// button xoa may bay
		JButton deletePlane_btn = new JButton("Xoá Máy Bay");
		deletePlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		deletePlane_btn.setBounds(429, 138, 199, 35);
		panel_MB.add(deletePlane_btn);
		
		// button reset may bay
		JButton resetPlane_btn = new JButton("RESET");
		resetPlane_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		resetPlane_btn.setBounds(470, 183, 118, 31);
		panel_MB.add(resetPlane_btn);
		
		String col_MB[] = {"Mã Máy Bay","Loại","Hãng", "Số Ghế"};  
		
		// table may bay
		MayBay_Edit mb_edit = new MayBay_Edit();
		model_MB = new DefaultTableModel(null, col_MB);
		table_MB = new JTable(model_MB);
		table_MB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table_MB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_MB.setSurrendersFocusOnKeystroke(true);
		for(MayBay mb : mb_edit.getListPlanes()) {
			model_MB.addRow(new Object[] {
					mb.getMaMB(), mb.getLoai(), mb.getHang(), mb.getSoGhe()
			});
		}
		scrollPane_MB = new JScrollPane(table_MB);
		scrollPane_MB.setBounds(0, 232, 645, 267);
		panel_MB.add(scrollPane_MB);
		

		
		
		// panel Ve
		panel_Ve = new JPanel();
		panel_Ve.setBounds(170, 120, 644, 498);
		contentPane.add(panel_Ve);
		panel_Ve.setLayout(null);
		panel_Ve.setVisible(false);
		
		CB_Field = new JTextField();
		CB_Field.setBounds(144, 4, 192, 36);
		panel_Ve.add(CB_Field);
		CB_Field.setColumns(10);
		
		JLabel lbl_CB = new JLabel("Chuyến Bay");
		lbl_CB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CB.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbl_CB.setBounds(6, 12, 100, 19);
		panel_Ve.add(lbl_CB);
		
		JButton check_btn = new JButton("Check");
		check_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		check_btn.setBounds(347, 9, 117, 29);
		panel_Ve.add(check_btn);
		
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
		
		maVe_field = new JTextField();
		maVe_field.setColumns(10);
		maVe_field.setBounds(145, 53, 192, 36);
		panel_Ve.add(maVe_field);
		
		tenHK_field = new JTextField();
		tenHK_field.setColumns(10);
		tenHK_field.setBounds(145, 103, 253, 36);
		panel_Ve.add(tenHK_field);
		
		passport_field = new JTextField();
		passport_field.setColumns(10);
		passport_field.setBounds(146, 150, 192, 36);
		panel_Ve.add(passport_field);
		
		gia_field = new JTextField();
		gia_field.setColumns(10);
		gia_field.setBounds(145, 197, 192, 36);
		panel_Ve.add(gia_field);
		
		JButton addTicket_btn = new JButton("Thêm Vé");
		addTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		addTicket_btn.setBounds(509, 59, 117, 29);
		panel_Ve.add(addTicket_btn);
		
		JButton modifyTicket_btn = new JButton("Sửa Vé");
		modifyTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		modifyTicket_btn.setBounds(509, 109, 117, 29);
		panel_Ve.add(modifyTicket_btn);
		
		JButton deleteTicket_btn = new JButton("Xoá Vé");
		deleteTicket_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		deleteTicket_btn.setBounds(510, 158, 117, 29);
		panel_Ve.add(deleteTicket_btn);
		
		JButton reset_btn = new JButton("Reset");
		reset_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		reset_btn.setBounds(509, 206, 117, 29);
		panel_Ve.add(reset_btn);
		
		// table Ve
		String col_Ve[] = {"Mã Vé","Mã Chuyến Bay","Tên Hành Khách", "Passport", "Giá Vé"};  
		model_Ve = new DefaultTableModel(null, col_Ve);
		table_Ve = new JTable(model_Ve);
		table_Ve.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table_Ve.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_Ve.setSurrendersFocusOnKeystroke(true);
		Ve_Edit vEdit = new Ve_Edit();
		for(Ve v : vEdit.getListTickets()) {
			model_Ve.addRow(new Object[] {
					v.getMaVe(), v.getMaCB(), v.getTenHK(), v.getPassport(), v.getGiaVe()
			});
		}
		scrollPane_Ve = new JScrollPane(table_Ve);
		scrollPane_Ve.setBounds(1, 235, 644, 263);
		panel_Ve.add(scrollPane_Ve);
		
		JLabel lblUSD = new JLabel("USD");
		lblUSD.setHorizontalAlignment(SwingConstants.CENTER);
		lblUSD.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
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
		table_LB.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table_LB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_LB.setSurrendersFocusOnKeystroke(true);
		for(ChuyenBay c : cb_edit.getListFlights()) {
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
			System.out.println("Ket noi thanh cong");
		}
		catch (Exception e) {
			System.out.println("Ket noi khong thanh cong");
		}
		return conn;
	}
	
	public void showFieldChuyenBay() {
//		try {
//			int row = table_QLLB.getSelectedRow();
//			String valueMaCB = (String) model_QLLB.getValueAt(row, 0);
//			String valueMaMB = (String) model_QLLB.getValueAt(row, 1);
//			String valueMaSBdi = (String) model_QLLB.getValueAt(row, 2);
//			String valueMaSBden = (String) model_QLLB.getValueAt(row, 3);
//			String valueNgayBay = (String) model_QLLB.getValueAt(row, 4);
//
//			maCB_field.setText(valueMaCB);
//			maMB_field.setText(valueMaMB);
//			maSBdi_field.setText(valueMaSBdi);
//			maSBden_field.setText(valueMaSBden);
//			ngayBay_field.setText(valueNgayBay);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
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
				String valueMaCB = model_QLLB.getValueAt(row, 0).toString();
				String valueMaMB = model_QLLB.getValueAt(row, 1).toString();
				String valueMaSBdi = model_QLLB.getValueAt(row, 2).toString();
				String valueMaSBden = model_QLLB.getValueAt(row, 3).toString();
				String valueNgayBay = model_QLLB.getValueAt(row, 4).toString();

				maCB_field.setText(valueMaCB);
				maMB_field.setText(valueMaMB);
				maSBdi_field.setText(valueMaSBdi);
				maSBden_field.setText(valueMaSBden);
				ngayBay_field.setText(valueNgayBay);
			}
		});
	}
	
}

















