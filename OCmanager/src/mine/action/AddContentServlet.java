package mine.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

@WebServlet("/addcontent")
public class AddContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddContentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String []> map = request.getParameterMap();
		Content c = new Content();
		try {
			BeanUtils.populate(c, map);
			ContentService cs = new ContentService();
			String [] contract_ids = map.get("contract_id");
			String contract_id = Arrays.toString(contract_ids);
			contract_id = contract_id.replace("[", "").replace("]", "");
			//System.out.println("aa"+contract_id+"aa");
			cs.addContent(c);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("<h3>?????</h3>");
			response.sendRedirect(request.getContextPath()+"/listContent?contract_id="+contract_id);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
