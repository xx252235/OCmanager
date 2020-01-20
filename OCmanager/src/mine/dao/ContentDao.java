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
	//�ҵ������û��ķ���������һ��List
	public List<Content> findAll(String contractid){
		//DButils�ķ���������һ��QueryRunner�࣬����Ĳ�����c3p0���ӳض���
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			System.out.println("bbbbbbbbbbbb"+contractid);
			//����һ��List
			return runner.query("select * from contract_content where contract_id = ?", new BeanListHandler<Content>(Content.class),contractid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯȫ�����ʧ��");
		}
	}
	//�÷�����addContent�õ�����
	public void save(Content c){
		try {
			//��ȡ¼��ʱ��
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        String Inputdate = sdf.format(new Date());
			Date sinputdate = sdf.parse(Inputdate);
			
			QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
			System.out.println(c.toString());
			// ��д��sql���
			String sql  = "insert into contract_content values (?,?,?,?,?,?,?,?)";
			// contract�����Ѿ��������ˣ����ǿ��Ի�ȡ���Ĳ���
			Object [] params = {c.getId(),c.getContract_id(),c.getContract_con(),c.getStyle(),c.getUnit(),c.getPrice(),sinputdate,sinputdate};
			// ��contract��������Ϊ���������ݴ�������ģ����У�λ�������Ӧ��
			runner.update(sql, params);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ��");
		}
	}
	//ͨ��ID�����в��Һ�ͬ����
	public Content findById(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			return runner.query("select * from contract_content where id = ?", new BeanHandler<Content>(Content.class) ,id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ͨ��ID��ѯʧ��");
		}
	}
	//�༭�û��������û�����Ϣ
	public void update(Content c) throws ParseException {
		//��ȡ����ʱ��
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
			throw new RuntimeException("�༭ʧ��");
		}
	}
	//����ҳ����������
	public List<Content> findAllByNameOrOrgOrType(String objectname,String branchorg,String type) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// ����һ��StringBuffer��������ַ�����ƴ��
			StringBuffer sb = new StringBuffer("select * from contract_content where 1=1 ");
			//���List����������������渳ֵ����
			List<Object> list = new ArrayList<Object>();
			// �����ѯ����objectname��Ϊ�ջ���ȥ���ո����Ȼ��Ϊ�գ��򽫲�ѯobjectname�����ƴ�ӵ�����
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
			throw new RuntimeException("��������ʧ��");
		}
	}
	
	//ɾ���û��Ĳ���
	public void deleteContent(String id) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			runner.update("delete from contract_content where id = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
	//��ҳ���ҵ����еļ�¼��Ŀ�꣬pagebean�����еĲ����������Ҳ����pagecode��
	public PageBean<Content> findAllByPage(int pageCode, int pageSize) {
		// ��ȡ��װ��pagebean����
		PageBean<Content> page = new PageBean<Content>();
		// ��ǰ��õ��ĵ�ǰҳ���ÿҳ��ʾ��������������
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			// ������ֵ���з�װ�������ݵ����������ظ�count
			long count = (Long) runner.query("select count(*) from contract_content", new ScalarHandler());
			// count�����ܵ�������Ҳ����TotalCount
			page.setTotalCount((int)count);
			//limit���һ���ʺŵ�λ�ã������￪ʼ
			//limit��ڶ����ʺŵ�λ�ã��ж�����
			// a = (pageCode - 1)*pageSize, b = pageSize
			String selSql = "select * from contract_content limit ? , ?";
			List<Content> beanList = runner.query(selSql, new BeanListHandler<Content>(Content.class), (pageCode - 1)*pageSize,pageSize);
			//����ѯ�����û��浽beanlist��
			page.setBeanList(beanList);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ҳ��������ʧ��");
		}
		
		return page;
	}
	//������ҳ���ң���ӵ�һ��
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
			throw new RuntimeException("��ҳ��������ʧ��");
		}
		return page;
	}

}
