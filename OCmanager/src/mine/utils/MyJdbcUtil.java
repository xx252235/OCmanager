package mine.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class MyJdbcUtil {
	//创建一个c3p0连接池对象
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//将获取连接池链接对象封装为一个方法
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	//将获取c3p0连接池对象也封装为一个方法
	public static DataSource getDataSource(){
		return dataSource;
	}
	//写了两种不同参数的release方法，由于释放资源的过程比较繁琐，每次都是一样的，所以封装为了两个简单的方法
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









