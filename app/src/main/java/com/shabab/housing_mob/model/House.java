package com.shabab.housing_mob.model;


import java.io.Serializable;
import java.util.Date;



public class House implements Serializable {


    private long houseId;


    private long userId;


    private String city;


    private int homeAge;


    private double lat;


    private double lon;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    private int room;




    private int area;


    private long price;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    private Date createDate;


    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    public int getHomeAge() {
        return homeAge;
    }

    public void setHomeAge(int homeAge) {
        this.homeAge = homeAge;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
