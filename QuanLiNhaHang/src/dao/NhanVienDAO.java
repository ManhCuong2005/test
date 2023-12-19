package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.JDBC;
import model.NhanVien;
import view.ManHinhQuanLi;

public class NhanVienDAO implements DAOInterface<NhanVien>{

	String idNV = ManHinhQuanLi.jTextField_idNV.getText();
	String name = ManHinhQuanLi.jTextField_nameNV.getText();
    int tuoi = Integer.parseInt(ManHinhQuanLi.jTextField_tuoi.getText());
    String gioiTinh = (String) ManHinhQuanLi.jComboBox_gioiTinh.getSelectedItem();
    int luong = Integer.parseInt(ManHinhQuanLi.jTextField_luong.getText());
    String diaChi = (String) ManHinhQuanLi.comboBox_tinh.getSelectedItem();
	
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert() {
		
		int check = 0;
		
		try {
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
			
			// B5: Ngắt kết nối
			JDBC.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int update() {
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
					 	 " , Name = " + " ' " + name + " ' " +
					 	 " , Tuoi = " + tuoi +
					 	 " , GioiTinh = " + " ' " + gioiTinh + " ' " +
					 	 " , DiaChi = " + " ' " + diaChi + " ' " + 
					 	 " , Luong = " + luong +
					 	 " WHERE id = " + "'" + idNV + "'";
			
			check = st.executeUpdate(sql);
			System.out.println(sql);
			
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
		
		try {
			// B1: kết nối
			Connection con = JDBC.getConnection();
			
			// B2: tạo đối tượng statements
			Statement st = con.createStatement();
			
			// B3: tạo câu lệnh sql
			String sql = "DELETE FROM QuanLyNhanVien " +
						 " WHERE ID = " + idNV;
			
			check = st.executeUpdate(sql);
			System.out.println(sql);
			
			// B4: thực thi câu lệnh sql
			System.out.println("Có " + check + " câu lệnh bị thay đổi!");
			
			// B5: ngắt kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public void selectAll() {
//	    ArrayList<NhanVien> ketQua = new ArrayList<>();

	    try (
	    	String [] arr = {"ID",
	    	Connection con = JDBC.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM QuanLyNhanVien")) {

	    	
	    	DefaultTableModel tableModel =  (DefaultTableModel) ManHinhQuanLi.table.getModel();
	    	
	    	while (rs.next()) {
	    		Object Objlist [] = {rs.getString("ID"), rs.getString("Họ và tên"), rs.getString("Giới tính"), rs.getString("Địa chỉ"), rs.getInt("Tuổi"), rs.getInt("Lương")};
	    		tableModel.addRow(Objlist); 
	    	}
	    	
//	        ResultSetMetaData metaData = rs.getMetaData();
//	        int columnCount = metaData.getColumnCount();
//
//	        // Thêm tên cột vào bảng (hoặc mô hình bảng)
//	        for (int i = 1; i <= columnCount; i++) {
//	            ManHinhQuanLi.tableModel.addColumn(metaData.getColumnName(i));
//	        }
//
//	        // Thêm dữ liệu vào danh sách và bảng
//	        while (rs.next()) {
//	            Object[] rowData = new Object[columnCount];
//	            for (int i = 1; i <= columnCount; i++) {
//	                rowData[i - 1] = rs.getObject(i);
//	            }
//	            ketQua.add(new NhanVien(/* Khởi tạo NhanVien từ rowData */));
//	            ManHinhQuanLi.tableModel.addRow(rowData);
//	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

//	    return ketQua;
	}

	@Override
	public NhanVien selectByID(NhanVien t) {
		NhanVien ketQua = null;
		
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM QuanLyNhanVien WHERE ID = " + t.getID();
			System.out.println(sql);
			
			// thực thi
			ResultSet rs = st.executeQuery(sql);
			
			// B4:
			while (rs.next()) {
				String id = rs.getString ("id");
				String name = rs.getString ("name");
				int tuoi = rs.getInt("tuoi");
				String gioiTinh = rs.getString("GioiTinh");
				String diaChi = rs.getString("diaChi");
				int luong = rs.getInt("Luong");
				
				ketQua = new NhanVien(id, name, tuoi, gioiTinh, diaChi, luong);
			}
			
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
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

}
