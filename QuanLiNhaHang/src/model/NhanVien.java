package model;

public class NhanVien {
	private String ID;
	private String name;
	private int tuoi;
	private String gioiTinh;
	private String diaChi;
	private int luong;
	
	public NhanVien() {
		super();
	}
	
	
	
public NhanVien(String iD, String name, int tuoi, String gioiTinh, String diaChi, int luong) {
		super();
		ID = iD;
		this.name = name;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.luong = luong;
	}



	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tuoi
	 */
	public int getTuoi() {
		return tuoi;
	}

	/**
	 * @param tuoi the tuoi to set
	 */
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
	/**
	 * @return the luong
	 */
	public int getLuong() {
		return luong;
	}



	/**
	 * @param luong the luong to set
	 */
	public void setLuong(int luong) {
		this.luong = luong;
	}


	@Override
	public String toString() {
		return "NhanVien [ID=" + ID + ", name=" + name + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi="
				+ diaChi + ", luong=" + luong + "]";
	}
}
