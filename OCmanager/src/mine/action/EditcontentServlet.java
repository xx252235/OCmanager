package mine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContentService;
import mine.service.ContractService;
import mine.vo.Content;
import mine.vo.Contract;

@WebServlet("/editcontent")
public class EditcontentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditcontentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content_id = request.getParameter("content_id");
		ContentService cs = new ContentService();
		Content c = cs.findById(content_id);
		request.setAttribute("c", c);
		request.setAttribute("contractid", c.getRelativeid());
		System.out.println(c.getRelativeid()+"|||"+c.getContract_con());
		//×ª·¢
		request.getRequestDispatcher("/pages/updatecontent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
