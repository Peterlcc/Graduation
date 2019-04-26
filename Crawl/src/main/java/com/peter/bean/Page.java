package com.peter.bean;

public class Page {
    private Integer id;

    private String url;

    private Integer serialNumber;

    private Integer jobType;

    private Integer streetId;
    private Street street;

    public Page(Integer id, String url, Integer serialNumber, Integer jobType, Integer streetId) {
        this.id = id;
        this.url = url;
        this.serialNumber = serialNumber;
        this.jobType = jobType;
        this.streetId = streetId;
    }

    public Page(Integer id, String url, Integer serialNumber, Integer jobType, Integer streetId, Street street) {
		super();
		this.id = id;
		this.url = url;
		this.serialNumber = serialNumber;
		this.jobType = jobType;
		this.streetId = streetId;
		this.street = street;
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

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", url=" + url + ", serialNumber=" + serialNumber + ", jobType=" + jobType
				+ ", streetId=" + streetId + ", street=" + street + "]";
	}

	
    
}