package com.peter.bean;

public class Area {
    private Integer id;

    private String url;

    private String name;

    private Integer jobType;

    private Integer cityId;
    
    private City city;

    public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area(Integer id, String url, String name, Integer jobType, Integer cityId) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.jobType = jobType;
        this.cityId = cityId;
    }

    public Area(Integer id, String url, String name, Integer jobType, Integer cityId, City city) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.jobType = jobType;
		this.cityId = cityId;
		this.city = city;
	}

	public Area() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

	@Override
	public String toString() {
		return "Area [id=" + id + ", url=" + url + ", name=" + name + ", jobType=" + jobType + ", cityId=" + cityId
				+ ", city=" + city + "]";
	}

	
    
}