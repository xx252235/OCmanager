package mine.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import mine.service.ContractService;
import mine.vo.Contract;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -6356472998887476865L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String []> map = request.getParameterMap();
		Contract c = new Contract();
		try {
			BeanUtils.populate(c, map);
			ContractService cs = new ContractService();
			/*String [] loves = map.get("love");
			String love = Arrays.toString(loves);	
			love = love.substring(1, love.length() - 1);	
			c.setLove(love);*/
			try {
				cs.updateContract(c);
			} catch (ParseException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/listContract");
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
