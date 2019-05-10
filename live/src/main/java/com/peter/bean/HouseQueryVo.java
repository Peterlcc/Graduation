package com.peter.bean;

public class HouseQueryVo {
	private  House house;
	private PageBean<House> pageBean;
	private Double maxPrice;
	private Double minPrice;
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public PageBean<House> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<House> pageBean) {
		this.pageBean = pageBean;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	@Override
	public String toString() {
		return "HouseQueryVo [house=" + house + ", pageBean=" + pageBean + ", maxPrice=" + maxPrice + ", minPrice="
				+ minPrice + "]";
	}
	
	
}
