package com.peter.bean;

public class CrawlJob {
	private String host=null;
	private String url=null;
	private int jobType=0;
	public CrawlJob() {
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getJobType() {
		return jobType;
	}
	public void setJobType(int jobType) {
		this.jobType = jobType;
	}

	@Override
	public String toString() {
		return "CrawlJob [host=" + host + ", url=" + url + ", jobType=" + jobType + "]";
	}
	
	
}
