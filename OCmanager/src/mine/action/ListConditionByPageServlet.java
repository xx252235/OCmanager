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

@WebServlet("/listConditionByPage")
public class ListConditionByPageServlet extends HttpServlet {

	private static final long serialVersionUID = -4084927848246923604L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//条件分页查找的这个地方需要拼接参数，所以，用的是get请求，然后下面就解决了get中文乱码的问题
		String objectname = request.getParameter("objectname");
		if(objectname != null && !objectname.trim().isEmpty()){
			objectname = new String(objectname.getBytes("ISO-8859-1"),"UTF-8");
		}
		String type = request.getParameter("type");
		if(type != null && !type.trim().isEmpty()){
			type = new String(type.getBytes("ISO-8859-1"),"UTF-8");
		}
		String branchorg = request.getParameter("branchorg");
		if(branchorg != null && !branchorg.trim().isEmpty()){
			branchorg = new String(branchorg.getBytes("ISO-8859-1"),"UTF-8");
		}
		String contractsum = request.getParameter("contractsum");
		if(contractsum != null && !contractsum.trim().isEmpty()){
			contractsum = new String(contractsum.getBytes("ISO-8859-1"),"UTF-8");
		}
		String signdate = request.getParameter("signdate");
		if(signdate != null && !signdate.trim().isEmpty()){
			signdate = new String(signdate.getBytes("ISO-8859-1"),"UTF-8");
		}
		
		String path = getPath(request);
		int pageCode = getPageCode(request);
		int pageSize = 10;
		
		ContractService cs = new ContractService();
		PageBean<Contract> page = cs.findAllByConditionPage(branchorg,objectname, type, contractsum, signdate, pageCode, pageSize);

		page.setUrl(path);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/listConditionByPage.jsp").forward(request, response);
		
	}
	public String getPath(HttpServletRequest request){
		String cPath = request.getContextPath();
		String sPath = request.getServletPath();
		String qString = request.getQueryString();
		if(qString != null && qString.contains("&pc=")){
			int index = qString.lastIndexOf("&pc=");
			qString = qString.substring(0, index);
		}
		
		return cPath+sPath+"?"+qString;
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
