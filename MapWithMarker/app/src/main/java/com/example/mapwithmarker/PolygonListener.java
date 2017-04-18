package com.example.mapwithmarker;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

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
                    case 7:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mStudentCenter.getPosition()));
                        MapsMarkerActivity.mStudentCenter.showInfoWindow();
                        break;
                    case 8:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mTechnology.getPosition()));
                        MapsMarkerActivity.mTechnology.showInfoWindow();
                        break;
                    case 9:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mSafetey.getPosition()));
                        MapsMarkerActivity.mSafetey.showInfoWindow();
                        break;
                    case 10:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mPolice.getPosition()));
                        MapsMarkerActivity.mPolice.showInfoWindow();
                        break;
                    case 11:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mNorth.getPosition()));
                        MapsMarkerActivity.mNorth.showInfoWindow();
                        break;
                    case 12:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mSouth.getPosition()));
                        MapsMarkerActivity.mSouth.showInfoWindow();
                        break;
                    case 13:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mStrout.getPosition()));
                        MapsMarkerActivity.mStrout.showInfoWindow();
                        break;
                    case 14:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mChild.getPosition()));
                        MapsMarkerActivity.mChild.showInfoWindow();
                        break;
                    case 15:
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(MapsMarkerActivity.mEast.getPosition()));
                        MapsMarkerActivity.mEast.showInfoWindow();
                        break;


                }//end of switch statement
            }
        });

    }


}
