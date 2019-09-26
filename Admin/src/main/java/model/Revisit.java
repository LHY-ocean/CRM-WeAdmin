package model;

public class Revisit {
	
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
	private Integer clientid;
	
	private String clientname;
	
	public String getClientname() {
		return clientname;
	}
	
	private Integer operatorid;
	
	private String operatorname;
	
	public String getOperatorname() {
		return clientname;
	}

	private Integer linkstatus=0;
	private Integer clientstatus=0;
	private Integer purposestatus=0;
	private Integer assessstatus=0;
	private Integer execstatus=0;
	private String askinfo;
	private String followinfo;
	private String probleminfo;
	private Integer status=0;
	private String comments;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientid() {
		return clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
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

	public String getAskinfo() {
		return askinfo;
	}

	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}

	public String getFollowinfo() {
		return followinfo;
	}

	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}

	public String getProbleminfo() {
		return probleminfo;
	}

	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}


}
