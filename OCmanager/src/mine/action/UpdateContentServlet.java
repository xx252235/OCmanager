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

import com.alibaba.fastjson.JSON;

import mine.service.ContentService;
import mine.service.ContractService;
import mine.vo.Content;
import mine.vo.Contract;

@WebServlet("/updatecontent")
public class UpdateContentServlet extends HttpServlet {

	private static final long serialVersionUID = -6356472998887476865L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String []> map = request.getParameterMap();
		Content c = new Content();
		try {
			BeanUtils.populate(c, map);
			String Contractid = request.getParameter("contractid");
			ContentService cs = new ContentService();
			//System.out.println(Contractid+"????????????"+JSON.toJSONString(map));

			/*String [] loves = map.get("love");
			String love = Arrays.toString(loves);	
			love = love.substring(1, love.length() - 1);	
			c.setLove(love);*/
			try {
				cs.updateContent(c);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String [] Contract_ids = map.get("contract_id");
			String Contract_id = Arrays.toString(Contract_ids).replace("[", "").replace("]", "");
			response.sendRedirect(request.getContextPath()+"/listContent?contract_id="+Contract_id);
			
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
