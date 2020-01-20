/**  
 * @Title: LoginServlet.java
 * @Description: TODO
 * @author: xu01.xin 
 * @date 2020年1月10日 下午3:59:07
 */
package mine.action.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.dao.UserDao;

/**
 * @author xu01.xin
 *
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
//创建时为Servlet而不是Class，需要在web.xml中进行配置，配置的代码Myeclipse将自动生成
public class LoginServlet extends HttpServlet {
	
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -3867054844632072630L;
	//创建UserDao的对象，以便于查询数据库
	UserDao userDao=new UserDao();
	
	//以下doGet方法和doPost方法分别对应form表单中的method="get"和method="post"
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				
			}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//利用getParameter方法获取到前台文本框中输入的值，其中括号内的内容为<input/>标签中的name属性
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		System.out.println(userid+"1??"+password);
		
		//调用UserDao中的getSelect方法并获取到返回值。	//调用
		boolean flag=userDao.getSelect(userid, password);
		//若用户名和密码存在则转发到index.jsp页面，否则重定向到error.jsp页面
		if (flag) {
			//转发
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			//重定向
			request.setAttribute("errorMessage", "用户名或密码不存在！");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	
		}
	}
