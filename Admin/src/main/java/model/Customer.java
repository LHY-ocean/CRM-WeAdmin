package model;

public class Customer {
	
	public static String[] cus_sexname = {"不限","男","女"};
	
	
	public String getCus_sexname() {
		return cus_sexname[cus_sex];
	}
	
	private int id;
	private String cus_no;
	private String cus_name;
	private int cus_sex;
	private int pro_id;
	private String pro_no;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCus_no() {
		return cus_no;
	}
	public void setCus_no(String cus_no) {
		this.cus_no = cus_no;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public int getCus_sex() {
		return cus_sex;
	}
	public void setCus_sex(int cus_sex) {
		this.cus_sex = cus_sex;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_no() {
		return pro_no;
	}
	
	
}
