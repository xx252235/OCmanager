package mine.dao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mine.utils.MyJdbcUtil;
import mine.vo.Contract;
import mine.vo.PageBean;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
public class ContractDao {
	//�ҵ������û��ķ���������һ��List
	public List<Contract> findAll(){
		//DButils�ķ���������һ��QueryRunner�࣬����Ĳ�����c3p0���ӳض���
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			//DButils���ض�����ɾ�鷽����һ���оŸ�ʵ����
			//����һ��List
			return runner.query("select * from contract_info", new BeanListHandler<Contract>(Contract.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯȫ�����ʧ��");
		}
	}
	//�÷�����addContract�õ�����
	public void save(Contract c){
		try {
			/**
			 *`id` varchar(40) NOT NULL,
			  `branchorg` varchar(20) DEFAULT NULL COMMENT '�ֹ�˾',
			  `objectname` varchar(10) DEFAULT NULL COMMENT '��Ŀ����',
			  `contracttype` varchar(20) DEFAULT NULL,
			  `otherside` varchar(50) DEFAULT NULL,
			  `ispartition` varchar(10) DEFAULT NULL COMMENT '�Ƿ����',
			  `contractsum` double(100,0) DEFAULT NULL COMMENT '��ͬ���',
			  `signdate` date DEFAULT NULL COMMENT 'ǩԼ����',
			  `workdatefrom` date DEFAULT NULL COMMENT '��������',
			  `workdateto` varchar(40) DEFAULT NULL COMMENT '����������',
			  `approvedate` date DEFAULT NULL COMMENT '��������',
			  `issave` varchar(10) DEFAULT NULL COMMENT '��˾�浵���',
			  `bidstate` varchar(10) DEFAULT NULL COMMENT '��Ͷ�����',
			  `isover` varchar(10) DEFAULT NULL COMMENT '�Ƿ�Ԥ��',
			  `oversum` double(100,0) DEFAULT NULL COMMENT '��Ԥ�ؽ���Ԫ��',
			  `remark` varchar(255) DEFAULT NULL COMMENT '��ע'
			 */
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date SignDate = null;
	        Date Workdatefrom = null;
	        Date Approvedate = null;
			if(!c.getSigndate().equals("")){
				SignDate = sdf.parse(c.getSigndate());
			}
			if(!c.getSigndate().equals("")){
				Workdatefrom = sdf.parse(c.getWorkdatefrom());
			}
			if(!c.getSigndate().equals("")){
				Approvedate = sdf.parse(c.getApprovedate());
			}
			QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
			System.out.println(c.toString());
			// ��д��sql���
			String sql  = "insert into contract_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// contract�����Ѿ��������ˣ����ǿ��Ի�ȡ���Ĳ���
			Object [] params = {c.getId(),c.getBranchorg(),c.getObjectname(),c.getContracttype(),c.getOtherside(),c.getIspartition(),
					c.getContractsum(),SignDate,Workdatefrom,c.getWorkdateto(),Approvedate,
					c.getIssave(),c.getBidstate(),c.getIsover(),c.getOversum(),c.getRemark()};
			// ��contract��������Ϊ���������ݴ�������ģ����У�λ�������Ӧ��
			runner.update(sql, params);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ��");
		}
	}
	//ͨ��ID�����в��Һ�ͬ
	public Contract findById(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			return runner.query("select * from contract_info where id = ?", new BeanHandler<Contract>(Contract.class) ,id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ͨ��ID��ѯʧ��");
		}
	}
	//�༭�û��������û�����Ϣ
	public void update(Contract c) throws ParseException {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "update contract_info set Objectname = ? , Contracttype = ? , Otherside = ? , Ispartition=? ,Contractsum = ?, Signdate = ?, Workdatefrom=?, Workdateto=?, Approvedate=?, Issave=?, Bidstate=?, Isover=?, Oversum=?, Remark=? where id = ?";
			Object [] params = {c.getObjectname(),c.getContracttype(),c.getOtherside(),c.getIspartition(),
					c.getContractsum(),sdf.parse(c.getSigndate()),sdf.parse(c.getWorkdatefrom()),c.getWorkdateto(),sdf.parse(c.getApprovedate()),
					c.getIssave(),c.getBidstate(),c.getIsover(),c.getOversum(),c.getRemark(),c.getId()};
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�༭ʧ��");
		}
	}
	//����ҳ����������
	public List<Contract> findAllByNameOrOrgOrType(String objectname,String branchorg,String type) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// ����һ��StringBuffer��������ַ�����ƴ��
			StringBuffer sb = new StringBuffer("select * from contract_info where 1=1 ");
			//���List����������������渳ֵ����
			List<Object> list = new ArrayList<Object>();
			// �����ѯ����objectname��Ϊ�ջ���ȥ���ո����Ȼ��Ϊ�գ��򽫲�ѯobjectname�����ƴ�ӵ�����
			if(objectname != null && !objectname.trim().isEmpty()){
				sb.append(" and objectname like ? ");
				list.add("%"+objectname+"%");
			}
			if(branchorg != null && !branchorg.trim().isEmpty()){
				sb.append(" and branchorg = ? ");
				list.add(branchorg);
			}
			if(type != null && !type.trim().isEmpty()){
				sb.append(" and contracttype = ? ");
				list.add(type);
			}
			System.out.println("ssssssssssss"+sb.toString());
			return runner.query(sb.toString(), new BeanListHandler<Contract>(Contract.class),list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ��");
		}
	}
	
	//ɾ���û��Ĳ���
	public void deleteContract(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			runner.update("delete from contract_info where id = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
	//��ҳ���ҵ����еļ�¼��Ŀ�꣬pagebean�����еĲ����������Ҳ����pagecode��
	public PageBean<Contract> findAllByPage(int pageCode, int pageSize) {
		// ��ȡ��װ��pagebean����
		PageBean<Contract> page = new PageBean<Contract>();
		// ��ǰ��õ��ĵ�ǰҳ���ÿҳ��ʾ��������������
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// ������ֵ���з�װ�������ݵ����������ظ�count
			long count = (Long) runner.query("select count(*) from contract_info", new ScalarHandler());
			// count�����ܵ�������Ҳ����TotalCount
			page.setTotalCount((int)count);
			//limit���һ���ʺŵ�λ�ã������￪ʼ
			//limit��ڶ����ʺŵ�λ�ã��ж�����
			// a = (pageCode - 1)*pageSize, b = pageSize
			String selSql = "select * from contract_info limit ? , ?";
			List<Contract> beanList = runner.query(selSql, new BeanListHandler<Contract>(Contract.class), (pageCode - 1)*pageSize,pageSize);
			//����ѯ�����û��浽beanlist��
			page.setBeanList(beanList);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ҳ��������ʧ��");
		}
		
		return page;
	}
	//������ҳ���ң���ӵ�һ��
	public PageBean<Contract> findAllByConditionPage(String branchorg,String objectname,String contracttype,String contractsum,String signdate, int pageCode, int pageSize) {
		PageBean<Contract> page = new PageBean<Contract>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		StringBuffer whereSb = new StringBuffer(" where 1 = 1 ");
		List<Object> params = new ArrayList<Object>();
		if(branchorg != null && !branchorg.trim().isEmpty()){
			whereSb.append(" and branchorg = ?");
			params.add(branchorg);
		}
		if(objectname != null && !objectname.trim().isEmpty()){
			whereSb.append(" and objectname like ?");
			params.add("%"+objectname+"%");
		}
		if(contracttype != null && !contracttype.trim().isEmpty()){
			whereSb.append(" and contracttype = ?");
			params.add(contracttype);
		}
		if(contractsum != null && !contractsum.trim().isEmpty()){
			whereSb.append(" and contractsum = ?");
			params.add(contractsum);
		}
		if(signdate != null && !signdate.trim().isEmpty()){
			whereSb.append(" and signdate = ?");
			params.add(signdate);
		}
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			
			StringBuffer countSb = new StringBuffer("select count(*) from contract_info ");
			String countSql = countSb.append(whereSb).toString();
			long count = (Long) runner.query(countSql, new ScalarHandler(),params.toArray());
			page.setTotalCount((int)count);
			StringBuffer selSb = new StringBuffer("select * from contract_info ");
			StringBuffer limitSb = new StringBuffer(" limit ? , ?");
			String selSql = selSb.append(whereSb).append(limitSb).toString();
			params.add((pageCode - 1)*pageSize);
			params.add(pageSize);
			List<Contract> beanList = runner.query(selSql, new BeanListHandler<Contract>(Contract.class), params.toArray());
			page.setBeanList(beanList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ҳ��������ʧ��");
		}
		return page;
	}

}













