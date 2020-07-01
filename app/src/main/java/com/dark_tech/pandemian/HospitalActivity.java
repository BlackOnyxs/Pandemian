package com.dark_tech.pandemian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.dark_tech.pandemian.adapters.HospitalAdapter;
import com.dark_tech.pandemian.adapters.HospitalClickLister;
import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.utils.Utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity implements HospitalClickLister {
    private RecyclerView rvHospitals;
    private HospitalAdapter hospitalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        rvHospitals = findViewById(R.id.rvHospitals);
        hospitalAdapter = new HospitalAdapter(new ArrayList<Location>(), this, getApplicationContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rvHospitals.setLayoutManager(manager);
        rvHospitals.setAdapter(hospitalAdapter);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference();

//        Upload hospital's sample data
        /*for (Location location:
                Utils.getHospitals()) {
            reference.child("Hospitals").push().setValue(location);
        }
*/
        reference.child("Hospitals").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:
                     dataSnapshot.getChildren()) {
                    hospitalAdapter.add(snap.getValue(Location.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(Location location) {
        HospitalSingleton singleton = HospitalSingleton.getInstance();
        singleton.setLocation(location);
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
