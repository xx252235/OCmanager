package mine.vo;

import java.util.List;

public class PageBean<T> {
	/*这是一个分页功能实现的对象，在这个对象里有多个变量
	 * pagecode当前页，从页面获取
	 * totalpage总页数，通过计算可以得出
	 * totalcount总记录数，从数据库中查询可得
	 * pagesize每页显示的条数，由自己设定
	 * beanlist每页的数据，存储在beanlist当中
	 * 
	*/
	private int pageCode;
	private int totalCount;
	private int pageSize;
	private List<T> beanList;
	//URL的封装，当分页查询和条件查询相结合的时候，会出现一个问题，就是条件查找之后，在进行分页的跳转
	//会使得条件消失，所以，需要采用一种拼接字符串的方式，将url返回给jsp页面。
	private String url;
	//设置get和set方法，但这里有些是需要设置的，有些是要自己计算的，所以与普通封装的get和set方法有些许不同
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	//获取总页数的方法，如果总条数除以每页条数余数为0，那么结果就是totalpage
	//如果有余数，那么就让页数再加上1来显示剩下的内容
	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	/*不需要设置的方法，因为是计算的，所以只需要获取就可以了
	 * public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
