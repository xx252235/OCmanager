package mine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContractService;
import mine.vo.Contract;
import mine.vo.PageBean;

@WebServlet("/listContractByPage")
public class ListContractByPageServlet extends HttpServlet {

	private static final long serialVersionUID = -9084209486253210123L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = getPageCode(request);
		int pageSize = 10;
		ContractService cs = new ContractService();
		PageBean<Contract> page = cs.findAllByPage(pageCode, pageSize);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/listByPage.jsp").forward(request, response);
	}
	
	public int getPageCode(HttpServletRequest request){
		String pc = request.getParameter("pc");
		if(pc == null || pc.trim().isEmpty()){
			return 1;
		}else{
			return Integer.parseInt(pc);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}






