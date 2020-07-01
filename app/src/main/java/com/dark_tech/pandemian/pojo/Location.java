package com.dark_tech.pandemian.pojo;

public class Location {

    private String id;
    private String name;
    private String description;
    private String type;
    private LatLng location;

    public Location() {
    }

    public Location(String id, String name, String description, String type, LatLng location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
