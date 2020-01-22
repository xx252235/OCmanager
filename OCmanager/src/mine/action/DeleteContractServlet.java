package mine.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContractService;

@WebServlet("/deletecontract")
public class DeleteContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteContractServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//由于是删除的操作，所以只需要获取它的ID就可以把它删除
		String contract_id = request.getParameter("contract_id");
		ContractService cs = new ContractService();
		cs.deleteContract(contract_id);
		//重定向
		response.sendRedirect(request.getContextPath()+"/listContract");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
