package GTS;

import java.sql.Connection;
import java.util.ArrayList;

public interface IThisinh {
	static Connection getCon() {
		return getCon();
	}
	ArrayList<ThiSinh> getTS();
	
	boolean insertTS(String SoBD, String HoTen, String GT, String NganhH, double TongD);
}
