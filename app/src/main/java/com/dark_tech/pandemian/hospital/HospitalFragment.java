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
import com.dark_tech.pandemian.pojo.LatLng;
import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HospitalFragment extends Fragment implements HospitalClickLister {
    private RecyclerView rvHospitals;
    private HospitalAdapter hospitalAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        rvHospitals = view.findViewById(R.id.rvHospitals);
        hospitalAdapter = new HospitalAdapter(new ArrayList<Location>(), this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

        rvHospitals.setLayoutManager(manager);
        rvHospitals.setAdapter(hospitalAdapter);

        if ( loadHospitals() != null ){
            for (Location location:
                 loadHospitals()) {
                hospitalAdapter.add(location);
            }
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

    private ArrayList<Location> loadHospitals(){
        ArrayList<Location>locations = new ArrayList<>();
        Location chicho = new Location();
        chicho.setNickName("Hospital Luis Chicho Fabrega");
        chicho.setId("0");
        chicho.setPhone("958-2300");
        chicho.setLocation(new LatLng(8.077322, -80.935914));
        chicho.setRef(getContext().getDrawable(R.drawable.chicho));
        locations.add(chicho);

        Location nazareno = new Location();
        nazareno.setNickName("Hospital Jesus Nazareno");
        nazareno.setId("1");
        nazareno.setPhone("998-1581");
        nazareno.setLocation(new LatLng(8.077322, -80.935914));
        nazareno.setRef(getContext().getDrawable(R.drawable.nazareno));
        locations.add(nazareno);

        Location santiago = new Location();
        santiago.setNickName("Centro de Salud de Santiago");
        santiago.setId("2");
        santiago.setPhone("998-7113");
        santiago.setLocation(new LatLng(8.077322, -80.935914));
        santiago.setRef(getContext().getDrawable(R.drawable.santiago));
        locations.add(santiago);

        Location canto = new Location();
        canto.setNickName("Centro de Salud de Canto del Llano");
        canto.setId("3");
        canto.setPhone("958-6255");
        canto.setLocation(new LatLng(8.077322, -80.935914));
        canto.setRef(getContext().getDrawable(R.drawable.llano));
        locations.add(canto);

        Location poli = new Location();
        poli.setNickName("Policlinica Horacio Diaz");
        poli.setId("4");
        poli.setPhone("998-54-86");
        poli.setLocation(new LatLng(8.077322, -80.935914));
        poli.setRef(getContext().getDrawable(R.drawable.poli));
        locations.add(poli);

        Location juan = new Location();
        juan.setNickName("Clinica Especializada San Juan de Dios");
        juan.setId("5");
        juan.setPhone("998-5583");
        juan.setLocation(new LatLng(8.077322, -80.935914));
        juan.setRef(getContext().getDrawable(R.drawable.san));
        locations.add(juan);

        return locations;


    }
}