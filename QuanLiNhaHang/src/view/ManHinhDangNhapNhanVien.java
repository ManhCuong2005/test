package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ManHinhDangNhapNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhDangNhapNhanVien frame = new ManHinhDangNhapNhanVien();
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
	public ManHinhDangNhapNhanVien() {
//		this.setLocationRelativeTo(null);
		this.setTitle("Quản Lý Nhà Hàng NMC");
		URL url_main = ManHinhDangNhap.class.getResource("icon_restaurant.png");
		Image image_icon_restaurant = Toolkit.getDefaultToolkit().createImage(url_main);
		this.setIconImage(image_icon_restaurant);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập cho Nhân viên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 10, 231, 29);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(37, 86, 307, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản:");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\icon_user.png"));
		lblNewLabel_1.setBounds(10, 13, 84, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\icon_password.png"));
		lblNewLabel_1_1.setBounds(10, 56, 84, 20);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(138, 14, 133, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 57, 133, 19);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(183, 182, 128, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Restaurant-icon (1).png"));
		lblNewLabel_2.setBounds(354, 86, 72, 86);
		contentPane.add(lblNewLabel_2);
	}
}
