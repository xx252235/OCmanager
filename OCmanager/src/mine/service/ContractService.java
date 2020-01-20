package mine.service;

import java.text.ParseException;
import java.util.List;

import mine.dao.ContractDao;
import mine.utils.UUIDUtil;
import mine.vo.Contract;
import mine.vo.PageBean;
//������ķ���������servlet�еõ����ã�Ȼ����Ҳ�����dao�еķ���
public class ContractService {
	//ͨ��������ҳ����в�ѯ
	public PageBean<Contract> findAllByConditionPage(String branchorg,String objectname,String contracttype,String contractsum,String signdate,int pageCode,int pageSize){
		ContractDao dao = new ContractDao();
		System.out.println(branchorg+">>>>>>>>>>>"+objectname);
		return dao.findAllByConditionPage(branchorg,objectname,contracttype,contractsum,signdate,pageCode,pageSize);
	}
	//ͨ��ҳ����в�ѯ
	public PageBean<Contract> findAllByPage(int pageCode,int pageSize){
		ContractDao dao = new ContractDao();
		return dao.findAllByPage(pageCode,pageSize);
	}
	//ͨ���������ֽ��в�ѯ
	public List<Contract> findAllByNameOrOrgOrType(String objectname,String branchorg,String type){
		ContractDao dao = new ContractDao();
		return dao.findAllByNameOrOrgOrType(objectname,branchorg,type);
	}
	//���º�ͬ��Ҳ����ʵ�ֶԺ�ͬʵ�ֱ༭�޸ĵĹ���
	public void updateContract(Contract c) throws ParseException{
		ContractDao dao = new ContractDao();
		dao.update(c);
	}
	//��һ����ͬ
	public void addContract(Contract c){
		//Ϊ��ͬ��ȡһ��Ψһ��ID
		String id = UUIDUtil.getUUID("contract_info");
		c.setId(id);
		ContractDao dao = new ContractDao();
		dao.save(c);
	}
	//�ҵ����еĺ�ͬ�����÷�ҳ�Ĺ���
	public List<Contract> findAll(){
		ContractDao dao = new ContractDao();
		return dao.findAll();
	}
	//ͨ��ID�ҵ���Ӧ�ĺ�ͬ
	public Contract findById(String id){
		ContractDao dao = new ContractDao();
		return dao.findById(id);
	}
	//ɾ��һ����ͬ����
	public void deleteContract(String id) {
		ContractDao dao = new ContractDao();
		dao.deleteContract(id);
	}

}













