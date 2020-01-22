package mine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContentService;
import mine.vo.Content;

@WebServlet("/readonlycontent")
public class ReadonlyContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadonlyContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content_id = request.getParameter("content_id");
		ContentService cs = new ContentService();
		
		Content c = cs.findById(content_id);
		request.setAttribute("c", c);
		System.out.println("bbbbbbbbb"+content_id);
		//×ª·¢
		request.getRequestDispatcher("/pages/readonlycontent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
