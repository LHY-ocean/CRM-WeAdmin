package model;

public class Product {
	private int id;
	private String pro_no;
	private String pro_name;
	private double pro_price;
	private int pro_stocks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public double getPro_price() {
		return pro_price;
	}
	public void setPro_price(double pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_stocks() {
		return pro_stocks;
	}
	public void setPro_stocks(int pro_stocks) {
		this.pro_stocks = pro_stocks;
	}
	
	
}
