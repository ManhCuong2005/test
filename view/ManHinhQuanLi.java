package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;

public class ManHinhQuanLi extends JFrame {

	private JPanel contentPane;
	public static JTextField jTextField_idNV;
	public static JTextField jTextField_nameNV;
	public static JTextField jTextField_tuoi;
	public static JTextField jTextField_luong;
	public static JComboBox<String> jComboBox_gioiTinh;
	public static JComboBox <String> comboBox_tinh;
	public static JTextField textField_findByID;
	public static JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhQuanLi frame = new ManHinhQuanLi();
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
	public ManHinhQuanLi() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\BaiTapCuoiKi\\restaurant-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 119, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Java-icon.png"));
		lblNewLabel.setBounds(20, 10, 80, 72);
		panel.add(lblNewLabel);
		
		JPanel panel_card = new JPanel();
		panel_card.setBounds(122, 0, 964, 663);
		contentPane.add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		
		JPanel panel_sp = new JPanel();
		panel_card.add(panel_sp, "name_68594078978699");
		panel_sp.setVisible(true);
		panel_sp.setLayout(null);
		
		JPanel panel_nv = new JPanel();
		panel_card.add(panel_nv, "name_68631275739599");
		panel_nv.setVisible(true);
		
		JPanel panel_kh = new JPanel();
		panel_card.add(panel_kh, "name_68639509310700");
		panel_kh.setVisible(true);
		panel_kh.setLayout(null);
		
		
		panel_card.add(panel_sp, "name_68594078978699");
		panel_card.add(panel_nv, "name_68631275739599");
		panel_card.add(panel_kh, "name_68639509310700");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 10, 899, 28);
		panel_sp.add(toolBar);
		
		JButton btnNewButton_1 = new JButton("Hiển thị");
		btnNewButton_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Pork-Chop-Set-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Thêm");
		btnNewButton_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\add-item-icon.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Remove-item-icon.png"));
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Sửa");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Pencil-icon.png"));
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1_2 = new JButton("Tìm kiếm");
		btnNewButton_1_1_1_1_1_1_1_2.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\search-icon.png"));
		btnNewButton_1_1_1_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(btnNewButton_1_1_1_1_1_1_1_2);
		panel_nv.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(320, 10, 319, 57);
		panel_nv.add(lblNewLabel_2);
		
		JButton jButton_addNhanVien = new JButton("Thêm");
		jButton_addNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO.getInstance().insert();
//				JOptionPane.showMessageDialog(null, "Bạn đã nhấn nút Thêm!");
				NhanVienDAO.getInstance().xoaForm();
			}
		});
		jButton_addNhanVien.setBounds(199, 461, 116, 26);
		panel_nv.add(jButton_addNhanVien);
		jButton_addNhanVien.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Male-user-add-icon.png"));
		jButton_addNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton_1_1_1_2 = new JButton("Xóa");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO.getInstance().delete();
//				JOptionPane.showMessageDialog(null, "Bạn đã nhấn nút Xóa!");
				NhanVienDAO.getInstance().xoaForm();
				NhanVienDAO.getInstance().selectAll();
			}
		});
		btnNewButton_1_1_1_2.setBounds(333, 461, 119, 26);
		panel_nv.add(btnNewButton_1_1_1_2);
		btnNewButton_1_1_1_2.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Actions-list-remove-user-icon.png"));
		btnNewButton_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Sửa");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO.getInstance().update();
//				JOptionPane.showMessageDialog(null, "Bạn đã nhấn nút Sửa!");
				NhanVienDAO.getInstance().xoaForm();
				NhanVienDAO.getInstance().selectAll();
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(468, 461, 119, 26);
		panel_nv.add(btnNewButton_1_1_1_1_1);
		btnNewButton_1_1_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Pencil-icon.png"));
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton_1_1_1_1_1_1_1_1 = new JButton("Tìm kiếm theo ID");
		btnNewButton_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				NhanVienDAO.getInstance().
//				NhanVienDAO.getInstance().selectAll();
				NhanVienDAO.getInstance().selectByID();
			}
		});
		btnNewButton_1_1_1_1_1_1_1_1.setBounds(734, 117, 177, 26);
		panel_nv.add(btnNewButton_1_1_1_1_1_1_1_1);
		btnNewButton_1_1_1_1_1_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\search-icon.png"));
		btnNewButton_1_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Nhập mã nhân viên:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 342, 141, 26);
		panel_nv.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhập tên nhân viên:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(10, 378, 141, 26);
		panel_nv.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nhập tuổi:");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(578, 342, 141, 26);
		panel_nv.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Nhập giới tính:");
		lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(10, 414, 141, 26);
		panel_nv.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Nhập lương:");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1.setBounds(578, 378, 141, 26);
		panel_nv.add(lblNewLabel_3_1_1_1_1);
		
		jTextField_idNV = new JTextField();
		jTextField_idNV.setBounds(161, 347, 182, 19);
		panel_nv.add(jTextField_idNV);
		jTextField_idNV.setColumns(10);
		
		jTextField_nameNV = new JTextField();
		jTextField_nameNV.setColumns(10);
		jTextField_nameNV.setBounds(161, 383, 182, 19);
		panel_nv.add(jTextField_nameNV);
		
		jTextField_tuoi = new JTextField();
		jTextField_tuoi.setColumns(10);
		jTextField_tuoi.setBounds(729, 347, 182, 19);
		panel_nv.add(jTextField_tuoi);
		
		jTextField_luong = new JTextField();
		jTextField_luong.setColumns(10);
		jTextField_luong.setBounds(729, 383, 182, 19);
		panel_nv.add(jTextField_luong);
		
		String [] gioiTinh = new String [] {"Nam", "Nữ"};
		jComboBox_gioiTinh = new JComboBox<String>(gioiTinh);
		jComboBox_gioiTinh.setBackground(new Color(128, 255, 255));
		jComboBox_gioiTinh.setBounds(161, 418, 182, 21);
		panel_nv.add(jComboBox_gioiTinh);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 105, 760, 19);
		panel_nv.add(separator);
		
		JLabel lblNewLabel_3_2 = new JLabel("Danh sách nhân viên");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3_2.setBounds(10, 87, 162, 26);
		panel_nv.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Nhập địa chỉ:");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1.setBounds(578, 414, 141, 26);
		panel_nv.add(lblNewLabel_3_1_1_1_1_1);
		
//		String [] gioiTinh = new String [] {"Nam", "Nữ"};
//		jComboBox_gioiTinh = new JComboBox<String>(gioiTinh);
//		jComboBox_gioiTinh.setBounds(161, 431, 182, 21);
//		panel_nv.add(jComboBox_gioiTinh);
		
		String [] tinh = new String [] {
				"An Giang",
				"Bà rịa Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"TP Hồ Chí Minh",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"};
		comboBox_tinh = new JComboBox<String>(tinh);
		comboBox_tinh.setBackground(new Color(128, 255, 255));
		comboBox_tinh.setBounds(729, 418, 182, 22);
		panel_nv.add(comboBox_tinh);
		
		JButton jButton_addNhanVien_1 = new JButton("Hiển thị tất cả danh sách");
		jButton_addNhanVien_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\woeusbgui-icon-icon.png"));
		jButton_addNhanVien_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO.getInstance().selectAll();
			}
		});
		jButton_addNhanVien_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_addNhanVien_1.setBounds(10, 117, 228, 26);
		panel_nv.add(jButton_addNhanVien_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(225, 449, 459, 13);
		panel_nv.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 283, 911, 13);
		panel_nv.add(separator_2);
		
		textField_findByID = new JTextField();
		textField_findByID.setColumns(10);
		textField_findByID.setBounds(529, 117, 182, 24);
		panel_nv.add(textField_findByID);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3_3.setBounds(392, 117, 127, 26);
		panel_nv.add(lblNewLabel_3_3);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(169, 321, 752, 13);
		panel_nv.add(separator_2_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("Thông tin nhân viên:");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3_4.setBounds(10, 308, 162, 26);
		panel_nv.add(lblNewLabel_3_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "H\u1ECD v\u00E0 t\u00EAn", "Tu\u1ED5i", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "L\u01B0\u01A1ng"
			}
		));
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 147, 905, 126);
		panel_nv.add(scrollPane);
		
		JButton jButton_addNhanVien_2 = new JButton("Hủy bỏ");
		jButton_addNhanVien_2.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Button-Close-icon.png"));
		jButton_addNhanVien_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO.getInstance().xoaForm();
			}
		});
		jButton_addNhanVien_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_addNhanVien_2.setBounds(603, 461, 116, 26);
		panel_nv.add(jButton_addNhanVien_2);
		

		
		// cardLayout
		JPanel panel_cardUpdate = new JPanel();
		panel_cardUpdate.setBounds(10, 48, 899, 455);
		panel_kh.add(panel_cardUpdate);
		panel_cardUpdate.setLayout(new CardLayout(0, 0));
		
		JPanel panel_select = new JPanel();
		panel_cardUpdate.add(panel_select, "panel_select");
		
		JPanel panel_add = new JPanel();
		panel_cardUpdate.add(panel_add, "panel_add");
		
		JPanel panel_remove = new JPanel();
		panel_cardUpdate.add(panel_remove, "panel_remove");
		
		JPanel panel_update = new JPanel();
		panel_cardUpdate.add(panel_update, "panel_update");
		
		JPanel panel_search = new JPanel();
		panel_cardUpdate.add(panel_search, "panel_search");
		
		
		panel_cardUpdate.add(panel_select, "panel_select");
		panel_cardUpdate.add(panel_add, "panel_add");
		panel_cardUpdate.add(panel_remove, "panel_remove");
		panel_cardUpdate.add(panel_update, "panel_update");
		panel_cardUpdate.add(panel_search, "name_77719564717700");
		
		
		JLabel lblNewLabel_1 = new JLabel("Hiển thị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(117, 83, 218, 100);
		panel_select.add(lblNewLabel_1);
		panel_cardUpdate.add(panel_select, "panel_select");
		panel_select.setLayout(null);
		panel_cardUpdate.add(panel_add, "panel_add");
		panel_add.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xóa");
		lblNewLabel_1_1_1.setBounds(289, 5, 84, 31);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_remove.add(lblNewLabel_1_1_1);
		panel_cardUpdate.add(panel_remove, "panel_remove");
		panel_remove.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sửa");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 84, 31);
		panel_update.add(lblNewLabel_1_1_1_1);
		panel_cardUpdate.add(panel_update, "panel_update");
		panel_update.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tìm kiếm");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1_1.setBounds(106, 3, 112, 31);
		panel_search.add(lblNewLabel_1_1_1_1_1);
		panel_cardUpdate.add(panel_search, "panel_search");
		panel_search.setLayout(null);
		
		
		JToolBar toolBar_1_1 = new JToolBar();
		toolBar_1_1.setBounds(10, 10, 899, 28);
		panel_kh.add(toolBar_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Hiển thị");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_cardUpdate.getLayout();
		        cardLayout.show(panel_cardUpdate, "panel_select");
			}
		});
		btnNewButton_1_2_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Pork-Chop-Set-icon.png"));
		btnNewButton_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar_1_1.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_1_2_1 = new JButton("Thêm");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_cardUpdate.getLayout();
		        cardLayout.show(panel_cardUpdate, "panel_add");
			}
		});
		btnNewButton_1_1_2_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Male-user-add-icon.png"));
		btnNewButton_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar_1_1.add(btnNewButton_1_1_2_1);
		
		JButton btnNewButton_1_1_1_2_1 = new JButton("Xóa");
		btnNewButton_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_cardUpdate.getLayout();
		        cardLayout.show(panel_cardUpdate, "panel_remove");
			}
		});
		btnNewButton_1_1_1_2_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Actions-list-remove-user-icon.png"));
		btnNewButton_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar_1_1.add(btnNewButton_1_1_1_2_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Sửa");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_cardUpdate.getLayout();
		        cardLayout.show(panel_cardUpdate, "panel_update");
			}
		});
		btnNewButton_1_1_1_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Pencil-icon.png"));
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar_1_1.add(btnNewButton_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Tìm kiếm");
		btnNewButton_1_1_1_1_1_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Search-icon (1).png"));
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_cardUpdate.getLayout();
				cardLayout.show(panel_cardUpdate, "panel_search");
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar_1_1.add(btnNewButton_1_1_1_1_1_1_1);
		
		// JButton quản lí
		JButton btnNewButton = new JButton("Sản phẩm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_card.getLayout();
		        cardLayout.show(panel_card, "name_68594078978699"); // Switch to the specific card (panel)
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(0, 101, 119, 21);
		panel.add(btnNewButton);
		
		
		JButton btnNhnVin = new JButton("Nhân viên");
		btnNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_card.getLayout();
				cardLayout.show(panel_card, "name_68631275739599");
			}
		});
		btnNhnVin.setBackground(new Color(128, 255, 255));
		btnNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNhnVin.setBounds(0, 143, 119, 21);
		panel.add(btnNhnVin);
		
		
		JButton btnKhchHng = new JButton("Khách hàng");
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_card.getLayout();
				cardLayout.show(panel_card, "name_68639509310700");
			}
		});
		btnKhchHng.setBackground(new Color(128, 255, 255));
		btnKhchHng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnKhchHng.setBounds(0, 182, 119, 21);
		panel.add(btnKhchHng);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManHinhDangNhap mhdn = new ManHinhDangNhap();
				mhdn.setVisible(true);
			}
		});
		btnngXut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnngXut.setBackground(new Color(128, 255, 255));
		btnngXut.setBounds(0, 221, 119, 21);
		panel.add(btnngXut);

//		NhanVienDAO.getInstance().selectAll();
	}
}
