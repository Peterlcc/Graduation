package com.peter.bean;

public class Area {
	private int id=0;
	private String url=null;
	private int jobType=0;
	private String name=null;
	private City city=null;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(int id, String url, int jobType, String name, City city) {
		super();
		this.id = id;
		this.url = url;
		this.jobType = jobType;
		this.name = name;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", url=" + url + ", jobType=" + jobType + ", name=" + name + ", city=" + city + "]";
	}
	
}
