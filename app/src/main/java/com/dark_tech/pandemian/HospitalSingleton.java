package com.dark_tech.pandemian;

import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.pojo.Report;

public class HospitalSingleton {

    private static final HospitalSingleton instance = new HospitalSingleton();

    private Location location;

    public static HospitalSingleton getInstance(){
        return instance;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
