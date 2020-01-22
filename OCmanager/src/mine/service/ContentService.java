package mine.service;

import java.text.ParseException;
import java.util.List;

import mine.dao.ContentDao;
import mine.dao.ContractDao;
import mine.utils.UUIDUtil;
import mine.vo.Content;
import mine.vo.Contract;
import mine.vo.PageBean;
//这里面的方法，都在servlet中得到调用，然后，他也会调用dao中的方法
public class ContentService {
	//通过条件和页码进行查询
	public PageBean<Content> findAllByConditionPage(String objectname,int pageCode,int pageSize){
		ContentDao dao = new ContentDao();
		return dao.findAllByConditionPage(objectname,pageCode,pageSize);
	}
	//通过页码进行查询
	public PageBean<Content> findAllByPage(int pageCode,int pageSize){
		ContentDao dao = new ContentDao();
		return dao.findAllByPage(pageCode,pageSize);
	}
	//通过条件名字进行查询
	public List<Content> findAllByNameOrOrgOrType(String objectname,String branchorg,String type){
		ContentDao dao = new ContentDao();
		return dao.findAllByNameOrOrgOrType(objectname,branchorg,type);
	}
	//更新合同，也就是实现对合同实现编辑修改的功能
	public void updateContent(Content c) throws ParseException{
		ContentDao dao = new ContentDao();
		dao.update(c);
	}
	//加一个合同
	public void addContent(Content c){
		//为合同获取一个唯一的ID
		String content_id = UUIDUtil.getUUID("contract_content");
		c.setContent_id(content_id);
		ContentDao dao = new ContentDao();
		dao.save(c);
	}
	//找到所有的合同，不用分页的功能
	public List<Content> findAll(String contract_id){
		ContentDao dao = new ContentDao();
		return dao.findAll(contract_id);
	}
	//通过ID找到相应的合同
	public Content findById(String content_id){
		ContentDao dao = new ContentDao();
		return dao.findById(content_id);
	}
	//删除一个合同数据
	public void deleteContent(String content_id) {
		ContentDao dao = new ContentDao();
		dao.deleteContent(content_id);
	}

}













