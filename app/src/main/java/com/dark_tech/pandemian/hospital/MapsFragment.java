package com.dark_tech.pandemian.hospital;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dark_tech.pandemian.HospitalSingleton;
import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.pojo.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

   private GoogleMap gMap;
    private HospitalSingleton singleton;
    private Location hospital;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhone);
        ImageView ivHospital = view.findViewById(R.id.ivHospital);

        singleton = HospitalSingleton.getInstance();
        if (singleton.getLocation() != null){
            hospital = singleton.getLocation();
            tvName.setText(hospital.getNickName());
            tvPhone.setText(getContext().getString(R.string.hospital_phone, hospital.getPhone()));
            ivHospital.setImageDrawable(hospital.getRef());
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapView mMapView = view.findViewById(R.id.map_fragment);

        if ( mMapView != null ){
            mMapView.onCreate(null);
            mMapView.onResume();
        }
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        if (hospital != null){
            LatLng hospitalLocation = new LatLng(hospital.getLocation().getLat(), hospital.getLocation().getLng());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(hospitalLocation);
            markerOptions.title(hospital.getNickName());
            googleMap.addMarker(markerOptions);
            CameraPosition position = CameraPosition.fromLatLngZoom(hospitalLocation, 15);
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));

        }
    }
}