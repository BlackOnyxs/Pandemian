package com.dark_tech.pandemian.hospital;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dark_tech.pandemian.HospitalSingleton;
import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.adapters.HospitalAdapter;
import com.dark_tech.pandemian.adapters.HospitalClickLister;
import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HospitalFragment extends Fragment implements HospitalClickLister {
    private RecyclerView rvHospitals;
    private HospitalAdapter hospitalAdapter;
    private DBConnection dbConnection;
    private Connection connection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        rvHospitals = view.findViewById(R.id.rvHospitals);
        hospitalAdapter = new HospitalAdapter(new ArrayList<Location>(), this, getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

        rvHospitals.setLayoutManager(manager);
        rvHospitals.setAdapter(hospitalAdapter);

        try {
            if ( dbConnection == null ){
                dbConnection = new DBConnection();
                connection = dbConnection.connectionClass();
            }
            if ( connection!= null ){
                String query = "SELECT about FROM Location";
                Statement sts = connection.createStatement();
                ResultSet rs = sts.executeQuery(query);
                Log.i("DB", rs.toString());
                while (rs.next()){
                    Log.i("DB", "");
                }
            }
        }catch (Exception e){
            Log.e("DB", e.getMessage());
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onClick(Location location) {
        HospitalSingleton singleton = HospitalSingleton.getInstance();
        singleton.setLocation(location);
        MapsFragment fragment = new MapsFragment();
        loadFragment( fragment );
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