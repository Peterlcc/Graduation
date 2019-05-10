package com.peter.bean;

public class Recommand {
    private Integer id;

    private Integer userId;

    private Integer houseId;

    private Double score;
    
    private House house;

    public Recommand(Integer id, Integer userId, Integer houseId, Double score) {
        this.id = id;
        this.userId = userId;
        this.houseId = houseId;
        this.score = score;
    }

    public Recommand() {
        super();
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

	

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "Recommand [id=" + id + ", userId=" + userId + ", houseId=" + houseId + ", score=" + score + "]";
	}
    
}