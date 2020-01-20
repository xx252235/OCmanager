/**  
 * @Title: UserDao.java
 * @Description: TODO
 * @author: xu01.xin 
 * @date 2020��1��10�� ����3:52:56
 */
package mine.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mine.utils.MyJdbcUtil;
import mine.vo.Contract;
import mine.vo.User;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @author xu01.xin
 *
 */
public class UserDao {

		// ���в�ѯ�ķ��������������������������򷵻�true
		public boolean getSelect(String userid, String password) {
			boolean flag = false;

			QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
				StringBuffer sb = new StringBuffer("select * from user_info where 1=1 ");
				//���List����������������渳ֵ����
				List<Object> list = new ArrayList<Object>();
				if(userid != null && !userid.trim().isEmpty()){
					sb.append(" and userid = ? ");
					list.add(userid);
				}
				if(password != null && !password.trim().isEmpty()){
					sb.append(" and password = ? ");
					list.add(password);
				}
			try {
				List<User> ulist = runner.query(sb.toString(), new BeanListHandler<User>(User.class) ,list.toArray());
				if(!ulist.isEmpty()){
						flag = true;
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			return flag;
			
			
		}
	}
