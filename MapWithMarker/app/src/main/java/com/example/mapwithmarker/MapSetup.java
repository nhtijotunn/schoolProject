package com.example.mapwithmarker;
import android.graphics.Color;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.example.mapwithmarker.MapsMarkerActivity;

/**
 * Created by Johnny on 4/7/2017.
 */

public class MapSetup {

    public static void setPolygons(GoogleMap mMap) {

        // id = pg0
        MapsMarkerActivity.pGrappone = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.222555, -71.532639), new LatLng(43.222516, -71.532923),
                        new LatLng(43.222868, -71.533009), new LatLng(43.222953, -71.533175),
                        new LatLng(43.223108, -71.533040), new LatLng(43.222956, -71.532738))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        //makes it clickable
        MapsMarkerActivity.pGrappone.setClickable(true);

        MapsMarkerActivity.pLibrary = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224543, -71.530597), new LatLng(43.224599, -71.530254),
                        new LatLng(43.224476, -71.530212), new LatLng(43.224486, -71.530102),
                        new LatLng(43.224267, -71.530028), new LatLng(43.224100, -71.530167),
                        new LatLng(43.224147, -71.530261), new LatLng(43.223941, -71.530438),
                        new LatLng(43.224079, -71.530723), new LatLng(43.224355, -71.530525))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pLibrary.setClickable(true);

        MapsMarkerActivity.pFarnum = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.223291, -71.531067), new LatLng(43.223217, -71.531521),
                        new LatLng(43.223555, -71.531623), new LatLng(43.223594, -71.531403),
                        new LatLng(43.223393, -71.531341), new LatLng(43.223430, -71.531116))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pFarnum.setClickable(true);

        MapsMarkerActivity.pMcAuliffe = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224030, -71.532228), new LatLng(43.223965, -71.532829),
                        new LatLng(43.224307, -71.532901), new LatLng(43.224370, -71.532305))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pMcAuliffe.setClickable(true);

        MapsMarkerActivity.pSweeney = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224842, -71.531207), new LatLng(43.224533, -71.531121),
                        new LatLng(43.224438, -71.531685), new LatLng(43.224507, -71.531703),
                        new LatLng(43.224474, -71.531881), new LatLng(43.224808, -71.532010),
                        new LatLng(43.224834, -71.531861), new LatLng(43.224738, -71.531827))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pSweeney.setClickable(true);

        MapsMarkerActivity.pLittle = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.222871, -71.532212), new LatLng(43.223053, -71.531180),
                        new LatLng(43.222578, -71.530919), new LatLng(43.222472, -71.531367))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pLittle.setClickable(true);

        MapsMarkerActivity.pMacRury = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.223246, -71.531780), new LatLng(43.223137, -71.532446),
                        new LatLng(43.223627, -71.532601), new LatLng(43.223793, -71.531866))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pMacRury.setClickable(true);

        invisiblePolygons();

    }

    public static void invisiblePolygons(){

        MapsMarkerActivity.pMacRury.setVisible(false);
        MapsMarkerActivity.pLittle.setVisible(false);
        MapsMarkerActivity.pSweeney.setVisible(false);
        MapsMarkerActivity.pFarnum.setVisible(false);
        MapsMarkerActivity.pMcAuliffe.setVisible(false);
        MapsMarkerActivity.pGrappone.setVisible(false);
        MapsMarkerActivity.pLibrary.setVisible(false);

    }

    public static void setMarkers(GoogleMap mMap) {

        LatLng little = new LatLng(43.222906, -71.531441);
        LatLng grappone = new LatLng(43.222816, -71.532857);
        LatLng mcauliffe = new LatLng(43.224111, -71.532598);
        LatLng library = new LatLng(43.224308, -71.530318);
        LatLng sweeney = new LatLng(43.224551, -71.531524);
        LatLng mcrury = new LatLng(43.223426, -71.532185);
        LatLng farnum = new LatLng(43.223340, -71.531418);

        //filling the markers
        MapsMarkerActivity.mLittle = mMap.addMarker(new MarkerOptions().position(little)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Little Hall")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity.mGrappone = mMap.addMarker(new MarkerOptions().position(grappone)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Grappone Hall")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity.mMcauliffe = mMap.addMarker(new MarkerOptions().position(mcauliffe)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("McAuliffe")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity.mLibrary = mMap.addMarker(new MarkerOptions().position(library)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Library")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity.mSweeney = mMap.addMarker(new MarkerOptions().position(sweeney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Sweeney Hall")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity. mMacrury = mMap.addMarker(new MarkerOptions().position(mcrury)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("MacRury Hall")
                .snippet("Classrooms\n" +
                        "Auditorium\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));
        MapsMarkerActivity.mFarnum = mMap.addMarker(new MarkerOptions().position(farnum)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Farnum Hall")
                .snippet("Classrooms\n" +
                        "Farnum Info\n" +
                        "Student Study Area\n" +
                        "Computer Lab\n" +
                        "Nursing Education Center"));

    }

    public static void uiSettings(GoogleMap mMap, LatLng nhti){
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setCompassEnabled(false);
        uiSettings.setMapToolbarEnabled(false);

        // Zoom settings
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nhti));
        mMap.setMinZoomPreference(17);

        LatLngBounds campus = new LatLngBounds(
                new LatLng(43.221527, -71.533355), new LatLng(43.227141, -71.527139));
        // Constrain the camera target to the NHTI bounds.
        mMap.setLatLngBoundsForCameraTarget(campus);
    }



}
