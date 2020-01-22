package mine.service;

import java.text.ParseException;
import java.util.List;

import mine.dao.ContractDao;
import mine.utils.UUIDUtil;
import mine.vo.Contract;
import mine.vo.ContractContent;
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
		String contract_id = UUIDUtil.getUUID("contract_info");
		c.setContract_id(contract_id);
		ContractDao dao = new ContractDao();
		dao.save(c);
	}
	//�ҵ����еĺ�ͬ�����÷�ҳ�Ĺ���
	public List<Contract> findAll(){
		ContractDao dao = new ContractDao();
		return dao.findAll();
	}
	//ͨ��ID�ҵ���Ӧ�ĺ�ͬ
	public Contract findById(String contract_id){
		ContractDao dao = new ContractDao();
		return dao.findById(contract_id);
	}
	//ɾ��һ����ͬ����
	public void deleteContract(String contract_id) {
		ContractDao dao = new ContractDao();
		dao.deleteContract(contract_id);
	}
	/**  
	 * @Title: findAllByConditionPage1
	 * @Description: TODO
	 * @author: xu01.xin
	 * @param branchorg
	 * @param objectname
	 * @param contracttype
	 * @param contractsum
	 * @param signdate
	 * @param contract_con
	 * @param style
	 * @param unit
	 * @param price
	 * @param pageCode
	 * @param pageSize
	 * @return
	 * @date 2020��1��21�� ����4:56:10
	 */
	public PageBean<ContractContent> findAllByConditionPage1(String branchorg,
			String objectname, String contracttype, String contractsum,
			String signdate, String contract_con, String style, String unit,
			String price, int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		ContractDao dao = new ContractDao();
		System.out.println(branchorg+">>>>>>>>>>>"+objectname);
		return dao.findAllByConditionPage1(branchorg,objectname,contracttype,contractsum,signdate,contract_con,style,unit,price,pageCode,pageSize);
	}

}













