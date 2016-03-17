package th.ac.fi2.xstream.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("paging")
public class Paging implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("pageNo")
	private int pageNo = 1; 
	
	@XStreamAlias("pageSize")
	private int pageSize = 20;
	
	@XStreamAlias("totalRecord")
	private int totalRecord = 0;
	
	@XStreamAlias("startIndex")
	private int startIndex = 0;
	
	@XStreamAlias("orderBy")
	private String orderBy = "";
	
	@XStreamAlias("sortBy")
	private String sortBy = "";

	public Paging(int pageNo, int pageSize, String orderBy) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderBy = orderBy;
		this.sortBy = "DESC";
	}

	public Paging() {
		pageNo = 1;
		pageSize = 20;
		totalRecord = 0;
		orderBy = ""; 
		startIndex = 0;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	

}
