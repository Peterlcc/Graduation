package com.peter.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class House {
    private Integer id;

    private String url;

    private String title;

    private String houseCode;

    private Date releaseTime;

    private String businessLicense;

    private BigDecimal price;

    private String payType;

    private String tags;

    private String rentType;

    private String roomType;

    private Double area;

    private String direction;

    private String dealerName;

    private String dealerCompany;

    private String dealerType;

    private String dealerPhone;

    private String checkinType;

    private String rentTime;

    private String lookType;

    private String floor;

    private String elevator;

    private String carPos;

    private String water;

    private String electricity;

    private String gas;

    private String facility;

    private String nearby;

    private String city;

    private String areaCity;

    private String street;

    private Integer page;
    private List<String> imgUrls;
    
    private Integer logNum;
    private Integer collectNum;
    private Integer phoneNum;
    

    public Integer getLogNum() {
		return logNum;
	}

	public void setLogNum(Integer logNum) {
		this.logNum = logNum;
	}

	public Integer getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public List<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}

	public House(Integer id, String url, String title, String houseCode, Date releaseTime, String businessLicense, BigDecimal price, String payType, String tags, String rentType, String roomType, Double area, String direction, String dealerName, String dealerCompany, String dealerType, String dealerPhone, String checkinType, String rentTime, String lookType, String floor, String elevator, String carPos, String water, String electricity, String gas, String facility, String nearby, String city, String areaCity, String street, Integer page) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.houseCode = houseCode;
        this.releaseTime = releaseTime;
        this.businessLicense = businessLicense;
        this.price = price;
        this.payType = payType;
        this.tags = tags;
        this.rentType = rentType;
        this.roomType = roomType;
        this.area = area;
        this.direction = direction;
        this.dealerName = dealerName;
        this.dealerCompany = dealerCompany;
        this.dealerType = dealerType;
        this.dealerPhone = dealerPhone;
        this.checkinType = checkinType;
        this.rentTime = rentTime;
        this.lookType = lookType;
        this.floor = floor;
        this.elevator = elevator;
        this.carPos = carPos;
        this.water = water;
        this.electricity = electricity;
        this.gas = gas;
        this.facility = facility;
        this.nearby = nearby;
        this.city = city;
        this.areaCity = areaCity;
        this.street = street;
        this.page = page;
    }

    public House() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode == null ? null : houseCode.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getDealerCompany() {
        return dealerCompany;
    }

    public void setDealerCompany(String dealerCompany) {
        this.dealerCompany = dealerCompany == null ? null : dealerCompany.trim();
    }

    public String getDealerType() {
        return dealerType;
    }

    public void setDealerType(String dealerType) {
        this.dealerType = dealerType == null ? null : dealerType.trim();
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone == null ? null : dealerPhone.trim();
    }

    public String getCheckinType() {
        return checkinType;
    }

    public void setCheckinType(String checkinType) {
        this.checkinType = checkinType == null ? null : checkinType.trim();
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime == null ? null : rentTime.trim();
    }

    public String getLookType() {
        return lookType;
    }

    public void setLookType(String lookType) {
        this.lookType = lookType == null ? null : lookType.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
    }

    public String getCarPos() {
        return carPos;
    }

    public void setCarPos(String carPos) {
        this.carPos = carPos == null ? null : carPos.trim();
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water == null ? null : water.trim();
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity == null ? null : electricity.trim();
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas == null ? null : gas.trim();
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility == null ? null : facility.trim();
    }

    public String getNearby() {
        return nearby;
    }

    public void setNearby(String nearby) {
        this.nearby = nearby == null ? null : nearby.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity == null ? null : areaCity.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

	@Override
	public String toString() {
		return "House [id=" + id + ", url=" + url + ", title=" + title + ", houseCode=" + houseCode + ", releaseTime="
				+ releaseTime + ", businessLicense=" + businessLicense + ", price=" + price + ", payType=" + payType
				+ ", tags=" + tags + ", rentType=" + rentType + ", roomType=" + roomType + ", area=" + area
				+ ", direction=" + direction + ", dealerName=" + dealerName + ", dealerCompany=" + dealerCompany
				+ ", dealerType=" + dealerType + ", dealerPhone=" + dealerPhone + ", checkinType=" + checkinType
				+ ", rentTime=" + rentTime + ", lookType=" + lookType + ", floor=" + floor + ", elevator=" + elevator
				+ ", carPos=" + carPos + ", water=" + water + ", electricity=" + electricity + ", gas=" + gas
				+ ", facility=" + facility + ", nearby=" + nearby + ", city=" + city + ", areaCity=" + areaCity
				+ ", street=" + street + ", page=" + page + ", imgUrls=" + imgUrls + ", logNum=" + logNum
				+ ", collectNum=" + collectNum + ", phoneNum=" + phoneNum + "]";
	}
    
}