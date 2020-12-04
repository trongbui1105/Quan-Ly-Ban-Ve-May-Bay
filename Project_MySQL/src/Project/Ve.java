package Project;

public class Ve {
	private String maVe, maCB, tenHK, passport;
	private int giaVe;
	
	public Ve() {
		this.maVe = "";
		this.maCB = "";
		this.tenHK = "";
		this.giaVe = 0;
		this.passport = "";
	}
	
	public Ve(String maVe, String maCB, String tenHK, int giaVe, String passport) {
		this.maVe = maVe;
		this.maCB = maCB;
		this.tenHK = tenHK;
		this.giaVe = giaVe;
		this.passport = passport;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public String getMaCB() {
		return maCB;
	}

	public void setMaCB(String maCB) {
		this.maCB = maCB;
	}

	public String getTenHK() {
		return tenHK;
	}

	public void setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
	
	
	
}
