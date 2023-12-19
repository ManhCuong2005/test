package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ManHinhChaoMung;
import view.ManHinhDangNhap;
import view.ManHinhQuanLi;

public class QuanLiNhaHang_Controller implements ActionListener {

	private ManHinhChaoMung manHinhChaoMung;
	
	public QuanLiNhaHang_Controller(ManHinhChaoMung manHinhChaoMung) {
		this.manHinhChaoMung = manHinhChaoMung;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src=e.getActionCommand();
		if(src.equals("Quản Lý")) {
			this.manHinhChaoMung.chuyenQuanLy();
		} else if(src.equals("Nhân viên")) {
			this.manHinhChaoMung.chuyenNhanVien();
		}
	}
}
