/**  
 * @Title: ExportServlet.java
 * @Description: TODO
 * @author: xu01.xin 
 * @date 2020年1月14日 下午4:36:29
 */
package mine.action;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mine.dao.ContractDao;
import mine.vo.Contract;

/**
 * @author xu01.xin
 *
 */
@WebServlet("/Export")
public class ExportServlet extends HttpServlet {
    private ContractDao contractDao = new ContractDao();
    
    @SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        
        String branchorg = request.getParameter("branchorg");
		String objectname = request.getParameter("objectname");
		String contracttype = request.getParameter("contracttype");
		/*if(branchorg != null && !branchorg.trim().isEmpty()){
			branchorg = new String(branchorg.getBytes("ISO-8859-1"),"UTF-8");
		}		
		if(objectname != null && !objectname.trim().isEmpty()){
			objectname = new String(objectname.getBytes("ISO-8859-1"),"UTF-8");
		}
		if(contracttype != null && !contracttype.trim().isEmpty()){
			contracttype = new String(contracttype.getBytes("ISO-8859-1"),"UTF-8");
		}*/
        System.out.println(objectname+"||||||||||"+branchorg+"|||||||||||||"+contracttype);
       //1. 查询要导出的数据,放入List中
        List<Contract> contract_list = contractDao.findAllByNameOrOrgOrType(objectname, branchorg, contracttype);
        if (contract_list.size() > 0) {
            //2. 创建一个excel工作簿
            String fileName = "合同信息表.xlsx";
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            XSSFWorkbook wb = new XSSFWorkbook();
            //3. 创建sheet页,设置表格样式
            
         // 生成一个样式
         XSSFCellStyle titlestyle = wb.createCellStyle();
         	// 设置这些样式
         titlestyle.setAlignment(HorizontalAlignment.CENTER); // 居中
         titlestyle.setVerticalAlignment(VerticalAlignment.CENTER);
         titlestyle.setWrapText(true);
         titlestyle.setBorderBottom(BorderStyle.THIN); //下边框  
         titlestyle.setBorderLeft(BorderStyle.THIN);//左边框  
         titlestyle.setBorderTop(BorderStyle.THIN);//上边框  
         titlestyle.setBorderRight(BorderStyle.THIN);//右边框 
         XSSFFont font = wb.createFont();                    //设置字体
         font.setFontName("microsoft yahei");
         font.setFontHeightInPoints((short) 18);
         titlestyle.setFont(font);
         
         XSSFCellStyle unitstyle = wb.createCellStyle();
      	// 设置这些样式
         unitstyle.setAlignment(HorizontalAlignment.CENTER); // 居中
         unitstyle.setVerticalAlignment(VerticalAlignment.CENTER);
         unitstyle.setWrapText(true);
         unitstyle.setBorderBottom(BorderStyle.THIN); //下边框  
         unitstyle.setBorderLeft(BorderStyle.THIN);//左边框  
         unitstyle.setBorderTop(BorderStyle.THIN);//上边框  
         unitstyle.setBorderRight(BorderStyle.THIN);//右边框 
         XSSFFont font1 = wb.createFont();                    //设置字体
         font1.setFontName("microsoft yahei");
         font1.setFontHeightInPoints((short) 10);
         unitstyle.setFont(font1);
      
         XSSFCellStyle cellStyle = wb.createCellStyle();//新建单元格样式
         XSSFFont font2 = wb.createFont();                    //设置字体
         font2.setFontName("microsoft yahei");
         font2.setFontHeightInPoints((short) 9);
         cellStyle.setFont(font2);
         //边框
         cellStyle.setBorderBottom(BorderStyle.THIN); //下边框  
         cellStyle.setBorderLeft(BorderStyle.THIN);//左边框  
         cellStyle.setBorderTop(BorderStyle.THIN);//上边框  
         cellStyle.setBorderRight(BorderStyle.THIN);//右边框 
         
            XSSFSheet sheet = wb.createSheet("合同信息");
            sheet.setDefaultRowHeight((short) (2 * 256));       //设置行高
            sheet.setColumnWidth(0, 2500);    //设置列宽
            sheet.setColumnWidth(1,2500);
            sheet.setColumnWidth(2,2500);
            sheet.setColumnWidth(3,2500);
            sheet.setColumnWidth(4,2500);
            sheet.setColumnWidth(5, 2500);    //设置列宽
            sheet.setColumnWidth(6,2500);
            sheet.setColumnWidth(7,2500);
            sheet.setColumnWidth(8,2500);
            sheet.setColumnWidth(9,2500);
            sheet.setColumnWidth(10, 2500);    //设置列宽
            sheet.setColumnWidth(11,2500);
            sheet.setColumnWidth(12,2500);
            sheet.setColumnWidth(13,2500);
            sheet.setColumnWidth(14,2500);
            
            //4. 在sheet中创建 行/单元格,向单元格中添加数据
            XSSFRow row = sheet.createRow(0);           //第0行
            XSSFCell cell = row.createCell(0);      //创建单元格
            cell.setCellValue("合同信息");
            cell.setCellStyle(titlestyle);
            
            
            
            CellRangeAddress region = new CellRangeAddress(0,0,0,14);
            sheet.addMergedRegion(region);                      //合并单元格
            sheet.autoSizeColumn(1, true);
            row = sheet.createRow(1);                   //第一行
            String[] unittitles = {"分公司","项目名称","合同类别","合同另一方","是否分劈","合同金额","签约日期","工期起日","工期止日","审批日期","公司存档情况","招投标情况","是否超预控","超预控金额（万元）","备注"};//""为占位字符串
            for(int i=0;i<unittitles.length;i++)
            {
            	cell = row.createCell(i);
                cell.setCellValue(unittitles[i]);
                cell.setCellStyle(unitstyle);
            }

            XSSFRow rows;
            XSSFCell cells;
            /*插入数据*/
            for (int i=0; i<contract_list.size(); i++) {
            	Contract contractClass = contract_list.get(i);
                rows = sheet.createRow(i+2);
                cells = rows.createCell(0);
                cells.setCellValue(contractClass.getBranchorg());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(1);
                cells.setCellValue(contractClass.getObjectname());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(2);
                cells.setCellValue(contractClass.getContracttype());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(3);
                cells.setCellValue(contractClass.getOtherside());
                cells.setCellStyle(cellStyle);
              cells = rows.createCell(4);
                cells.setCellValue(contractClass.getIspartition());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(5);
                cells.setCellValue(contractClass.getContractsum());
                cells.setCellStyle(cellStyle);
              cells = rows.createCell(6);
                cells.setCellValue(contractClass.getSigndate());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(7);
                cells.setCellValue(contractClass.getWorkdatefrom());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(8);
                cells.setCellValue(contractClass.getWorkdateto());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(9);
                cells.setCellValue(contractClass.getApprovedate());
                cells.setCellStyle(cellStyle);
              cells = rows.createCell(10);
                cells.setCellValue(contractClass.getIssave());
                cells.setCellStyle(cellStyle);
                cells = rows.createCell(11);
                cells.setCellValue(contractClass.getBidstate());
                cells.setCellStyle(cellStyle);
                cells = rows.createCell(12);
                cells.setCellValue(contractClass.getIsover());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(13);
                cells.setCellValue(contractClass.getOversum());
                cells.setCellStyle(cellStyle);
               cells = rows.createCell(14);
               cells.setCellValue(contractClass.getRemark());
                cells.setCellStyle(cellStyle);
            }
            //5. 控制台写入数据
            try {
                OutputStream out = response.getOutputStream();
                wb.write(out);
                out.close();
                wb.close();
            } catch (IOException e) {
                System.out.println("error");
                e.printStackTrace();    //输出异常信息
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
