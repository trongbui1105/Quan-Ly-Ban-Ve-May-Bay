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

public class NhanVien {
	private String maNV, hoTen, maSB;
	private int luong;
	private Date ngaySinh;
	
	public NhanVien() {
		this.maNV = "";
		this.hoTen = "";
		this.maSB = "";
		this.luong = 0;
		this.ngaySinh = new Date(0, 0, 0);
	}
	
	public NhanVien(String maNV, String hoTen, String maSB, int luong, Date ngaySinh) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.maSB = maSB;
		this.luong = luong;
		this.ngaySinh = ngaySinh;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaSB() {
		return maSB;
	}

	public void setMaSB(String maSB) {
		this.maSB = maSB;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
	
}
