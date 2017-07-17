package com.shabab.housing_mob.model;


import java.util.Date;

/**
 * Created by kp6 on 10/8/2016.
 */


public class User {

    private long id;

    private String name;


    private int imageCounter;


    private String city;

    private String phone;
    private Date    registerationDate;



    private String profileImageAddress;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageCounter() {
        return imageCounter;
    }

    public void setImageCounter(int imageCounter) {
        this.imageCounter = imageCounter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterationDate() {
        return registerationDate;
    }

    public void setRegisterationDate(Date registerationDate) {
        this.registerationDate = registerationDate;
    }

    public String getProfileImageAddress() {
        return profileImageAddress;
    }

    public void setProfileImageAddress(String profileImageAddress) {
        this.profileImageAddress = profileImageAddress;
    }
}
