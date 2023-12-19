package model;

public class SanPham {
	private String idSanPham;
	private String name;
	private double gia;
	
	public SanPham() {
		super();
	}

	public SanPham(String idSanPham, String name, double gia) {
		super();
		this.idSanPham = idSanPham;
		this.name = name;
		this.gia = gia;
	}

	/**
	 * @return the idSanPham
	 */
	public String getIdSanPham() {
		return idSanPham;
	}

	/**
	 * @param idSanPham the idSanPham to set
	 */
	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
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
	 * @return the gia
	 */
	public double getGia() {
		return gia;
	}

	/**
	 * @param gia the gia to set
	 */
	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "SanPham [idSanPham=" + idSanPham + ", name=" + name + ", gia=" + gia + "]";
	}
}
