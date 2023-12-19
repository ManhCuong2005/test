package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QuanLiNhaHang_Controller;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ManHinhChaoMung extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChaoMung frame = new ManHinhChaoMung();
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
	public ManHinhChaoMung() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\BaiTapCuoiKi\\restaurant-icon.png"));
		setTitle("Nhà Hàng NMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		QuanLiNhaHang_Controller con = new QuanLiNhaHang_Controller(this);
		
		JTextArea txtrChoMngBn = new JTextArea();
		txtrChoMngBn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtrChoMngBn.setText("   Chào mừng bạn đến với \nphần mềm quản lí nhà hàng!");
		txtrChoMngBn.setBounds(61, 10, 312, 77);
		contentPane.add(txtrChoMngBn);
		
		JLabel lblNewLabel = new JLabel("Vui lòng chọn hình thức đăng nhập!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(66, 97, 307, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Quản Lý");
		btnNewButton.addActionListener(con);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(83, 160, 114, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNhnVin = new JButton("Nhân viên");
		btnNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNhnVin.setBounds(222, 161, 114, 21);
		contentPane.add(btnNhnVin);
		btnNhnVin.addActionListener(con);
	}
	
	public void chuyenQuanLy() {
		dispose();
		ManHinhDangNhap dn = new ManHinhDangNhap();
		dn.setVisible(true);
	}
	
	public void chuyenNhanVien() {
		dispose();
		ManHinhDangNhapNhanVien mhnv = new ManHinhDangNhapNhanVien();
		mhnv.setVisible(true);
	}
}
