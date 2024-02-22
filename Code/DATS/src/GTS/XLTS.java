package GTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.util.DnsSrv.SrvRecord;

public class XLTS implements IThisinh {

	private Connection cn;
	public static Connection getCon() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/dlts","root","1234567890");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}
		return cn;
	}
	
	
	
	@Override
	public ArrayList<ThiSinh> getTS() {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql = "Select * from tbthisinh";
		ArrayList<ThiSinh> lsT = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThiSinh t = new ThiSinh();
				t.setSoBD(rs.getString("SoBD"));
				t.setHoTen(rs.getString("HoTen"));
				t.setGT(rs.getString("GT"));
				t.setNganhH(rs.getString("NganhH"));
				t.setTongD(rs.getDouble("TongD"));
				lsT.add(t);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return lsT;
	}

	@Override
	public boolean insertTS(String SoBD, String HoTen, String GT, String NganhH, double TongD) {
		Connection cn = getCon();
		String sql = "Insert into tbthisinh(SoBD, HoTen,GT,NganhH,TongD) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, SoBD);
			ps.setString(2, HoTen);
			ps.setString(3, GT);
			ps.setString(4, NganhH);
			ps.setDouble(5, TongD);
		//	ps.setString(6, Hocbong());
			ps.executeUpdate();
			cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	



	public static void main(String[] args) {
		System.out.println(getCon());
	}

}
