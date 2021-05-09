package com.dark_tech.pandemian.pojo;

public class Location {

    private String id;
    private String nickName;
    private String about;
    private String type;
    private LatLng location;

    public Location() {
    }

    public Location(String id, String nickName, String about, String type, LatLng location) {
        this.id = id;
        this.nickName = nickName;
        this.about = about;
        this.type = type;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
