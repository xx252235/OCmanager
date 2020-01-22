package mine.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContractService;
import mine.vo.Contract;

@WebServlet("/initupdate")
public class InitupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitupdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contract_id = request.getParameter("contract_id");
		ContractService cs = new ContractService();
		Contract c = cs.findById(contract_id);
		request.setAttribute("c", c);
		//×ª·¢
		request.getRequestDispatcher("/pages/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
