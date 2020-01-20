package mine.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContractService;
import mine.vo.Contract;

@WebServlet("/selectByName")
public class SelectByNameServlet extends HttpServlet {

	private static final long serialVersionUID = 6795411891797622045L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String objectname = request.getParameter("objectname");
		String branchorg = request.getParameter("branchorg");
		String contracttype = request.getParameter("contracttype");
		System.out.println(objectname+"........"+branchorg+"........"+contracttype);
		ContractService cs = new ContractService();
		List<Contract> cList = cs.findAllByNameOrOrgOrType(objectname, branchorg, contracttype);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("/pages/listContract.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
