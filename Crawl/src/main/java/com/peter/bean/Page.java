package com.peter.bean;

public class Page {
    private Integer id;

    private String url;

    private Integer serialNumber;

    private Integer jobType;

    private Integer areaId;

    public Page(Integer id, String url, Integer serialNumber, Integer jobType, Integer areaId) {
        this.id = id;
        this.url = url;
        this.serialNumber = serialNumber;
        this.jobType = jobType;
        this.areaId = areaId;
    }

    public Page() {
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

	@Override
	public String toString() {
		return "Page [id=" + id + ", url=" + url + ", serialNumber=" + serialNumber + ", jobType=" + jobType
				+ ", areaId=" + areaId + "]";
	}
    
}