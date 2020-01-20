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
	//找到所有用户的方法，返回一个List
	public List<Contract> findAll(){
		//DButils的方法，创建一个QueryRunner类，传入的参数是c3p0连接池对象
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			//DButils的特定的增删查方法，一共有九个实现类
			//返回一个List
			return runner.query("select * from contract_info", new BeanListHandler<Contract>(Contract.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部结果失败");
		}
	}
	//该方法在addContract得到调用
	public void save(Contract c){
		try {
			/**
			 *`id` varchar(40) NOT NULL,
			  `branchorg` varchar(20) DEFAULT NULL COMMENT '分公司',
			  `objectname` varchar(10) DEFAULT NULL COMMENT '项目名称',
			  `contracttype` varchar(20) DEFAULT NULL,
			  `otherside` varchar(50) DEFAULT NULL,
			  `ispartition` varchar(10) DEFAULT NULL COMMENT '是否分劈',
			  `contractsum` double(100,0) DEFAULT NULL COMMENT '合同金额',
			  `signdate` date DEFAULT NULL COMMENT '签约日期',
			  `workdatefrom` date DEFAULT NULL COMMENT '工作日起',
			  `workdateto` varchar(40) DEFAULT NULL COMMENT '工作日期至',
			  `approvedate` date DEFAULT NULL COMMENT '审批日期',
			  `issave` varchar(10) DEFAULT NULL COMMENT '公司存档情况',
			  `bidstate` varchar(10) DEFAULT NULL COMMENT '招投标情况',
			  `isover` varchar(10) DEFAULT NULL COMMENT '是否超预控',
			  `oversum` double(100,0) DEFAULT NULL COMMENT '超预控金额（万元）',
			  `remark` varchar(255) DEFAULT NULL COMMENT '备注'
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
			// 先写出sql语句
			String sql  = "insert into contract_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// contract对象已经传过来了，我们可以获取它的参数
			Object [] params = {c.getId(),c.getBranchorg(),c.getObjectname(),c.getContracttype(),c.getOtherside(),c.getIspartition(),
					c.getContractsum(),SignDate,Workdatefrom,c.getWorkdateto(),Approvedate,
					c.getIssave(),c.getBidstate(),c.getIsover(),c.getOversum(),c.getRemark()};
			// 将contract的内容作为参数的内容传到上面的？当中，位置是相对应的
			runner.update(sql, params);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		}
	}
	//通过ID来进行查找合同
	public Contract findById(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			return runner.query("select * from contract_info where id = ?", new BeanHandler<Contract>(Contract.class) ,id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("通过ID查询失败");
		}
	}
	//编辑用户，更新用户的信息
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
			throw new RuntimeException("编辑失败");
		}
	}
	//不分页的条件查找
	public List<Contract> findAllByNameOrOrgOrType(String objectname,String branchorg,String type) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// 创建一个StringBuffer对象进行字符串的拼接
			StringBuffer sb = new StringBuffer("select * from contract_info where 1=1 ");
			//这个List用来存参数，在下面赋值给？
			List<Object> list = new ArrayList<Object>();
			// 如果查询条件objectname不为空或者去掉空格后仍然不为空，则将查询objectname的语句拼接到后面
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
			throw new RuntimeException("条件查找失败");
		}
	}
	
	//删除用户的操作
	public void deleteContract(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			runner.update("delete from contract_info where id = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}
	}
	//分页查找到所有的记录，目标，pagebean中所有的参数求出来，也就是pagecode等
	public PageBean<Contract> findAllByPage(int pageCode, int pageSize) {
		// 获取封装的pagebean对象
		PageBean<Contract> page = new PageBean<Contract>();
		// 将前面得到的当前页码和每页显示的条数传到里面
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// 将单个值进行封装，求数据的条数，返回给count
			long count = (Long) runner.query("select count(*) from contract_info", new ScalarHandler());
			// count就是总的条数，也就是TotalCount
			page.setTotalCount((int)count);
			//limit后第一个问号的位置，从哪里开始
			//limit后第二个问号的位置，有多少条
			// a = (pageCode - 1)*pageSize, b = pageSize
			String selSql = "select * from contract_info limit ? , ?";
			List<Contract> beanList = runner.query(selSql, new BeanListHandler<Contract>(Contract.class), (pageCode - 1)*pageSize,pageSize);
			//将查询到的用户存到beanlist中
			page.setBeanList(beanList);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查找所有失败");
		}
		
		return page;
	}
	//条件分页查找，最复杂的一个
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
			throw new RuntimeException("分页条件查找失败");
		}
		return page;
	}

}













