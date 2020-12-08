package Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ChuyenBay {
	private String maCB, maMB, maSBdi, maSBden;
	private Date ngayBay;
	
	public ChuyenBay() {
		// TODO Auto-generated constructor stub
		this.maCB = new String();
		this.maMB = new String();
		this.maSBdi = new String();
		this.maSBden = new String();
		this.ngayBay = new Date(0, 0, 0);
	}
	
	public ChuyenBay(String maCB, String maMB, String maSBdi, String maSBden, Date ngayBay){
		this.maCB = maCB;
		this.maMB = maMB;
		this.maSBdi = maSBdi;
		this.maSBden = maSBden;
		this.ngayBay = ngayBay;
	}

	public String getMaCB() {
		return maCB;
	}

	public void setMaCB(String maCB) {
		this.maCB = maCB;
	}

	public String getMaMB() {
		return maMB;
	}

	public void setMaMB(String maMB) {
		this.maMB = maMB;
	}

	public String getMaSBdi() {
		return maSBdi;
	}

	public void setMaSBdi(String maSBdi) {
		this.maSBdi = maSBdi;
	}

	public String getMaSBden() {
		return maSBden;
	}

	public void setMaSBden(String maSBden) {
		this.maSBden = maSBden;
	}

	public Date getNgayBay() {
		return ngayBay;
	}

	public void setNgayBay(Date ngayBay) {
		this.ngayBay = ngayBay;
	}
	
}












