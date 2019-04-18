package com.peter.bean;

import java.util.List;

public class City {
    private Integer id;

    private String name;

    private String url;

    private String letter;

    private Integer jobType;

    private String province;
    private List<Area> areas;

    public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public City(Integer id, String name, String url, String letter, Integer jobType, String province,
			List<Area> areas) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.letter = letter;
		this.jobType = jobType;
		this.province = province;
		this.areas = areas;
	}

	public City(Integer id, String name, String url, String letter, Integer jobType, String province) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.letter = letter;
        this.jobType = jobType;
        this.province = province;
    }

    public City() {
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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter == null ? null : letter.trim();
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", url=" + url + ", letter=" + letter + ", jobType=" + jobType
				+ ", province=" + province + ", areas=" + areas + "]";
	}

	
    
}