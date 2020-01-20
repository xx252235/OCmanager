package mine.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class MyJdbcUtil {
	//����һ��c3p0���ӳض���
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//����ȡ���ӳ����Ӷ����װΪһ������
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	//����ȡc3p0���ӳض���Ҳ��װΪһ������
	public static DataSource getDataSource(){
		return dataSource;
	}
	//д�����ֲ�ͬ������release�����������ͷ���Դ�Ĺ��̱ȽϷ�����ÿ�ζ���һ���ģ����Է�װΪ�������򵥵ķ���
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	public static void release(Statement stmt,Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}








