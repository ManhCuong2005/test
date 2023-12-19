package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import view.ManHinhChaoMung;
import view.ManHinhDangNhap;
import view.ManHinhQuanLi;

public class QuanLiNhaHang_Controller implements ActionListener {

	private ManHinhQuanLi manHinhQuanLi;
	
	public QuanLiNhaHang_Controller(ManHinhQuanLi manHinhQuanLi) {
		this.manHinhQuanLi = manHinhQuanLi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thêm")) {
			this.manHinhQuanLi.xoaForm();
		} 
//			else if(src.equals("Nhân viên")) {
//			this.manHinhChaoMung.chuyenNhanVien();
//		}
	}
}
