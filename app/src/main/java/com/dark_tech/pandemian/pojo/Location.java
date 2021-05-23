package com.dark_tech.pandemian.pojo;

import android.graphics.drawable.Drawable;

public class Location {

    private String id;
    private String nickName;
    private String phone;
    private LatLng location;
    private Drawable ref;

    public Location() {
    }

    public Location(String id, String nickName, String phone, LatLng location) {
        this.id = id;
        this.nickName = nickName;
        this.phone = phone;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public Drawable getRef() {
        return ref;
    }

    public void setRef(Drawable ref) {
        this.ref = ref;
    }
}
