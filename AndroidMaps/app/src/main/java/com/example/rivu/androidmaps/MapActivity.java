package com.example.rivu.androidmaps;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends
        Activity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(googleServicesAvailable()){
            Toast.makeText(this , "Success",Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_map);
            initMap();
        }
    }
    // initialize the map
    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

    }
    // checking whether google services are available or not
    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int check = api.isGooglePlayServicesAvailable(this);
        if(check == ConnectionResult.SUCCESS){
            return true;
        }
        else
        if(api.isUserResolvableError(check)){
            Dialog dialog  = api.getErrorDialog(this,check,0);
            dialog.show();
        }
        else{
            Toast.makeText(this,"Cannot Connect to GOOGLE PLAY SERVICES",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    // getting the mapview
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        Intent intent = getIntent();
        if(null != intent){
            Double lat = getIntent().getExtras().getDouble("Lat");
            Double lng  = getIntent().getExtras().getDouble("Long");
            goToLocation(lat,lng,17);

            setMarker(lat, lng);

        }

    }
        // setting the place where you are
    private void setMarker(Double lat, Double lng) {
        MarkerOptions markerOptions = new MarkerOptions().title("Me").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).snippet("Hi There").position(new LatLng(lat,lng) );
        mGoogleMap.addMarker(markerOptions);
    }
    // going to that particular location
    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }
}
