package mine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String msg = request.getParameter("msg");
		String decoded_msg = URLDecoder.decode(msg,"UTF-8");
		System.out.println(decoded_msg);
		getContent(decoded_msg, out);
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/manage", "root",
					"root");

			return conn;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void getContent(String msg, PrintWriter out) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if ( !msg.equals("")) {
			System.out.println(msg);
			String sql = "select * from contract_info where objectname like '" + msg + "%'";
			System.out.println(sql);

			try {

				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					out.print(rs.getString("msg") + "<br/>");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try{
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
	//É¾³ýÄÚÈÝ
	public static boolean deleteContent(String msg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			System.out.println(msg);
			String sql = "delete * from contract_info where objectname =?";

			try {

				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,msg);
				
				int n = pstmt.executeUpdate();
				
				if ( n > 0) {
					return true;
				}else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally {
				try{
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

		
		
	}
}
