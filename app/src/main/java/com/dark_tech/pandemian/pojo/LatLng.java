/*
 * *
 *  * Created by Robin Ávila (BlackOnyxs) on 04/09/20 02:57 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 04/09/20 02:57 PM
 *
 */

package com.dark_tech.pandemian.pojo;

public class LatLng {
    private double lat;
    private double lng;

    public LatLng() {
    }

    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
