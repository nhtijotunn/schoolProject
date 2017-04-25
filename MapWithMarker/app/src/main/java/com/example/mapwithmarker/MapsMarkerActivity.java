package com.example.mapwithmarker;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

            //setting the photo from MapSetup
            ((ImageView) view.findViewById(R.id.badge)).setImageResource(MapSetup.setPhoto(marker));

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
        }// render
    }


    ///////////////////////////////////////////////////////////////////////


    private GoogleMap mMap;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private EditText searchbar;
    private MapLocation[] locations;

    public final LatLng nhti = new LatLng(43.223881, -71.531651);


    public static Marker mSweeney, mMcauliffe, mMacrury, mFarnum, mLibrary, mLittle, mGrappone, mStrout, mSouth,
    mNorth, mPolice, mSafety, mStudentCenter, mTechnology, mChild, mEast;

    public static Polygon pLibrary, pGrappone, pPolice, pNorth, pSouth, pStrout, pLittle, pFarnum, pMacRury,
                          pMcauliffe, pSweeney, pStudentCenter, pTechnology, pSafety, pChild;

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

        ///////////////////////SEARCH BAR////////////////////////

        searchbar = (EditText)findViewById(R.id.editText);
        setLocations();
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


               if(searchLocation(searchbar.getText().toString(), locations)){
                   //Toast.makeText(MapsMarkerActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
                   mDrawerLayout.closeDrawers();
                   InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                   in.hideSoftInputFromWindow(searchbar.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
        ////////////////////////////////////////////////////////

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
                    case R.id.nav_grappone:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mGrappone.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mGrappone.showInfoWindow();
                        break;
                    case R.id.nav_farnum:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mFarnum.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mFarnum.showInfoWindow();
                        break;
                    case R.id.nav_safety:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mSafety.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mSafety.showInfoWindow();
                        break;
                    case R.id.nav_south:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mSouth.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mSouth.showInfoWindow();
                        break;
                    case R.id.nav_north:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mNorth.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mNorth.showInfoWindow();
                        break;
                    case R.id.nav_strout:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mStrout.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mStrout.showInfoWindow();
                        break;
                    case R.id.nav_technology:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mTechnology.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mTechnology.showInfoWindow();
                        break;
                    case R.id.nav_police:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mPolice.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mPolice.showInfoWindow();
                        break;
                    case R.id.nav_mcaliffe:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mMcauliffe.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mMcauliffe.showInfoWindow();
                        break;
                    case R.id.nav_child:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(mChild.getPosition()).zoom(17f).bearing(0).tilt(0).build()));
                        MapsMarkerActivity.mChild.showInfoWindow();
                        break;
                    default:
                        mDrawerLayout.closeDrawers();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                                .target(nhti).zoom(17f).bearing(0).tilt(0).build()));
                        break;

                }//end of switch statement
                return true;
            }
        });
    }

    public boolean searchLocation(String query, MapLocation[] locations){
        for (int i = 0; i < locations.length; i++){ //For each location that exists
            for (int o = 0; o < locations[i].locNames.length; o++){ //For each name of each location
                if (locations[i].locNames[o].equals(query)){ //If that name is equivilant to what was searched...
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                            .target(locations[i].latLng).zoom(18f).bearing(0).tilt(0).build()));
                    //locations[i].mMap.easeCamera(CameraUpdateFactory.newLatLngBounds(locations[i].camBounds, 50), 1000);
                    //This slides the camera from it's current position to the coordinates of the location
                    return true; //The location was found
                }
            }
        }
        return false; //The location was not found in the above loop
    }

    public void setLocations(){

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

        locations = new MapLocation[15];

        locations[0] = (new MapLocation(
                mMap,
                new String[]{"sweeney", "sweeney hall", "sweeny", "sweeny hall", "Sweeney", "Sweeney Hall", "sweenie", "hell"},
                sweeney
        ));
        locations[1] = (new MapLocation(
                mMap,
                new String[]{"grappone", "grapponey", "grappone hall", "Grappone", "Grappone Hall"},
                grappone
        ));
        locations[2] = (new MapLocation(
                mMap,
                new String[]{"little", "little hall", "littel", "Little", "Little Hall"},
                little
        ));
        locations[3] = (new MapLocation(
                mMap,
                new String[]{"farnum", "Farnum", "farnum hall", "farnumhall", "Farnum Hall"},
                farnum
        ));
        locations[4] = (new MapLocation(
                mMap,
                new String[]{"studentcenter", "student center", "Student center","Student Center", "Studentcenter", "lobby" },
                studentCenterLocation
        ));
        locations[5] = (new MapLocation(
                mMap,
                new String[]{"library", "Library", "bookstore", "books"},
                library
        ));
        locations[6] = (new MapLocation(
                mMap,
                new String[]{"macrury", "MacRury", "Macrury", "mcrury", "Mcrury", "macrury hall"},
                mcrury
        ));
        locations[7] = (new MapLocation(
                mMap,
                new String[]{"mcauliffe", "planetarium", "space center", "Mcaullife"},
                mcauliffe
        ));
        locations[8] = (new MapLocation(
                mMap,
                new String[]{"strout","Strout", "strout hall", "Strout Hall"},
                stroutLocation
        ));
        locations[9] = (new MapLocation(
                mMap,
                new String[]{"north", "North", "north hall", "North Hall"},
                northLocation
        ));

        locations[10] = (new MapLocation(
                mMap,
                new String[]{"south", "South", "south hall", "South Hall"},
                southLocation
        ));
        locations[11] = (new MapLocation(
                mMap,
                new String[]{"police", "Police", "police academy"},
                policeLocation
        ));
        locations[12] = (new MapLocation(
                mMap,
                new String[]{"campus safety", "campus safe", "safety", "Safety", "Campus safety", "Campus Safety"},
                safetyLocation
        ));
        locations[13] = (new MapLocation(//child
                mMap,
                new String[]{"child", "Child"},
                new LatLng(43.222839, -71.530370)
        ));
        locations[14] = (new MapLocation(//tech
                mMap,
                new String[]{"technology services", "ctc", "college system office", "system", "technology"},
                new LatLng(43.223524, -71.530904)
        ));

    }

}
