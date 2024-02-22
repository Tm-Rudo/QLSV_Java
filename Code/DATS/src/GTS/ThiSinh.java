package GTS;

public class ThiSinh {
	private String SoBD, HoTen, GT, NganhH;
	private double TongD;
	public String getSoBD() {
		return SoBD;
	}
	public void setSoBD(String soBD) {
		SoBD = soBD;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGT() {
		return GT;
	}
	public void setGT(String gT) {
		GT = gT;
	}
	public String getNganhH() {
		return NganhH;
	}
	public void setNganhH(String nganhH) {
		NganhH = nganhH;
	}
	public double getTongD() {
		return TongD;
	}
	public void setTongD(double tongD) {
		TongD = tongD;
	}
	public ThiSinh(String soBD, String hoTen, String gT, String nganhH, double tongD) {
		super();
		SoBD = soBD;
		HoTen = hoTen;
		GT = gT;
		NganhH = nganhH;
		TongD = tongD;
	}
	public ThiSinh() {
		super();
	}
	
	public String Hocbong() {
		if (TongD >=29) {
			return "HB";	
		}
		return "";
	}
}
