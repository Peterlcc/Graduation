package com.peter.bean;

public class Img {
    private Integer id;

    private String url;

    private Integer houseId;

    public Img(Integer id, String url, Integer houseId) {
        this.id = id;
        this.url = url;
        this.houseId = houseId;
    }

    public Img() {
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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}