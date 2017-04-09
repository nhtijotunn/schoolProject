package com.example.mapwithmarker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;


public class PolygonListener {

    public static void setListener(final GoogleMap mMap){

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                //converts polygon id into an int, id's assigned by order of polygon assignment ex: pg0
                int testing = Integer.parseInt(polygon.getId().substring(2));
                switch(testing){
                    case 0: // Grappone
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mGrappone.getPosition()));
                        MapsMarkerActivity.mGrappone.showInfoWindow();
                        break;
                    case 1:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mLibrary.getPosition()));
                        MapsMarkerActivity.mLibrary.showInfoWindow();
                        break;
                    case 2:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mFarnum.getPosition()));
                        MapsMarkerActivity.mFarnum.showInfoWindow();
                        break;
                    case 3:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mMcauliffe.getPosition()));
                        MapsMarkerActivity.mMcauliffe.showInfoWindow();
                        break;
                    case 4:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mSweeney.getPosition()));
                        MapsMarkerActivity.mSweeney.showInfoWindow();
                        break;
                    case 5:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mLittle.getPosition()));
                        MapsMarkerActivity.mLittle.showInfoWindow();
                        break;
                    case 6:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mMacrury.getPosition()));
                        MapsMarkerActivity.mMacrury.showInfoWindow();
                        break;
                }//end of switch statement
            }
        });

    }
}
