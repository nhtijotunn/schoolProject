package com.example.mapwithmarker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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



/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements
        OnMapReadyCallback {


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


        // Customise the styling of the base map using a JSON object defined
        // in a string resource file. First create a MapStyleOptions object
        // from the JSON styles string, then pass this to the setMapStyle
        // method of the GoogleMap object.
        boolean success = googleMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_retro)));

        if (!success) {
            Log.e(TAG, "Style parsing failed.");
        }

        //UI Settings
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(false);
        uiSettings.setMapToolbarEnabled(false);


        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng nhti = new LatLng(43.223881, -71.531651);
        LatLng little = new LatLng(43.222906, -71.531441);
        LatLng grappone = new LatLng(43.222816, -71.532857);
        LatLng mcauliffe = new LatLng(43.224111, -71.532598);
        LatLng library = new LatLng(43.224308, -71.530318);
        LatLng sweeney = new LatLng(43.224638, -71.531041);


        //creating markers
        googleMap.addMarker(new MarkerOptions().position(little)
                .title("???"));
        Marker mGrappone = googleMap.addMarker(new MarkerOptions().position(grappone)
                .title("Grappone Hall").snippet("blahblahbalah"));
        Marker mMcauliffe = googleMap.addMarker(new MarkerOptions().position(mcauliffe)
                .title("Mcauliffe"));
        Marker mLibrary = googleMap.addMarker(new MarkerOptions().position(library)
                .title("Library"));
        Marker mSweeney = googleMap.addMarker(new MarkerOptions().position(sweeney)
                .title("Sweeney"));

        // Zoom settings
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(nhti));
        googleMap.setMinZoomPreference(17);

        // Create a LatLngBounds that includes the campus.
        LatLngBounds campus = new LatLngBounds(
                new LatLng(43.221527, -71.533355), new LatLng(43.227141, -71.527139));
        // Constrain the camera target to the NHTI bounds.
        googleMap.setLatLngBoundsForCameraTarget(campus);

    }



}
