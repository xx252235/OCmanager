package mine.service;

import java.text.ParseException;
import java.util.List;

import mine.dao.ContentDao;
import mine.dao.ContractDao;
import mine.utils.UUIDUtil;
import mine.vo.Content;
import mine.vo.Contract;
import mine.vo.PageBean;
//������ķ���������servlet�еõ����ã�Ȼ����Ҳ�����dao�еķ���
public class ContentService {
	//ͨ��������ҳ����в�ѯ
	public PageBean<Content> findAllByConditionPage(String objectname,int pageCode,int pageSize){
		ContentDao dao = new ContentDao();
		return dao.findAllByConditionPage(objectname,pageCode,pageSize);
	}
	//ͨ��ҳ����в�ѯ
	public PageBean<Content> findAllByPage(int pageCode,int pageSize){
		ContentDao dao = new ContentDao();
		return dao.findAllByPage(pageCode,pageSize);
	}
	//ͨ���������ֽ��в�ѯ
	public List<Content> findAllByNameOrOrgOrType(String objectname,String branchorg,String type){
		ContentDao dao = new ContentDao();
		return dao.findAllByNameOrOrgOrType(objectname,branchorg,type);
	}
	//���º�ͬ��Ҳ����ʵ�ֶԺ�ͬʵ�ֱ༭�޸ĵĹ���
	public void updateContent(Content c) throws ParseException{
		ContentDao dao = new ContentDao();
		dao.update(c);
	}
	//��һ����ͬ
	public void addContent(Content c){
		//Ϊ��ͬ��ȡһ��Ψһ��ID
		String content_id = UUIDUtil.getUUID("contract_content");
		c.setContent_id(content_id);
		ContentDao dao = new ContentDao();
		dao.save(c);
	}
	//�ҵ����еĺ�ͬ�����÷�ҳ�Ĺ���
	public List<Content> findAll(String contract_id){
		ContentDao dao = new ContentDao();
		return dao.findAll(contract_id);
	}
	//ͨ��ID�ҵ���Ӧ�ĺ�ͬ
	public Content findById(String content_id){
		ContentDao dao = new ContentDao();
		return dao.findById(content_id);
	}
	//ɾ��һ����ͬ����
	public void deleteContent(String content_id) {
		ContentDao dao = new ContentDao();
		dao.deleteContent(content_id);
	}

}













