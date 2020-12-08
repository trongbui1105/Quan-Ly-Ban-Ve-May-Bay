package Project;

public class MayBay {
	private String maMB, loai, hang;
	private int soGhe;
	
	public MayBay() {
		this.maMB = "";
		this.loai = "";
		this.hang = "";
		this.soGhe = 0;
	}
	
	
	public MayBay(String maMB, String loai, String hang, int soGhe) {
		this.maMB = maMB;
		this.loai = loai;
		this.hang = hang;
		this.soGhe = soGhe;
	}


	public String getMaMB() {
		return maMB;
	}


	public void setMaMB(String maMB) {
		this.maMB = maMB;
	}


	public String getLoai() {
		return loai;
	}


	public void setLoai(String loai) {
		this.loai = loai;
	}


	public String getHang() {
		return hang;
	}


	public void setHang(String hang) {
		this.hang = hang;
	}


	public int getSoGhe() {
		return soGhe;
	}


	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
	
	
	
}
