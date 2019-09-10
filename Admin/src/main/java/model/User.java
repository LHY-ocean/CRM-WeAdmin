package model;

public class User {

		public static String[] usersexs= {"男","女"};
		public String getUsersexname() {
			return usersexs[usersex];
		}
	
		private Integer id;
		private String username;
		private String userpwd;
		private Integer usersex;
		private String userphone;
		private Integer posid;
		
		private String posname;
		
		public String getPosname() {
			return posname;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserpwd() {
			return userpwd;
		}

		public void setUserpwd(String userpwd) {
			this.userpwd = userpwd;
		}

		public Integer getUsersex() {
			return usersex;
		}

		public void setUsersex(Integer usersex) {
			this.usersex = usersex;
		}

		public String getUserphone() {
			return userphone;
		}

		public void setUserphone(String userphone) {
			this.userphone = userphone;
		}

		public Integer getPosid() {
			return posid;
		}

		public void setPosid(Integer posid) {
			this.posid = posid;
		}


}
