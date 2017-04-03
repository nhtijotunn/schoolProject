package com.example.mapwithmarker;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;



/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements
        OnMapReadyCallback {

    private GoogleMap mMap;

    private final LatLng nhti = new LatLng(43.223881, -71.531651);
    private Marker mSweeney;
    private Marker mMcauliffe;
    private Marker mMacrury;
    private Marker mFarnum;
    private Marker mLibrary;
    private Marker mLittle;
    private Marker mGrappone;

    private Polygon pLibrary;
    private Polygon pGrappone;
    private Polygon pChildFamily;
    private Polygon pEastAnnex;
    private Polygon pLittle;
    private Polygon pFarnum;
    private Polygon pMacRury;
    private Polygon pMcAuliffe;
    private Polygon pSweeney;



    private static final String TAG = MapsMarkerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);




        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //assign value to mMap
        mMap = googleMap;

        // Customise the styling of the base map using a JSON object defined
        // in a string resource file. First create a MapStyleOptions object
        // from the JSON styles string, then pass this to the setMapStyle
        // method of the GoogleMap object.
        boolean success = mMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_retro)));

        if (!success) {
            Log.e(TAG, "Style parsing failed.");
        }
        //UI Settings
        uiSettings();
        //set up Map Markers
        setMarkers();
        // set up Polygons
        setPolygons();




        // OnClick Listener Testing
        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {

                    final Dialog mapDialogue = new Dialog(MapsMarkerActivity.this, android.R.style.Theme_Black_NoTitleBar);
                    mapDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                    mapDialogue.setContentView(R.layout.dialogue);
                    mapDialogue.setCancelable(true);
                    mapDialogue.show();
            }


        });



    }


    private void setPolygons(){

        pGrappone = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.222555, -71.532639), new LatLng(43.222516, -71.532923),
                        new LatLng(43.222868, -71.533009), new LatLng(43.222953, -71.533175),
                        new LatLng(43.223108, -71.533040), new LatLng(43.222956, -71.532738))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        //makes it clickable/invisible
        pGrappone.setClickable(true);
        pGrappone.setVisible (false);

        pLibrary = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224543, -71.530597), new LatLng(43.224599, -71.530254),
                        new LatLng(43.224476, -71.530212), new LatLng(43.224486, -71.530102),
                        new LatLng(43.224267, -71.530028), new LatLng(43.224100, -71.530167),
                        new LatLng(43.224147, -71.530261), new LatLng(43.223941, -71.530438),
                        new LatLng(43.224079, -71.530723), new LatLng(43.224355, -71.530525))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        pLibrary.setClickable(true);
        pLibrary.setVisible (false);

        pMcAuliffe = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224030, -71.532228), new LatLng(43.223965, -71.532829),
                        new LatLng(43.224307, -71.532901), new LatLng(43.224370, -71.532305))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        pLibrary.setClickable(true);
     /*   pLibrary.setVisible (false);*/

        pSweeney = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.224842, -71.531207), new LatLng(43.224533, -71.531121),
                        new LatLng(43.224438, -71.531685), new LatLng(43.224507, -71.531703),
                        new LatLng(43.224474, -71.531881), new LatLng(43.224808, -71.532010),
                        new LatLng(43.224834, -71.531861), new LatLng(43.224738, -71.531827))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        pLibrary.setClickable(true);
        pLibrary.setVisible (false);

    }

    private void setMarkers() {

        LatLng little = new LatLng(43.222906, -71.531441);
        LatLng grappone = new LatLng(43.222816, -71.532857);
        LatLng mcauliffe = new LatLng(43.224111, -71.532598);
        LatLng library = new LatLng(43.224308, -71.530318);
        LatLng sweeney = new LatLng(43.224638, -71.531041);

        //filling the markers
        mLittle = mMap.addMarker(new MarkerOptions().position(little)
                .title("Little"));
        mGrappone = mMap.addMarker(new MarkerOptions().position(grappone)
                .title("Grappone Hall").snippet("blahblahbalah"));
        mMcauliffe = mMap.addMarker(new MarkerOptions().position(mcauliffe)
                .title("McAuliffe"));
        mLibrary = mMap.addMarker(new MarkerOptions().position(library)
                .title("Library"));
        mSweeney = mMap.addMarker(new MarkerOptions().position(sweeney)
                .title("Sweeney"));

    }

    private void uiSettings(){
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
