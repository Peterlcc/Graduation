package com.peter.bean;


public class City {
	private int id=0;
	private String url=null;
	private int jobType=0;
	private String letter=null;
	private String name=null;
	private String province=null;
	public City(String url, int jobType, String letter, String name) {
		super();
		this.url = url;
		this.jobType = jobType;
		this.letter = letter;
		this.name = name;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
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
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [id="+id+",url=" + url + ", jobType=" + jobType + ", letter=" + letter + ", name=" + name + ", province="
				+ province + "]";
	}
	
	
	
}
