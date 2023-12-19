package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.JDBC;
import model.NhanVien;
import view.ManHinhQuanLi;

public class NhanVienDAO implements DAOInterface<NhanVien>{

//	String idNV = ManHinhQuanLi.jTextField_idNV.getText();
//	String name = ManHinhQuanLi.jTextField_nameNV.getText();
//    int tuoi = Integer.parseInt(ManHinhQuanLi.jTextField_tuoi.getText());
//    String gioiTinh = (String) ManHinhQuanLi.jComboBox_gioiTinh.getSelectedItem();
//    int luong = Integer.parseInt(ManHinhQuanLi.jTextField_luong.getText());
//    String diaChi = (String) ManHinhQuanLi.comboBox_tinh.getSelectedItem();
	
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert() {
		String idNV = ManHinhQuanLi.jTextField_idNV.getText();
		String name = ManHinhQuanLi.jTextField_nameNV.getText();
	    int tuoi = Integer.parseInt(ManHinhQuanLi.jTextField_tuoi.getText());
	    String gioiTinh = (String) ManHinhQuanLi.jComboBox_gioiTinh.getSelectedItem();
	    int luong = Integer.parseInt(ManHinhQuanLi.jTextField_luong.getText());
	    String diaChi = (String) ManHinhQuanLi.comboBox_tinh.getSelectedItem();
		
		int check = 0;
		
		try {
//			 Clear dữ liệu cũ trong bảng
//	        tableModel.setRowCount(0);
			
			// B1: Tạo kết nối 
			Connection con = JDBC.getConnection();
			
			// B2: Tạo đối tượng statement
			Statement st = con.createStatement();
			
			// B3: Tạo câu lệnh sql
			String sql = "INSERT INTO QuanLyNhanVien (ID, name, tuoi, gioitinh, diachi, luong)" +
						 " VALUES ('" + idNV + "', '" + name + "', " + tuoi + ", '" + gioiTinh + "', '" + diaChi + "', " + luong + ")";
			
			check = st.executeUpdate(sql);
			System.out.println(sql);
			
			// B4: Thực thi câu lệnh sql
			System.out.println("Có " + check + " dòng bị thay đổi!");
			if (check > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã THÊM thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "THÊM thất bại!");
			}
			
			// B5: Ngắt kết nối
			JDBC.closeConnection(con);
			
			DefaultTableModel tableModel =  (DefaultTableModel) ManHinhQuanLi.table.getModel();
			
			// Clear dữ liệu cũ trong bảng
	        tableModel.setRowCount(0);
			
			Object Objlist [] = {idNV, name, gioiTinh, diaChi, tuoi + "", luong + ""};
    		tableModel.addRow(Objlist); 
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int update() {
		String idNV = ManHinhQuanLi.jTextField_idNV.getText();
		String name = ManHinhQuanLi.jTextField_nameNV.getText();
	    int tuoi = Integer.parseInt(ManHinhQuanLi.jTextField_tuoi.getText());
	    String gioiTinh = (String) ManHinhQuanLi.jComboBox_gioiTinh.getSelectedItem();
	    int luong = Integer.parseInt(ManHinhQuanLi.jTextField_luong.getText());
	    String diaChi = (String) ManHinhQuanLi.comboBox_tinh.getSelectedItem();
	    
		int check = 0;
		
		try {
			// B1: Tạo kết nối 
			Connection con = JDBC.getConnection();
			
			// B2: Tạo đối tượng statement
			Statement st = con.createStatement();
			
			// B3: Tạo câu lệnh sql
			String sql = "UPDATE QuanLyNhanVien " + 
					 	 " SET " + 
					 	 " ID = " + "'" + idNV + "'" +
					 	 " , Name = " + "'" + name + "'" +
					 	 " , Tuoi = " + tuoi +
					 	 " , GioiTinh = " + "'" + gioiTinh + "'" +
					 	 " , DiaChi = " + "'" + diaChi + "'" + 
					 	 " , Luong = " + luong +
					 	 " WHERE id = " + "'" + idNV + "'";
			
			check = st.executeUpdate(sql);
			System.out.println(sql);
			
			if (check > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã SỬA thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "SỬA thất bại!");
			}
			
			// B4: Thực thi câu lệnh sql
			System.out.println("Có " + check + " dòng bị thay đổi!");
			
			// B5: Ngắt kết nối
			JDBC.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete() {
	    int check = 0;
	    String idNV = ManHinhQuanLi.jTextField_idNV.getText();

	    try {
	        // B1: kết nối
	        Connection con = JDBC.getConnection();

	        // B2: tạo đối tượng prepared statement
	        String sql = "DELETE FROM QuanLyNhanVien WHERE ID = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	       
            // B3: set tham số cho prepared statement
            pst.setString(1, idNV);

            // B4: thực thi câu lệnh sql
            check = pst.executeUpdate();
            System.out.println(sql);
            
            if (check > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã XÓA thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "XÓA thất bại!");
			}

            // B5: thông báo về số dòng bị ảnh hưởng
            System.out.println("Có " + check + " dòng bị thay đổi!");
            
	        // B6: ngắt kết nối
	        JDBC.closeConnection(con);
	    } catch (SQLException e) {
	        // Xử lý ngoại lệ SQL
	        e.printStackTrace();
	    }
	    return check;
	}

	@Override
	public void selectAll() {
	    try (
	        Connection con = JDBC.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM QuanLyNhanVien")) {

	        DefaultTableModel tableModel = (DefaultTableModel) ManHinhQuanLi.table.getModel();

	        // Clear dữ liệu cũ trong bảng
	        tableModel.setRowCount(0);

	        while (rs.next()) {
	            String idNV = rs.getString("ID");
	            String name = rs.getString("name");
	            String gioiTinh = rs.getString("GioiTinh");
	            String diaChi = rs.getString("diaChi");
	            int tuoi = rs.getInt("tuoi");
	            int luong = rs.getInt("Luong");

	            Object Objlist[] = {idNV, name, tuoi, gioiTinh, diaChi, luong};
	            tableModel.addRow(Objlist);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void selectByID() {
		String idNV = ManHinhQuanLi.textField_findByID.getText();
		
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM QuanLyNhanVien WHERE ID = " + idNV;
			System.out.println(sql);
			
			// thực thi
			ResultSet rs = st.executeQuery(sql);
			
			// B4:
			
			DefaultTableModel tableModel = (DefaultTableModel) ManHinhQuanLi.table.getModel();
//			 Clear dữ liệu cũ trong bảng
	        tableModel.setRowCount(0);
			
			if (rs.next()) {
//				String id = rs.getString ("id");
				String name = rs.getString ("name");
				int tuoi = rs.getInt("tuoi");
				String gioiTinh = rs.getString("GioiTinh");
				String diaChi = rs.getString("diaChi");
				int luong = rs.getInt("Luong");
				
				Object Objlist[] = {idNV, name, gioiTinh, diaChi, tuoi, luong};
	            tableModel.addRow(Objlist);
			} else {
				System.out.println("Không có dữ liệu.");
			}
			
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<NhanVien> selectByCondition(String condition) {
		ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
		
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM QuanLyNhanVien WHERE " + condition;
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String id = rs.getString ("id");
				String name = rs.getString ("name");
				int tuoi = rs.getInt("tuoi");
				String gioiTinh = rs.getString("GioiTinh");
				String diaChi = rs.getString("diaChi");
				int luong = rs.getInt("Luong");
				
				NhanVien nhanVien = new NhanVien(id, name, tuoi, gioiTinh, diaChi, luong);
				ketQua.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public void xoaForm() {
		ManHinhQuanLi.jTextField_idNV.setText("");
		ManHinhQuanLi.jTextField_nameNV.setText("");
		ManHinhQuanLi.jTextField_tuoi.setText("");
		ManHinhQuanLi.jTextField_luong.setText("");
		ManHinhQuanLi.jComboBox_gioiTinh.setSelectedIndex(-1);
		ManHinhQuanLi.comboBox_tinh.setSelectedIndex(-1);
	}
}
