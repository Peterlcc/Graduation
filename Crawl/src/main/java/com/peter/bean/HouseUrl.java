package com.peter.bean;

public class HouseUrl {
    private Integer id;

    private String url;

    private Integer jobType;

    private Integer pageId;
    
    private Page page;

    public HouseUrl(Integer id, String url, Integer jobType, Integer pageId) {
        this.id = id;
        this.url = url;
        this.jobType = jobType;
        this.pageId = pageId;
    }

    public HouseUrl(Integer id, String url, Integer jobType, Integer pageId, Page page) {
		super();
		this.id = id;
		this.url = url;
		this.jobType = jobType;
		this.pageId = pageId;
		this.page = page;
	}

	public HouseUrl() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "HouseUrl [id=" + id + ", url=" + url + ", jobType=" + jobType + ", pageId=" + pageId + ", page=" + page
				+ "]";
	}
    
}