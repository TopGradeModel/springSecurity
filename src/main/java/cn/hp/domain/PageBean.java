package cn.hp.domain;

import java.util.List;

/**
 * @Description(手动分页工具类)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class PageBean<T> {
	private int currentPage;//当前页(页面传递的参数)
	private int pageSize;//每页显示多少条数据(页面传递的参数)
	private long totalCount;//总条数(select count(id) from product)
	private int totalPage;//总页数(totalCount*0.1/pageSize)
	private List<T> list;//每页显示的数据select * from product limit startIndex,pageSize  startIndex=(currentPage-1)*pageSize
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "pageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
	}

}
