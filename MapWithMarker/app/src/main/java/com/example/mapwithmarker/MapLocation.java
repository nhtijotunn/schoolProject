package com.example.mapwithmarker;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

class MapLocation{ //This is a class that exists just to store data.
    public GoogleMap mMap; // The map/camera that this location belongs to
    public String[] locNames; //multiple names here as a failsafe for misspellings
    public LatLng latLng; // Where the location is actually... located
    //public LatLngBounds camBounds;

    public MapLocation(GoogleMap mbmap, String[] names, LatLng coordinates){
        mMap = mbmap;
        locNames = names;
        latLng= coordinates;
    }
}