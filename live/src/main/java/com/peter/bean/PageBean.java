package com.peter.bean;

import java.util.List;

public class PageBean<T> {
	private int currentPage;
	private int pageSize;
	private int totalRecord;
	private List<T> beanList;
	private String url;
	public PageBean() {
	}
	

	public PageBean(int currentPage, int pageSize, int totalRecord, List<T> beanList, String url) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.beanList = beanList;
		this.url = url;
	}



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

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
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


	public int getTotalPage() {
		int totalPage=totalRecord/pageSize;
		return totalRecord%pageSize==0?totalPage:totalPage+1;
	}


	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
				+ ", beanList=" + beanList + ", url=" + url + "]";
	}

	

}
