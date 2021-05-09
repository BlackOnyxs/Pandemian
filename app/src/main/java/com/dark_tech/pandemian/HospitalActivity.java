package com.dark_tech.pandemian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.dark_tech.pandemian.adapters.HospitalAdapter;
import com.dark_tech.pandemian.adapters.HospitalClickLister;
import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.utils.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity implements HospitalClickLister {
    private RecyclerView rvHospitals;
    private HospitalAdapter hospitalAdapter;
    private DBConnection dbConnection;
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        rvHospitals = findViewById(R.id.rvHospitals);
        hospitalAdapter = new HospitalAdapter(new ArrayList<Location>(), this, getApplicationContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

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

    }

    @Override
    public void onClick(Location location) {
        HospitalSingleton singleton = HospitalSingleton.getInstance();
        singleton.setLocation(location);
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
