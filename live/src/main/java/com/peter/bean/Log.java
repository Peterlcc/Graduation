package com.peter.bean;

public class Log {
    private Integer id;

    private Integer userId;
    private User user;

    private Integer houseId;
    private House house;

    public Log(Integer id, Integer userId, Integer houseId) {
        this.id = id;
        this.userId = userId;
        this.houseId = houseId;
    }

    public Log() {
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

	@Override
	public String toString() {
		return "Log [id=" + id + ", userId=" + userId + ", houseId=" + houseId + "]";
	}
    
}