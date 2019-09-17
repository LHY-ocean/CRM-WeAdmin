package model;

public class Operator {
	
	public static String[] statusname= {"启用","禁用"}; 
	public String getStatusname() {
		return statusname[status];
	}
	
	public static String[] powername = {"组员","组长","管理员"}; 
	public String getPowername() {
		return powername[power];
	}
	
	
	
	private Integer id;
	private String tel;
	private String pass;
	private String name;
	private Integer groupid;
	private String groupname;
	public String getGroupname() {
		return groupname;
	}

	private Integer power;
	private Integer status;
	
	public Operator() {
		
	}
	
	public Operator(String tel, String pass) {
		super();
		this.tel = tel;
		this.pass = pass;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


}
