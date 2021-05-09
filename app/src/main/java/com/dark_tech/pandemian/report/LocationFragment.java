package com.dark_tech.pandemian.report;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;
import com.dark_tech.pandemian.pojo.LatLng;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.Objects;

public class LocationFragment extends Fragment {
    private static final int REQUEST_LOCATION_CODE = 500;
    private ProgressBar mProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location, container, false);
        mProgressBar = view.findViewById(R.id.progressBar);
        final Button btnLocation = view.findViewById(R.id.btnLocation);

        if ( checkLocationPermission() ){
            if ( checkLocation() ){
                getCurrentLocation();
                btnLocation.setEnabled( true );
            }
        }

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();
            }
        });
        return view;
    }

    private boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.text_location_permission)
                        .setMessage(R.string.message_location_permission)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) getContext(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        REQUEST_LOCATION_CODE);
                            }
                        })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION_CODE);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_CODE && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Toast.makeText(getContext(), R.string.permission_denied_message, Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void getCurrentLocation() {
        mProgressBar.setVisibility(View.VISIBLE);
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getActivity()))
                .requestLocationUpdates(locationRequest, new LocationCallback() {

                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getActivity()))
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            Toast.makeText(getContext(), R.string.location_success, Toast.LENGTH_SHORT)
                                    .show();
                            ReportSingleton reportSingleton = ReportSingleton.getInstance();
                            reportSingleton.getReport().setLocation(new LatLng(locationResult.getLocations().get(0).getLatitude(),
                                    locationResult.getLocations().get(0).getLongitude()));
                            HelpFragment fragment = new HelpFragment();
                            loadFragment( fragment );
                        } else {
                            Toast.makeText(getContext(), R.string.location_error_get, Toast.LENGTH_SHORT)
                                    .show();
                        }
                        mProgressBar.setVisibility(View.GONE);

                    }
                }, Looper.getMainLooper());
    }

    private boolean checkLocation() {
        if (!isLocationEnable())
            NotGPSignalAlert();
        return isLocationEnable();
    }

    private void NotGPSignalAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.address_location_service_title)
                .setMessage(R.string.address_location_service_message)
                .setPositiveButton(R.string.common_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                }).setNegativeButton(R.string.common_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), R.string.location_service_disable, Toast.LENGTH_SHORT)
                                .show();
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    private boolean isLocationEnable() {
        LocationManager locationManager = (LocationManager) Objects.requireNonNull(getContext())
                .getSystemService((getContext().LOCATION_SERVICE));
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void loadFragment(Fragment currentFragment) {
        if (currentFragment != null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}