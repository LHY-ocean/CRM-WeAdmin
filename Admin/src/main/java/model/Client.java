package model;

public class Client {
	
	public static String[] sexname = {"男","女"};
	public  String getSexname() {
		return sexname[sex];
	}
	
	public static String[] linkstatusname = {"未指定","未接听","秒挂","有交流","深入交流"};
	public  String getLinkstatusname() {
		return linkstatusname[linkstatus];
	}
	
	public static String[] clientstatusname = {"未指定","排斥","推脱","后续","较好"};
	public  String getClientstatusname() {
		return clientstatusname[clientstatus];
	}
	
	public static String[] purposestatusname = {"未指定","N","C","B","A","Y"};
	public  String getPurposestatusname() {
		return purposestatusname[purposestatus];
	}
	
	public static String[] assessstatusname = {"未指定","无果","预约","截止"};
	public  String getAssessstatusname() {
		return assessstatusname[assessstatus];
	}
	
	public static String[] execstatusname = {"正常","转出","完成"};
	public  String getExecstatusname() {
		return execstatusname[execstatus];
	}
	
	public static String[] statusname = {"正常","公共","资料不全","无效"};
	public  String getStatusname() {
		return statusname[status];
	}
	
	private Integer id;
	private String name;
	private Integer sex;
	private String tel;
	private String qq;
	private String email;
	private String infos;
	private Integer linkstatus;
	private Integer clientstatus;
	private Integer purposestatus;
	private Integer assessstatus;
	private Integer execstatus;
	private Integer status;
	private Integer clienttypeid;
	
	private String clienttypename;
	public String getClienttypename() {
		return clienttypename;
	}

	private String operatorids;
	
	private Integer createoperatorid;
	private String operatorname;
	public String getOperatorname() {
		return operatorname;
	}

	private String createdate;
	
	private Integer srcid;
	private String srcname;
	public String getSrcname() {
		return srcname;
	}

	private Integer count;
	private String comments;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public Integer getLinkstatus() {
		return linkstatus;
	}

	public void setLinkstatus(Integer linkstatus) {
		this.linkstatus = linkstatus;
	}

	public Integer getClientstatus() {
		return clientstatus;
	}

	public void setClientstatus(Integer clientstatus) {
		this.clientstatus = clientstatus;
	}

	public Integer getPurposestatus() {
		return purposestatus;
	}

	public void setPurposestatus(Integer purposestatus) {
		this.purposestatus = purposestatus;
	}

	public Integer getAssessstatus() {
		return assessstatus;
	}

	public void setAssessstatus(Integer assessstatus) {
		this.assessstatus = assessstatus;
	}

	public Integer getExecstatus() {
		return execstatus;
	}

	public void setExecstatus(Integer execstatus) {
		this.execstatus = execstatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getClienttypeid() {
		return clienttypeid;
	}

	public void setClienttypeid(Integer clienttypeid) {
		this.clienttypeid = clienttypeid;
	}

	public String getOperatorids() {
		return operatorids;
	}

	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}

	public Integer getCreateoperatorid() {
		return createoperatorid;
	}

	public void setCreateoperatorid(Integer createoperatorid) {
		this.createoperatorid = createoperatorid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getSrcid() {
		return srcid;
	}

	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
