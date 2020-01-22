package mine.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContentService;
import mine.service.ContractService;
import mine.vo.Content;
import mine.vo.Contract;

@WebServlet("/listContent")
public class ListContentServlet extends HttpServlet {

	private static final long serialVersionUID = -825089887570284957L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contract_id  = request.getParameter("contract_id");
		ContentService cs = new ContentService();
		List<Content> cList = cs.findAll(contract_id);
		System.out.println("2222222222"+contract_id);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("/pages/listContent.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
