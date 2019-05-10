package com.peter.bean;

public class Street {
    private Integer id;

    private String name;

    private String url;

    private Integer jobType;

    private Integer areaId;

    public Street(Integer id, String name, String url, Integer jobType, Integer areaId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.jobType = jobType;
        this.areaId = areaId;
    }

    public Street() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", url=" + url + ", jobType=" + jobType + ", areaId=" + areaId
				+ "]";
	}

}