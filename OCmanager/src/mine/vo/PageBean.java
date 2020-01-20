package mine.vo;

import java.util.List;

public class PageBean<T> {
	/*����һ����ҳ����ʵ�ֵĶ���������������ж������
	 * pagecode��ǰҳ����ҳ���ȡ
	 * totalpage��ҳ����ͨ��������Եó�
	 * totalcount�ܼ�¼���������ݿ��в�ѯ�ɵ�
	 * pagesizeÿҳ��ʾ�����������Լ��趨
	 * beanlistÿҳ�����ݣ��洢��beanlist����
	 * 
	*/
	private int pageCode;
	private int totalCount;
	private int pageSize;
	private List<T> beanList;
	//URL�ķ�װ������ҳ��ѯ��������ѯ���ϵ�ʱ�򣬻����һ�����⣬������������֮���ڽ��з�ҳ����ת
	//��ʹ��������ʧ�����ԣ���Ҫ����һ��ƴ���ַ����ķ�ʽ����url���ظ�jspҳ�档
	private String url;
	//����get��set��������������Щ����Ҫ���õģ���Щ��Ҫ�Լ�����ģ���������ͨ��װ��get��set������Щ��ͬ
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	//��ȡ��ҳ���ķ������������������ÿҳ��������Ϊ0����ô�������totalpage
	//�������������ô����ҳ���ټ���1����ʾʣ�µ�����
	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	/*����Ҫ���õķ�������Ϊ�Ǽ���ģ�����ֻ��Ҫ��ȡ�Ϳ�����
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
