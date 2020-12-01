package Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTable;

public class GUI extends JFrame {

	private JPanel contentPane;

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
	 */
	public GUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		final ImageIcon icon = new ImageIcon(GUI.class.getResource("/Project/image6.png"));
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
		
		JButton LichBay_btn = new JButton("Lịch Bay");
		LichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		LichBay_btn.setBounds(19, 35, 125, 40);
		panel_function.add(LichBay_btn);
		
		JButton Ve_btn = new JButton("Vé");
		Ve_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		Ve_btn.setBounds(19, 96, 125, 40);
		panel_function.add(Ve_btn);
		
		JButton QLLichBay_btn = new JButton("Quản Lý Lịch Bay");
		QLLichBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		QLLichBay_btn.setBounds(19, 159, 125, 40);
		panel_function.add(QLLichBay_btn);
		
		JButton SanBay_btn = new JButton("Sân Bay");
		SanBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		SanBay_btn.setBounds(19, 297, 125, 40);
		panel_function.add(SanBay_btn);
		
		JButton Exit_btn = new JButton("Thoát");
		Exit_btn.setForeground(Color.RED);
		Exit_btn.setFont(new Font("Apple Color Emoji", Font.PLAIN, 22));
		Exit_btn.setBounds(19, 426, 125, 40);
		panel_function.add(Exit_btn);
		
		JButton NhanVien_btn = new JButton("Nhân Viên");
		NhanVien_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		NhanVien_btn.setBounds(19, 360, 125, 40);
		panel_function.add(NhanVien_btn);
		
		JButton MayBay_btn = new JButton("Máy Bay");
		MayBay_btn.setFont(new Font("Arial", Font.PLAIN, 14));
		MayBay_btn.setBounds(19, 227, 125, 40);
		panel_function.add(MayBay_btn);
		
		JPanel panel_LichBay = new JPanel();
		panel_LichBay.setBounds(172, 120, 643, 499);
		contentPane.add(panel_LichBay);
		panel_LichBay.setLayout(null);

	}
}

















