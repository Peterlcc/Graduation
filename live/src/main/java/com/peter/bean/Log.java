package com.peter.bean;

public class Log {
    private Integer id;

    private Integer userId;

    private Integer houseId;

    public Log(Integer id, Integer userId, Integer houseId) {
        this.id = id;
        this.userId = userId;
        this.houseId = houseId;
    }

    public Log() {
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
}