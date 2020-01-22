package mine.utils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UUIDUtil {
	public static String getUUID(String tablename){
		String sDate,sNum,sUUID = null ,sTableID= "id";
		int sDatelen = 0,sMaxlen = 0,i = 0,m = 0;
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				sDate = sdf.format(date);
				sDatelen = sDate.length();
				if(tablename.equals("contract_info")) {
					sTableID = "contract_id";
				}else if(tablename.equals("contract_contract")) {
					sTableID = "content_id";
				}
				String sMaxSerialno =  (String)runner.query("select ifnull(max("+sTableID+"),'') from "+tablename+" where id like '"+ sDate+"%'", new ScalarHandler());
				sMaxlen = sMaxSerialno.length();
				if(sMaxSerialno.equals("")){
					System.out.println(sMaxSerialno);
			        sUUID = sDate+"0001";
				}else{
					Integer s = new Integer(sMaxSerialno.substring(sDatelen));
					s++;
					sNum = String.valueOf(s);
					m = sMaxlen-sDatelen-sNum.length();
					for(i = 0; i < m;i++){
						sNum = "0"+sNum;
					}
					sUUID = sDate + sNum;
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//这个方法可以获取一个唯一的比较长的ID
		return sUUID;

	}
}
