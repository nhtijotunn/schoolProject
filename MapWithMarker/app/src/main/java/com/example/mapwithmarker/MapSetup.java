package com.example.mapwithmarker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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

        MapsMarkerActivity.pMcauliffe = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224030, -71.532228), new LatLng(43.223965, -71.532829),
                        new LatLng(43.224307, -71.532901), new LatLng(43.224370, -71.532305))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pMcauliffe.setClickable(true);

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
                .add(new LatLng(43.225084, -71.530816), new LatLng(43.224861, -71.530335),
                        new LatLng(43.224545, -71.530666), new LatLng(43.224450, -71.530829),
                        new LatLng(43.224433, -71.530915), new LatLng(43.224466, -71.531017),
                        new LatLng(43.224536, -71.531116), new LatLng(43.224773, -71.531173),
                        new LatLng(43.224787, -71.531071))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pStudentCenter.setClickable(true);

        MapsMarkerActivity.pTechnology = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.223727, -71.530832), new LatLng(43.223362, -71.530725),
                        new LatLng(43.223326, -71.530943), new LatLng(43.223693, -71.531049))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pTechnology.setClickable(true);

          MapsMarkerActivity.pSafety = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224366, -71.534039), new LatLng(43.224283, -71.533990),
                        new LatLng(43.224227, -71.534166), new LatLng(43.224311, -71.534214))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pSafety.setClickable(true);

        MapsMarkerActivity.pPolice = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.225963, -71.531917), new LatLng(43.225893, -71.531937),
                        new LatLng(43.225846, -71.531649), new LatLng(43.225579, -71.531728),
                        new LatLng(43.225651, -71.532184), new LatLng(43.225576, -71.532206),
                        new LatLng(43.225680, -71.532851), new LatLng(43.225722, -71.532838),
                        new LatLng(43.225790, -71.533263), new LatLng(43.225709, -71.533288),
                        new LatLng(43.225811, -71.533918), new LatLng(43.226083, -71.533835),
                        new LatLng(43.225981, -71.533205), new LatLng(43.225887, -71.533234),
                        new LatLng(43.225788, -71.532603), new LatLng(43.225852, -71.532584),
                        new LatLng(43.225795, -71.532229), new LatLng(43.226004, -71.532166))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pPolice.setClickable(true);

        MapsMarkerActivity.pNorth = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.226489, -71.530997), new LatLng(43.226202, -71.530744),
                        new LatLng(43.226527, -71.530050), new LatLng(43.226414, -71.529948),
                        new LatLng(43.226117, -71.530585), new LatLng(43.226081, -71.530553),
                        new LatLng(43.225763, -71.531232), new LatLng(43.225872, -71.531328),
                        new LatLng(43.226097, -71.530847), new LatLng(43.226424, -71.531136))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pNorth.setClickable(true);

        MapsMarkerActivity.pSouth = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.221036, -71.532545), new LatLng(43.220497, -71.532548),
                        new LatLng(43.220498, -71.532712), new LatLng(43.221037, -71.532705))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pSouth.setClickable(true);

        MapsMarkerActivity.pStrout = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.221679, -71.531960), new LatLng(43.221593, -71.531852),
                        new LatLng(43.221262, -71.532346), new LatLng(43.221349, -71.532458))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pStrout.setClickable(true);

        MapsMarkerActivity.pChild = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.222946, -71.530242), new LatLng(43.222793, -71.530202),
                        new LatLng(43.222782, -71.530275), new LatLng(43.222721, -71.530259),
                        new LatLng(43.222690, -71.530488), new LatLng(43.222904, -71.530541))
                .strokeColor(R.color.outline)
                .strokeWidth(1)
                .fillColor(R.color.fill));

        MapsMarkerActivity.pChild.setClickable(true);






        invisiblePolygons();

    }

    public static void invisiblePolygons(){

        MapsMarkerActivity.pMacRury.setVisible(false);
        MapsMarkerActivity.pLittle.setVisible(false);
        MapsMarkerActivity.pSweeney.setVisible(false);
        MapsMarkerActivity.pFarnum.setVisible(false);
        MapsMarkerActivity.pMcauliffe.setVisible(false);
        MapsMarkerActivity.pGrappone.setVisible(false);
        MapsMarkerActivity.pLibrary.setVisible(false);
        MapsMarkerActivity.pStudentCenter.setVisible(false);
        MapsMarkerActivity.pTechnology.setVisible(false);
        MapsMarkerActivity.pChild.setVisible(false);
        MapsMarkerActivity.pPolice.setVisible(false);
        MapsMarkerActivity.pSafety.setVisible(false);
        MapsMarkerActivity.pNorth.setVisible(false);
        MapsMarkerActivity.pSouth.setVisible(false);
        MapsMarkerActivity.pStrout.setVisible(false);
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
                        "\nFood Court\n"));
        MapsMarkerActivity.mGrappone = mMap.addMarker(new MarkerOptions().position(grappone)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_grappone))
                .anchor(0.5f, 0.5f)
                .title("Grappone Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.hGrappone)+
                        "\nComputer Lab\n"));
        MapsMarkerActivity.mMcauliffe = mMap.addMarker(new MarkerOptions().position(mcauliffe)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mcauliffe))
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
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_strout))
                .anchor(0.5f, 0.5f)
                .title("Strout Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mSouth = mMap.addMarker(new MarkerOptions().position(southLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_south))
                .anchor(0.5f, 0.5f)
                .title("South Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mNorth = mMap.addMarker(new MarkerOptions().position(northLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_north))
                .anchor(0.5f, 0.5f)
                .title("North Hall\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mStudentCenter = mMap.addMarker(new MarkerOptions().position(studentCenterLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_student))
                .anchor(0.5f, 0.5f)
                .title("Student Center\n")
                .snippet(dotwBuilder(day, BuildingHours.hStudentCenter)+
                        "\nContent\n" +
                        "Content\n"));
        MapsMarkerActivity.mTechnology = mMap.addMarker(new MarkerOptions().position(new LatLng(43.223524, -71.530904))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_ctc))
                .anchor(0.5f, 0.5f)
                .title("College System Office\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));

        MapsMarkerActivity.mPolice = mMap.addMarker(new MarkerOptions().position(policeLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_police))
                .anchor(0.5f, 0.5f)
                .title("Police Standards and Training\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));

        MapsMarkerActivity.mSafety = mMap.addMarker(new MarkerOptions().position(safetyLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_campussafety))
                .anchor(0.5f, 0.5f)
                .title("Campus Safety\n")
                .snippet(dotwBuilder(day, BuildingHours.template)+
                        "\nContent\n" +
                        "Content\n"));

        MapsMarkerActivity.mChild = mMap.addMarker(new MarkerOptions().position(new LatLng(43.222839, -71.530370))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_child))
                .anchor(0.5f, 0.5f)
                .title("Child & Family Development\n")
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
                new LatLng(43.220017, -71.534695), new LatLng(43.227141, -71.527139));
        // Constrain the camera target to the NHTI bounds.
        mMap.setLatLngBoundsForCameraTarget(campus);
    }

    public static String dotwBuilder(int day,String[] building){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek + ": " + building[day-1];
    }

    public static int setPhoto (Marker marker){
        int badge;

        if (marker.equals(MapsMarkerActivity.mStudentCenter)) {
            badge = R.drawable.student_center_photo;
        } else if (marker.equals(MapsMarkerActivity.mFarnum)) {
            badge = R.drawable.farnum_photo;
        } else if (marker.equals(MapsMarkerActivity.mSweeney)) {
            badge = R.drawable.sweeney_photo;
        } else if (marker.equals(MapsMarkerActivity.mGrappone)) {
            badge = R.drawable.grappone_photo;
        } else if (marker.equals(MapsMarkerActivity.mLittle)) {
            badge = R.drawable.little_photo;
        } else if (marker.equals(MapsMarkerActivity.mSouth)) {
            badge = R.drawable.south_photo;
        } else if (marker.equals(MapsMarkerActivity.mNorth)) {
            badge = R.drawable.north_photo;
        } else if (marker.equals(MapsMarkerActivity.mStrout)) {
            badge = R.drawable.strout_photo;
        } else if (marker.equals(MapsMarkerActivity.mMacrury)) {
            badge = R.drawable.macrury_photo;
        } else if (marker.equals(MapsMarkerActivity.mChild)) {
            badge = R.drawable.child_photo;
        } else if (marker.equals(MapsMarkerActivity.mTechnology)) {
            badge = R.drawable.ctc_photo;
        } else if (marker.equals(MapsMarkerActivity.mSafety)) {
            badge = R.drawable.safety_photo;
        } else if (marker.equals(MapsMarkerActivity.mLibrary)) {
            badge = R.drawable.library_photo;
        } else if (marker.equals(MapsMarkerActivity.mMcauliffe)) {
            badge = R.drawable.mcaullife_photo;
        } else {
            // Passing 0 to setImageResource will clear the image view.
            badge = 0;
        }
        return badge;
    }




}
