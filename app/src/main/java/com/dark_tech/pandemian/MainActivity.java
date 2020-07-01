package com.dark_tech.pandemian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLocation, btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnLocation = findViewById(R.id.btnLocation);
         btnAdd = findViewById(R.id.btnAdd);

         btnLocation.setOnClickListener(this);
         btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case (R.id.btnAdd):
                intent = new Intent(this, PatientActivity.class);
                break;
            case (R.id.btnLocation):
                intent = new Intent(this, HospitalActivity.class);
                break;
        }
        startActivity(intent);
    }


}
