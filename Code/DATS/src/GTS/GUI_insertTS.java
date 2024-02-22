package GTS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_insertTS extends JFrame {

	private JPanel contentPane;
	private JTextField tfSBD;
	private JTextField tfHoTen;
	private JTextField tfTongD;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTable jtbThisinh;
	private XLTS xl = new XLTS();
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private ArrayList<ThiSinh> lsThisinh;
	
	
	//in bảng
	public void getAllThiSinh() {
		lsThisinh = xl.getTS();
		for(int i=0;i<lsThisinh.size();i++) {
			ThiSinh t = lsThisinh.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getSoBD());
			tbRow.add(t.getHoTen());
			tbRow.add(t.getGT());
			tbRow.add(t.getNganhH());
			tbRow.add(t.getTongD());
			tbRow.add(t.Hocbong());
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		jtbThisinh.setModel(dtm);
		}
		
		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_insertTS frame = new GUI_insertTS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_insertTS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SoBD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(93, 21, 55, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblHoten = new JLabel("HoTen");
		lblHoten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoten.setBounds(93, 65, 55, 55);
		contentPane.add(lblHoten);
		
		JLabel lblGt = new JLabel("GT");
		lblGt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGt.setBounds(93, 130, 55, 44);
		contentPane.add(lblGt);
		
		JLabel lblNganhh = new JLabel("NganhH");
		lblNganhh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNganhh.setBounds(93, 184, 55, 55);
		contentPane.add(lblNganhh);
		
		JLabel lblTongd = new JLabel("TongD");
		lblTongd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTongd.setBounds(93, 249, 55, 55);
		contentPane.add(lblTongd);
		
		tfSBD = new JTextField();
		tfSBD.setBounds(171, 21, 307, 36);
		contentPane.add(tfSBD);
		tfSBD.setColumns(10);
		
		tfHoTen = new JTextField();
		tfHoTen.setColumns(10);
		tfHoTen.setBounds(171, 77, 307, 36);
		contentPane.add(tfHoTen);
		
		tfTongD = new JTextField();
		tfTongD.setColumns(10);
		tfTongD.setBounds(171, 261, 307, 36);
		contentPane.add(tfTongD);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		buttonGroup.add(rdNam);
		rdNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdNam.setBounds(171, 130, 88, 44);
		contentPane.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		buttonGroup.add(rdNu);
		rdNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdNu.setBounds(311, 130, 88, 44);
		contentPane.add(rdNu);
		
		JComboBox cbNganhH = new JComboBox();
		cbNganhH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNganhH.setModel(new DefaultComboBoxModel(new String[] {"Trí tuệ nhân tạo", "Cơ khí", "Công trình thuỷ"}));
		cbNganhH.setBounds(171, 192, 307, 36);
		contentPane.add(cbNganhH);
		
		JButton btnNewButton = new JButton("Thêm thí sinh mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sbd = tfSBD.getText();
				String ht = tfHoTen.getText();
				String gt;
				if(rdNam.isSelected()) {
					gt="Nam";
				}else {
					gt="Nữ";
				}
				String nganhH = cbNganhH.getSelectedItem().toString();
				double tongd = Double.parseDouble(tfTongD.getText());
				InsertThiSinh(sbd, ht, gt, nganhH, tongd);
				dtm.setNumRows(0);
				getAllThiSinh();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(507, 104, 158, 55);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 309, 602, 196);
		contentPane.add(scrollPane);
		
		jtbThisinh = new JTable();
		scrollPane.setViewportView(jtbThisinh);
		
		columns.add("Số báo danh");
		columns.add("Họ tên");
		columns.add("Giới tính");
		columns.add("Ngành học");
		columns.add("Tổng điểm");
		columns.add("Học bổng");
		getAllThiSinh();
	}
	
	public void InsertThiSinh(String SoBD, String HoTen, String GT, String NganhH, double TongD) {
		xl.insertTS(SoBD, HoTen, GT, NganhH, TongD);
	}
}
