package com.example.mapwithmarker;
import android.graphics.Color;
import android.os.Build;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.example.mapwithmarker.MapsMarkerActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Johnny on 4/7/2017.
 */

public class MapSetup {

    public static void setPolygons(GoogleMap mMap) {

        // id = pg0  ONLY ADD NEW POLYGONS FROM THE BOTTOM
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

        MapsMarkerActivity.pStudentCenter = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.225084, -71.530815), new LatLng(43.224864, -71.530334),
                        new LatLng(43.224546, -71.530668), new LatLng(43.224446, -71.530830),
                        new LatLng(43.224432, -71.530909), new LatLng(43.224457, -71.531008),
                        new LatLng(43.224532, -71.531113), new LatLng(43.224769, -71.531169),
                        new LatLng(43.224788, -71.531070))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pStudentCenter.setClickable(true);

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
        MapsMarkerActivity.pStudentCenter.setVisible(false);

    }

    public static void setMarkers(GoogleMap mMap) {

        LatLng little = new LatLng(43.222906, -71.531441);
        LatLng grappone = new LatLng(43.222816, -71.532857);
        LatLng mcauliffe = new LatLng(43.224111, -71.532598);
        LatLng library = new LatLng(43.224308, -71.530318);
        LatLng sweeney = new LatLng(43.224551, -71.531524);
        LatLng mcrury = new LatLng(43.223426, -71.532185);
        LatLng farnum = new LatLng(43.223340, -71.531418);
        LatLng stroutLocation = new LatLng(43.221474, -71.532201);
        LatLng southLocation = new LatLng(43.220771, -71.532666);
        LatLng northLocation = new LatLng(43.226108, -71.530679);
        LatLng policeLocation = new LatLng(43.225695, -71.532453);
        LatLng safetyLocation = new LatLng(43.224294, -71.534146);
        LatLng studentCenterLocation = new LatLng(43.224643, -71.530896);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
                //filling the markers
        MapsMarkerActivity.mLittle = mMap.addMarker(new MarkerOptions().position(little)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_little))
                .anchor(0.5f, 0.5f)
                .title("Little Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hLittle)+
                        "\nLittle's Content\n" +
                        "Content\n"));
        MapsMarkerActivity.mGrappone = mMap.addMarker(new MarkerOptions().position(grappone)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Grappone Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hGrappone)+
                        "\nGrappone's Content\n" +
                        "Content\n"));
        MapsMarkerActivity.mMcauliffe = mMap.addMarker(new MarkerOptions().position(mcauliffe)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("McAuliffe-Shepard Discovery Center\n")
                .snippet(dotwBuilder(day, BuildingHours.hMcAuliffe)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mLibrary = mMap.addMarker(new MarkerOptions().position(library)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_library))
                .anchor(0.5f, 0.5f)
                .title("Library")
                .snippet(dotwBuilder(day, BuildingHours.hLibrary)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mSweeney = mMap.addMarker(new MarkerOptions().position(sweeney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_sweeney))
                .anchor(0.5f, 0.5f)
                .title("Sweeney Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hStudentCenter)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity. mMacrury = mMap.addMarker(new MarkerOptions().position(mcrury)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_macrury))
                .anchor(0.5f, 0.5f)
                .title("MacRury Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hMacRury)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mFarnum = mMap.addMarker(new MarkerOptions().position(farnum)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_farnum))
                .anchor(0.5f, 0.5f)
                .title("Farnum Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hFarnum)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mStrout = mMap.addMarker(new MarkerOptions().position(stroutLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Strout Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mSouth = mMap.addMarker(new MarkerOptions().position(southLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("South Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mNorth = mMap.addMarker(new MarkerOptions().position(northLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("North Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mStudentCenter = mMap.addMarker(new MarkerOptions().position(studentCenterLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Student Center\n")
                .snippet(dotwBuilder(day, BuildingHours.hStudentCenter)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mTechnology = mMap.addMarker(new MarkerOptions().position(new LatLng(43.223524, -71.530904))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker))
                .anchor(0.5f, 0.5f)
                .title("Community College System Office\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));

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

    public static String dotwBuilder(int day,String[] building){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek + ": " + building[day-1];
    }




}
