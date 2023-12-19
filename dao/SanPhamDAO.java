package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.SanPham;

public class SanPhamDAO implements DAOInterface<SanPham>{

	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(SanPham t) {
		int check = 0;
		
		try {
			// B1: Tạo kết nối 
			Connection con = JDBC.getConnection();
			
			// B2: Tạo đối tượng statement
			Statement st = con.createStatement();
			
			// B3: Tạo câu lệnh sql
			String sql = "INSERT INTO QuanLySanPham (ID, name, tuoi, gioitinh, diachi)" +
						 " VALUES ('" + t.getIdSanPham() + "', '" + t.getName() + "', " + t.getGia() + ")";
			
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
	public int update(SanPham t) {
		int check = 0;
		
		try {
			// B1: Tạo kết nối 
			Connection con = JDBC.getConnection();
			
			// B2: Tạo đối tượng statement
			Statement st = con.createStatement();
			
			// B3: Tạo câu lệnh sql
			String sql = "UPDATE QuanLySanPham " + 
					 	 " SET " + 
					 	 " IDSanPham = " + "'" + t.getIdSanPham() + "'" +
					 	 " , Name = " + " ' " + t.getName() + " ' " +
					 	 " , Gia = " + t.getGia() +
					 	 " WHERE id = " + t.getIdSanPham();
			
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
	public int delete(SanPham t) {
		int check = 0;
		
		try {
			// B1: kết nối
			Connection con = JDBC.getConnection();
			
			// B2: tạo đối tượng statements
			Statement st = con.createStatement();
			
			// B3: tạo câu lệnh sql
			String sql = "DELETE FROM QuanLySanPham " +
						 " WHERE ID = " + t.getIdSanPham();
			
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
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
		
		try {
			// B1: Tạo kết nối
			Connection con = JDBC.getConnection();
			
			// B2: Tạo đối tượng statements
			Statement st = con.createStatement();
			
			// B3: Câu lệnh sql 
			String sql = "SELECT * FROM QuanLySanPham";
			System.out.println(sql);
			// Thực thi 
			ResultSet rs = st.executeQuery(sql);
			
			// B4: Thực thi 
			while (rs.next()) {
				String idSanPham = rs.getString ("idSanPham");
				String name = rs.getString ("name");
				int gia = rs.getInt("Gia");
				
				SanPham sanPham = new SanPham(idSanPham, name, gia);
				ketQua.add(sanPham);
			}
			
			// B5: Ngắt kết nối 
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public SanPham selectByID(SanPham t) {
		SanPham ketQua = null;
		
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM QuanLySanPham WHERE ID = " + t.getIdSanPham();
			System.out.println(sql);
			
			// thực thi
			ResultSet rs = st.executeQuery(sql);
			
			// B4:
			while (rs.next()) {
				String idSanPham = rs.getString ("idSanPham");
				String name = rs.getString ("name");
				int gia = rs.getInt("Gia");
				
				ketQua = new SanPham(idSanPham, name, gia);
			}
			
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<SanPham> selectByCondition(String condition) {
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
		
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM QuanLySanPham WHERE " + condition;
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String idSanPham = rs.getString ("idSanPham");
				String name = rs.getString ("name");
				int gia = rs.getInt("Gia");
				
				SanPham nhanVien = new SanPham(idSanPham, name, gia);
				ketQua.add(nhanVien);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
