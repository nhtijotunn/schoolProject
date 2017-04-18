package com.example.mapwithmarker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;


/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements
        OnMapReadyCallback {

    /////////////////CUSTOM INFO WINDOW////////////////////////////////

    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mWindow;

        private final View mContents;

        CustomInfoWindowAdapter() {
            mWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);
            mContents = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            render(marker, mWindow);
            return mWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
//            render(marker, mContents);
//            return mContents;
        }

        private void render(Marker marker, View view) {

            int badge;

            if (marker.equals(mStudentCenter)) {
                badge = R.drawable.student_center_photo;
            } else if (marker.equals(mFarnum)) {
                badge = R.drawable.farnum_photo;
            } else if (marker.equals(mSweeney)) {
                badge = R.drawable.sweeney_photo;
            } else if (marker.equals(mGrappone)) {
                badge = R.drawable.grappone_photo;
            } else if (marker.equals(mLittle)) {
                badge = R.drawable.little_photo;
            } else {
            // Passing 0 to setImageResource will clear the image view.
            badge = 0;
            }
            ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(Color.WHITE), 0, titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String snippet = marker.getSnippet();
            TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
            if (snippet != null && snippet.length() > 12) {
                SpannableString snippetText = new SpannableString(snippet);
                snippetText.setSpan(new ForegroundColorSpan(Color.WHITE), 0, snippet.length(), 0);
                snippetUi.setText(snippetText);
            } else {
                snippetUi.setText("");
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////


    private GoogleMap mMap;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    private final LatLng nhti = new LatLng(43.223881, -71.531651);

    public static Marker mSweeney, mMcauliffe, mMacrury, mFarnum, mLibrary, mLittle, mGrappone, mStrout, mSouth,
    mNorth, mPolice, mSafetey, mStudentCenter, mTechnology, mChild, mEast;

    public static Polygon pLibrary, pGrappone, pPolice, pNorth, pSouth, pStrout, pLittle, pFarnum, pMacRury,
                          pMcAuliffe, pSweeney, pStudentCenter, pTechnology, pSafety, pChild, pEast;

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

        //////////////////NAVIGATION DRAWER////////////////////

        ImageButton burger = (ImageButton)findViewById(R.id.burger);
        mNavigationView = (NavigationView)findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView.setItemIconTintList(null);
        setNavListener();
        //set Burger
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(mNavigationView);
            }
        });
        //////////////////////////////////////////////////////

    }//onCreate

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
        MapSetup.uiSettings(mMap, nhti);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
        //set up Map Markers
        MapSetup.setMarkers(mMap);
        // set up Polygons
        MapSetup.setPolygons(mMap);
        // OnClick Listener Testing
        PolygonListener.setListener(mMap);
    }

    public void setNavListener(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Toast.makeText(MapsMarkerActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
                switch (menuItem.getItemId()) {
                    case R.id.nav_sweeney:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                            .target(mSweeney.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mSweeney.showInfoWindow();
                        break;
                    case R.id.nav_student_center:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mStudentCenter.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mStudentCenter.showInfoWindow();
                        break;
                    case R.id.nav_library:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mLibrary.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mLibrary.showInfoWindow();
                        break;
                    case R.id.nav_little:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mLittle.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mLittle.showInfoWindow();
                        break;
                    case R.id.nav_macrury:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mMacrury.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mMacrury.showInfoWindow();
                        break;
                    default:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mGrappone.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mGrappone.showInfoWindow();
                        break;

                }//end of switch statement
                return true;
            }
        });


    }




}
