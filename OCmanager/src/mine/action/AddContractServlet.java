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

import mine.service.ContractService;
import mine.vo.Contract;

@WebServlet("/addcontract")
public class AddContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddContractServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String []> map = request.getParameterMap();
		Contract c = new Contract();
		try {
			BeanUtils.populate(c, map);
			ContractService cs = new ContractService();
			String []remarks = map.get("remark");
			String remark = Arrays.toString(remarks);
			System.out.println(JSON.toJSONString(map));
			c.setRemark(remark.replace("[", "").replace("]", ""));
			cs.addContract(c);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("<h3>?????</h3>");
			response.sendRedirect(request.getContextPath()+"/listContract");
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
