package mine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.service.ContentService;
import mine.service.ContractService;

@WebServlet("/deletecontent")
public class DeleteContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ɾ���Ĳ���������ֻ��Ҫ��ȡ����ID�Ϳ��԰���ɾ��
		String content_id = request.getParameter("content_id");
		String contract_id = request.getParameter("contract_id");
		//System.out.println(contract_id+"?????????");
		ContentService cs = new ContentService();
		cs.deleteContent(content_id);
		//�ض���
		response.sendRedirect(request.getContextPath()+"/listContent?contract_id="+contract_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
