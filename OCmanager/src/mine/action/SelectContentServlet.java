package mine.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContentService;
import mine.vo.Content;

@WebServlet("/selectContent")
public class SelectContentServlet extends HttpServlet {

	private static final long serialVersionUID = 6795411891797622045L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String contract_con = request.getParameter("contract_con");
		String contract_id = request.getParameter("contract_id");
		String readonly = request.getParameter("readonly");

		System.out.println(contract_con+"........"+contract_id+"......."+readonly);
		ContentService cs = new ContentService();
		List<Content> cList = cs.findByCon(contract_con, contract_id);
		request.setAttribute("cList", cList);
		request.setAttribute("readonly", readonly);
		request.setAttribute("relativeid", contract_id);

		System.out.println(contract_con+"........"+contract_id+"......."+readonly);
		request.getRequestDispatcher("/pages/listContent.jsp?readonly="+readonly+"&relativeid="+contract_id+"").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
