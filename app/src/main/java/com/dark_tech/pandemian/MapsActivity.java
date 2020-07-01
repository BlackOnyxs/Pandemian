package com.dark_tech.pandemian;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.dark_tech.pandemian.pojo.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HospitalSingleton singleton;
    private Location hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        singleton = HospitalSingleton.getInstance();
        if (singleton.getLocation() != null){
            hospital = singleton.getLocation();
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (hospital != null){
            LatLng hospitalLocation = new LatLng(hospital.getLocation().getLat(), hospital.getLocation().getLng());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(hospitalLocation);
            googleMap.addMarker(markerOptions);
            CameraPosition position = CameraPosition.fromLatLngZoom(hospitalLocation, 15);
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));

        }
    }
}
