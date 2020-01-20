/**  
 * @Title: LoginServlet.java
 * @Description: TODO
 * @author: xu01.xin 
 * @date 2020��1��10�� ����3:59:07
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
//����ʱΪServlet������Class����Ҫ��web.xml�н������ã����õĴ���Myeclipse���Զ�����
public class LoginServlet extends HttpServlet {
	
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -3867054844632072630L;
	//����UserDao�Ķ����Ա��ڲ�ѯ���ݿ�
	UserDao userDao=new UserDao();
	
	//����doGet������doPost�����ֱ��Ӧform���е�method="get"��method="post"
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				
			}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����getParameter������ȡ��ǰ̨�ı����������ֵ�����������ڵ�����Ϊ<input/>��ǩ�е�name����
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		System.out.println(userid+"1??"+password);
		
		//����UserDao�е�getSelect��������ȡ������ֵ��	//����
		boolean flag=userDao.getSelect(userid, password);
		//���û��������������ת����index.jspҳ�棬�����ض���error.jspҳ��
		if (flag) {
			//ת��
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			//�ض���
			request.setAttribute("errorMessage", "�û��������벻���ڣ�");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	
		}
	}
