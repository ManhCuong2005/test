package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QuanLiNhaHang_Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ManHinhDangNhap extends JFrame {

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
					ManHinhDangNhap frame = new ManHinhDangNhap();
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
	public ManHinhDangNhap() {
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
		
		//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(339, 182, 72, 71);
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(339, 182, 72, 71);
//		
//		CardLayout cardLayout=new CardLayout();
//		JPanel panel_card=new JPanel(cardLayout);
//		panel_card.setBounds(339, 182, 72, 71);
//		contentPane.add(panel_card);
//		panel_card.add(panel_1, "panel_1");
//		panel_card.add(panel_2, "panel_2");
//		panel_2.setLayout(null);
//		
//		JLabel lblNewLabel_4 = new JLabel("2");
//		lblNewLabel_4.setBounds(17, 36, 45, 13);
//		panel_2.add(lblNewLabel_4);
//		panel_1.setLayout(null);
//		
//		JLabel lblNewLabel_3 = new JLabel("1");
//		lblNewLabel_3.setBounds(17, 26, 45, 13);
//		panel_1.add(lblNewLabel_3);
		//
		
		JLabel lblNewLabel = new JLabel("Đăng nhập cho Quản lý");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(110, 10, 201, 29);
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
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManHinhQuanLi mhql= new ManHinhQuanLi();
				mhql.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\BaiTapCuoiKi\\Restaurant-icon (1).png"));
		lblNewLabel_2.setBounds(354, 86, 72, 86);
		contentPane.add(lblNewLabel_2);
		//
//		JButton btnNewButton_1 = new JButton("1");
//		btnNewButton_1.setBounds(64, 202, 85, 21);
//		contentPane.add(btnNewButton_1);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(panel_card, "panel_1");
//			}
//		});
//		
//		JButton btnNewButton_2 = new JButton("2");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(panel_card, "panel_2");
//			}
//		});
//		btnNewButton_2.setBounds(64, 233, 85, 21);
//		contentPane.add(btnNewButton_2);
		//
	}
}
