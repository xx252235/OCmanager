/**  
 * @Title: User.java
 * @Description: TODO
 * @author: xu01.xin 
 * @date 2020年1月10日 下午3:50:46
 */
package mine.vo;

/**
 * @author xu01.xin
 *
 */
public class User {
		private String userid;
		private String username;
		private String password;
		/**
		 * @return the userid
		 */
		public String getUserid() {
			return userid;
		}
		/**
		 * @param userid the userid to set
		 */
		public void setUserid(String userid) {
			this.userid = userid;
		}
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [userid=" + userid + ", username=" + username
					+ ", password=" + password + "]";
		}
		
		
}
