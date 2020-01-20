package mine.dao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mine.utils.MyJdbcUtil;
import mine.vo.Content;
import mine.vo.Contract;
import mine.vo.PageBean;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.impl.NewPooledConnection;
public class ContentDao {
	//找到所有用户的方法，返回一个List
	public List<Content> findAll(String contractid){
		//DButils的方法，创建一个QueryRunner类，传入的参数是c3p0连接池对象
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			System.out.println("bbbbbbbbbbbb"+contractid);
			//返回一个List
			return runner.query("select * from contract_content where contract_id = ?", new BeanListHandler<Content>(Content.class),contractid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部结果失败");
		}
	}
	//该方法在addContent得到调用
	public void save(Content c){
		try {
			//获取录入时间
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        String Inputdate = sdf.format(new Date());
			Date sinputdate = sdf.parse(Inputdate);
			
			QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
			System.out.println(c.toString());
			// 先写出sql语句
			String sql  = "insert into contract_content values (?,?,?,?,?,?,?,?)";
			// contract对象已经传过来了，我们可以获取它的参数
			Object [] params = {c.getId(),c.getContract_id(),c.getContract_con(),c.getStyle(),c.getUnit(),c.getPrice(),sinputdate,sinputdate};
			// 将contract的内容作为参数的内容传到上面的？当中，位置是相对应的
			runner.update(sql, params);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		}
	}
	//通过ID来进行查找合同内容
	public Content findById(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			return runner.query("select * from contract_content where id = ?", new BeanHandler<Content>(Content.class) ,id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("通过ID查询失败");
		}
	}
	//编辑用户，更新用户的信息
	public void update(Content c) throws ParseException {
		//获取更新时间
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Updatedate = sdf.format(new Date());
        System.out.println(Updatedate+"?????????");
        Date supdatedate = sdf.parse(Updatedate);

		try {
			String sql = "update contract_content set contract_con = ? , style = ? , unit = ? , price = ? , updatedate = ? where id = ?";
			Object [] params = {c.getContract_con(),c.getStyle(),c.getUnit(),c.getPrice(),supdatedate,c.getId()};
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("编辑失败");
		}
	}
	//不分页的条件查找
	public List<Content> findAllByNameOrOrgOrType(String objectname,String branchorg,String type) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// 创建一个StringBuffer对象进行字符串的拼接
			StringBuffer sb = new StringBuffer("select * from contract_content where 1=1 ");
			//这个List用来存参数，在下面赋值给？
			List<Object> list = new ArrayList<Object>();
			// 如果查询条件objectname不为空或者去掉空格后仍然不为空，则将查询objectname的语句拼接到后面
			if(objectname != null && !objectname.trim().isEmpty()){
				sb.append(" and objectname = ? ");
				list.add(objectname);
			}
			if(branchorg != null && !branchorg.trim().isEmpty()){
				sb.append(" and branchorg = ? ");
				list.add(branchorg);
			}
			if(type != null && !type.trim().isEmpty()){
				sb.append(" and contracttype = ? ");
				list.add(type);
			}
			
			return runner.query(sb.toString(), new BeanListHandler<Content>(Content.class),list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("条件查找失败");
		}
	}
	
	//删除用户的操作
	public void deleteContent(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			runner.update("delete from contract_content where id = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}
	}
	//分页查找到所有的记录，目标，pagebean中所有的参数求出来，也就是pagecode等
	public PageBean<Content> findAllByPage(int pageCode, int pageSize) {
		// 获取封装的pagebean对象
		PageBean<Content> page = new PageBean<Content>();
		// 将前面得到的当前页码和每页显示的条数传到里面
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// 将单个值进行封装，求数据的条数，返回给count
			long count = (Long) runner.query("select count(*) from contract_content", new ScalarHandler());
			// count就是总的条数，也就是TotalCount
			page.setTotalCount((int)count);
			//limit后第一个问号的位置，从哪里开始
			//limit后第二个问号的位置，有多少条
			// a = (pageCode - 1)*pageSize, b = pageSize
			String selSql = "select * from contract_content limit ? , ?";
			List<Content> beanList = runner.query(selSql, new BeanListHandler<Content>(Content.class), (pageCode - 1)*pageSize,pageSize);
			//将查询到的用户存到beanlist中
			page.setBeanList(beanList);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查找所有失败");
		}
		
		return page;
	}
	//条件分页查找，最复杂的一个
	public PageBean<Content> findAllByConditionPage(String objectname, int pageCode, int pageSize) {
		PageBean<Content> page = new PageBean<Content>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		StringBuffer whereSb = new StringBuffer(" where 1 = 1 ");
		List<Object> params = new ArrayList<Object>();
		if(objectname != null && !objectname.trim().isEmpty()){
			whereSb.append(" and objectname = ?");
			params.add(objectname);
		}
		
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			
			StringBuffer countSb = new StringBuffer("select count(*) from contract_content ");
			String countSql = countSb.append(whereSb).toString();
			long count = (Long) runner.query(countSql, new ScalarHandler(),params.toArray());
			page.setTotalCount((int)count);
			StringBuffer selSb = new StringBuffer("select * from contract_content ");
			StringBuffer limitSb = new StringBuffer(" limit ? , ?");
			String selSql = selSb.append(whereSb).append(limitSb).toString();
			params.add((pageCode - 1)*pageSize);
			params.add(pageSize);
			List<Content> beanList = runner.query(selSql, new BeanListHandler<Content>(Content.class), params.toArray());
			page.setBeanList(beanList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页条件查找失败");
		}
		return page;
	}

}
