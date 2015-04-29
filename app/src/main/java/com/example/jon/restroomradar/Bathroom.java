package com.example.jon.restroomradar;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Created by Jon on 4/28/2015.
 */
public class Bathroom {
    Marker marker;
    int id = 0;
    public Bathroom (Marker marker, int id){
        this.marker = marker;
        this.id = id;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public String getMarkerTitle() {
        return marker.getTitle();
    }

    public void setMarkerTitle(String title) {
        this.marker.setTitle(title);
    }

    public String getMarkerDescription() {
        return marker.getSnippet();
    }

    public void setMarkerDescription(String description) {
        this.marker.setSnippet(description);
    }

    public double getMarkerLatitude() {
        return marker.getPosition().latitude;
    }

    public void setMarkerLocation(LatLng position) {
        this.marker.setPosition(position);
    }

    public double getMarkerLongitude() {
        return marker.getPosition().longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
