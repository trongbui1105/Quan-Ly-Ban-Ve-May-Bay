package Project;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {

	private JPanel contentPane, panel_LichBay, panel_Ve, panel_QLLB;
	private JButton LichBay_btn, Ve_btn, QLLichBay_btn, SanBay_btn, Exit_btn, NhanVien_btn, MayBay_btn;
	private JTable table, table_Ve;
	private JScrollPane pane, scrollPane_Ve;
	private DefaultTableModel model, model_Ve;
	private JTextField CB_Field;
	private JTextField maVe_field;
	private JTextField tenHK_field;
	private JTextField passport_field;
	private JTextField gia_field;
	private JLabel lbl_MACB;
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
		
		JPanel panel_function = new JPanel();
		panel_function.setBorder(null);
		panel_function.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		panel_function.setBounds(0, 120, 172, 499);
		contentPane.add(panel_function);
		panel_function.setLayout(null);
		
		LichBay_btn = new JButton("Lịch Bay");
		LichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		LichBay_btn.setBounds(19, 35, 125, 40);
		panel_function.add(LichBay_btn);
		LichBay_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(true);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(false);
			}
		});
		
		Ve_btn = new JButton("Vé");
		Ve_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		Ve_btn.setBounds(19, 96, 125, 40);
		panel_function.add(Ve_btn);
		Ve_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(true);
				panel_QLLB.setVisible(false);
			}
		});
		
		QLLichBay_btn = new JButton("Quản Lý Lịch Bay");
		QLLichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		QLLichBay_btn.setBounds(19, 159, 125, 40);
		panel_function.add(QLLichBay_btn);
		QLLichBay_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_LichBay.setVisible(false);
				panel_Ve.setVisible(false);
				panel_QLLB.setVisible(true);
			}
		});
		
		SanBay_btn = new JButton("Sân Bay");
		SanBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		SanBay_btn.setBounds(19, 297, 125, 40);
		panel_function.add(SanBay_btn);
		
		Exit_btn = new JButton("Thoát");
		Exit_btn.setForeground(Color.RED);
		Exit_btn.setFont(new Font("Apple Color Emoji", Font.PLAIN, 22));
		Exit_btn.setBounds(19, 426, 125, 40);
		panel_function.add(Exit_btn);
		
		NhanVien_btn = new JButton("Nhân Viên");
		NhanVien_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		NhanVien_btn.setBounds(19, 360, 125, 40);
		panel_function.add(NhanVien_btn);
		
		MayBay_btn = new JButton("Máy Bay");
		MayBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		MayBay_btn.setBounds(19, 227, 125, 40);
		panel_function.add(MayBay_btn);
		
		panel_QLLB = new JPanel();
		panel_QLLB.setBounds(170, 120, 644, 498);
		contentPane.add(panel_QLLB);
		panel_QLLB.setLayout(null);
		
		lbl_MACB = new JLabel("Mã Chuyến Bay");
		lbl_MACB.setBounds(10, 10, 101, 18);
		panel_QLLB.add(lbl_MACB);
		panel_QLLB.setVisible(false);
		
		panel_Ve = new JPanel();
		panel_Ve.setForeground(Color.BLACK);
		panel_Ve.setBackground(Color.WHITE);
		panel_Ve.setBounds(170, 120, 644, 498);
		contentPane.add(panel_Ve);
		panel_Ve.setLayout(null);
		panel_Ve.setVisible(false);
		
		CB_Field = new JTextField();
		CB_Field.setBounds(144, 4, 192, 36);
		panel_Ve.add(CB_Field);
		CB_Field.setColumns(10);
		
		JLabel lblChuynBay = new JLabel("Chuyến Bay");
		lblChuynBay.setHorizontalAlignment(SwingConstants.CENTER);
		lblChuynBay.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChuynBay.setBounds(6, 12, 100, 19);
		panel_Ve.add(lblChuynBay);
		
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
		
		
		panel_LichBay = new JPanel();
		panel_LichBay.setBounds(170, 120, 644, 498);
		contentPane.add(panel_LichBay);
		panel_LichBay.setLayout(null);


		String col[] = {"Mã Chuyến Bay","Mã Máy Bay","MãSB Đi", "MãSB Đến", "Ngày Bay"};  

		ChuyenBay_Edit cb_edit = new ChuyenBay_Edit();
		model = new DefaultTableModel(null, col);
		
		table = new JTable(model);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		for(ChuyenBay c : cb_edit.getListFlights()) {
			model.addRow(new Object[] {
					c.getMaCB(), c.getMaMB(), c.getMaSBdi(), c.getMaSBden(), c.getNgayBay()
			});
		}

		pane = new JScrollPane(table);
		pane.setBounds(0, 79, 644, 420);
		panel_LichBay.add(pane);
		
		
		JLabel lblLchBay = new JLabel("Lịch Bay");
		lblLchBay.setForeground(Color.RED);
		lblLchBay.setFont(new Font("Arial", Font.BOLD, 50));
		lblLchBay.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchBay.setBounds(78, 6, 493, 55);
		panel_LichBay.add(lblLchBay);
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

	public JButton getLichBay_btn() {
		return LichBay_btn;
	}

	public void setLichBay_btn(JButton lichBay_btn) {
		LichBay_btn = lichBay_btn;
	}

	public JButton getVe_btn() {
		return Ve_btn;
	}

	public void setVe_btn(JButton ve_btn) {
		Ve_btn = ve_btn;
	}

	public JButton getQLLichBay_btn() {
		return QLLichBay_btn;
	}

	public void setQLLichBay_btn(JButton qLLichBay_btn) {
		QLLichBay_btn = qLLichBay_btn;
	}

	public JButton getSanBay_btn() {
		return SanBay_btn;
	}

	public void setSanBay_btn(JButton sanBay_btn) {
		SanBay_btn = sanBay_btn;
	}

	public JButton getNhanVien_btn() {
		return NhanVien_btn;
	}

	public void setNhanVien_btn(JButton nhanVien_btn) {
		NhanVien_btn = nhanVien_btn;
	}

	public JButton getMayBay_btn() {
		return MayBay_btn;
	}

	public void setMayBay_btn(JButton mayBay_btn) {
		MayBay_btn = mayBay_btn;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}

















