package com.dark_tech.pandemian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.dark_tech.pandemian.hospital.HospitalFragment;
import com.dark_tech.pandemian.report.PersonalFragment;
import com.dark_tech.pandemian.vaccine.VaccineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mNavigation;

    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigation = findViewById(R.id.navigation);

        mNavigation.setOnNavigationItemSelectedListener(this);

        currentFragment = new PersonalFragment();
        loadFragment( currentFragment );
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.report:
                currentFragment = new PersonalFragment();
                break;
            case R.id.location:
                currentFragment = new HospitalFragment();
                break;
            case R.id.vaccine:
                currentFragment = new VaccineFragment();
                break;
        }

        return loadFragment( currentFragment );
    }

    private boolean loadFragment(Fragment currentFragment) {
        if (currentFragment != null){
            getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, currentFragment)
                        .addToBackStack(null)
                        .commit();
        }
        return false;
    }
}
