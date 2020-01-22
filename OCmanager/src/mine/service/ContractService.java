package mine.service;

import java.text.ParseException;
import java.util.List;

import mine.dao.ContractDao;
import mine.utils.UUIDUtil;
import mine.vo.Contract;
import mine.vo.ContractContent;
import mine.vo.PageBean;
//这里面的方法，都在servlet中得到调用，然后，他也会调用dao中的方法
public class ContractService {
	//通过条件和页码进行查询
	public PageBean<Contract> findAllByConditionPage(String branchorg,String objectname,String contracttype,String contractsum,String signdate,int pageCode,int pageSize){
		ContractDao dao = new ContractDao();
		System.out.println(branchorg+">>>>>>>>>>>"+objectname);
		return dao.findAllByConditionPage(branchorg,objectname,contracttype,contractsum,signdate,pageCode,pageSize);
	}
	//通过页码进行查询
	public PageBean<Contract> findAllByPage(int pageCode,int pageSize){
		ContractDao dao = new ContractDao();
		return dao.findAllByPage(pageCode,pageSize);
	}
	//通过条件名字进行查询
	public List<Contract> findAllByNameOrOrgOrType(String objectname,String branchorg,String type){
		ContractDao dao = new ContractDao();
		return dao.findAllByNameOrOrgOrType(objectname,branchorg,type);
	}
	//更新合同，也就是实现对合同实现编辑修改的功能
	public void updateContract(Contract c) throws ParseException{
		ContractDao dao = new ContractDao();
		dao.update(c);
	}
	//加一个合同
	public void addContract(Contract c){
		//为合同获取一个唯一的ID
		String contract_id = UUIDUtil.getUUID("contract_info");
		c.setContract_id(contract_id);
		ContractDao dao = new ContractDao();
		dao.save(c);
	}
	//找到所有的合同，不用分页的功能
	public List<Contract> findAll(){
		ContractDao dao = new ContractDao();
		return dao.findAll();
	}
	//通过ID找到相应的合同
	public Contract findById(String contract_id){
		ContractDao dao = new ContractDao();
		return dao.findById(contract_id);
	}
	//删除一个合同数据
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
	 * @date 2020年1月21日 下午4:56:10
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













